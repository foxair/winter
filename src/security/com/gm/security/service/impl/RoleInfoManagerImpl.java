package com.gm.security.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gm.common.orm.mybatis.QueryRequest;
import com.gm.common.service.BaseManager;
import com.gm.common.utils.tree.pojo.TreeNode;
import com.gm.security.dao.RoleInfoDao;
import com.gm.security.model.RoleInfo;
import com.gm.security.service.RoleInfoManager;

@Service("roleInfoManager")
@Transactional
public class RoleInfoManagerImpl extends BaseManager<RoleInfo, java.lang.Long> implements RoleInfoManager {

	private RoleInfoDao roleInfoDao;

	@Resource
	public void setRoleInfoDao(RoleInfoDao dao) {
		this.roleInfoDao = dao;
	}

	public RoleInfoDao getEntityDao() {
		return this.roleInfoDao;
	}

	@Override
	public List<TreeNode> getRoleTree() {
		TreeNode root = new TreeNode();
		RoleInfo roleFilter = new RoleInfo();
		roleFilter.setSuperRoleId(0L);//根节点Id为0
		QueryRequest query = new QueryRequest(roleFilter, RoleInfo.ROLE_INFO_ID + QueryRequest.ORDER_DESC);
		List<RoleInfo> roles = roleInfoDao.find(query);
		root.setId("0");
		root.setText("角色树");
		root.setChildren(getRoleNode(roles));
		List<TreeNode> roleTree = new ArrayList<TreeNode>();
		roleTree.add(root);
		return roleTree;
	}

	@Override
	public List<TreeNode> getRoleNodes(Long superId) {
		if (superId == null)
			superId = 0L;
		RoleInfo roleFilter = new RoleInfo();
		roleFilter.setSuperRoleId(superId);//根节点Id为0
		QueryRequest query = new QueryRequest(roleFilter, RoleInfo.ROLE_INFO_ID + QueryRequest.ORDER_DESC);
		List<RoleInfo> roles = roleInfoDao.find(query);
		List<TreeNode> roleNodes = getRoleNode(roles);
		//root.setLeaf(false);
		return roleNodes;
	}

	public List<TreeNode> getRoleNode(List<RoleInfo> roles) {
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		for (RoleInfo role : roles) {
			TreeNode node = new TreeNode();
			node.setId(String.valueOf(role.getRoleInfoId()));
			node.setText(role.getRoleName());
			List<RoleInfo> subRoles = getRoleListBySupperId(role.getRoleInfoId());
			if (subRoles.size() != 0) {
				node.setState("closed");
				node.setAttributes(getRoleNode(subRoles));
			}else{
				node.setLeaf(true);
			}
			nodes.add(node);
		}
		return nodes;
	}

	public boolean hasSubRole(Long roleId) {
		RoleInfo roleQuery = new RoleInfo();
		roleQuery.setSuperRoleId(roleId);
		Long count = roleInfoDao.getCount(roleQuery);
		return count > 0;
	}

	public List<RoleInfo> getRoleListBySupperId(Long superId) {
		RoleInfo roleFilter = new RoleInfo();
		roleFilter.setSuperRoleId(superId);
		List<RoleInfo> roles = roleInfoDao.find(roleFilter, RoleInfo.ROLE_INFO_ID + QueryRequest.ORDER_DESC);
		return roles;
	}

}

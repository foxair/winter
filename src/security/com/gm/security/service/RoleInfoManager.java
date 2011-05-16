package com.gm.security.service;

import java.util.List;

import com.gm.common.service.Manager;
import com.gm.common.utils.tree.pojo.TreeNode;
import com.gm.security.dao.RoleInfoDao;
import com.gm.security.model.RoleInfo;

public interface RoleInfoManager extends Manager<RoleInfo, java.lang.Long> {

	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setRoleInfoDao(RoleInfoDao dao);
	
	/**
	 * 获取角色树型结构
	 */
	public List<TreeNode> getRoleTree();

	/**
	 * 获取指定父Id节点下的角色树型结构
	 */
	List<TreeNode> getRoleNodes(Long superId);

}

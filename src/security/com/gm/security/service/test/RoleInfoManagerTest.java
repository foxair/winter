package com.gm.security.service.test;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.core.annotation.Order;

import com.gm.common.test.BaseServiceTestCase;
import com.gm.common.utils.JsonUtils;
import com.gm.common.utils.tree.pojo.TreeNode;
import com.gm.security.service.RoleInfoManager;

public class RoleInfoManagerTest extends BaseServiceTestCase {
	private static final Logger logger = Logger.getLogger(RoleInfoManagerTest.class);

	@Resource
	RoleInfoManager roleInfoManager;

	@Test
	@Order(1)
	public void roleTree() {
		List<TreeNode> roleTree = roleInfoManager.getRoleNodes(0L);
		System.out.println(JsonUtils.toJSONString(roleTree));
	}

}

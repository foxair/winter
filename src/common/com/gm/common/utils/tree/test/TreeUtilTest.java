package com.gm.common.utils.tree.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.gm.common.utils.JsonUtils;
import com.gm.common.utils.tree.pojo.TreeNode;

public class TreeUtilTest {
	public static void main(String[] args) {
		List<TreeNode> nodeList = new ArrayList<TreeNode>();

		TreeNode node1 = new TreeNode();
		TreeNode node2 = new TreeNode();
		TreeNode node3 = new TreeNode();
		TreeNode node4 = new TreeNode();
		TreeNode node5 = new TreeNode();
		TreeNode node6 = new TreeNode();

		node3.setId("3");
		node3.setText("节点3");

		node4.setId("4");
		node4.setText("节点4");

		node5.setId("5");
		node5.setText("节点5");

		node6.setId("6");
		node6.setText("节点6");

		node1.setId("1");
		node1.setText("节点1");
		node1.setLeaf(false);

		node2.setId("2");
		node2.setText("节点2");
		node2.setLeaf(false);

		nodeList.add(node1);
		nodeList.add(node2);

		String extTreeStr;
		extTreeStr = JsonUtils.toJSONString(nodeList);
		System.out.println(extTreeStr);
	}

}

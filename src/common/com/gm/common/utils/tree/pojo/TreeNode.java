package com.gm.common.utils.tree.pojo;

import java.util.Collection;

/**
 * @function 树节点模型
 * @author Azheng Mar 26, 2009 7:26:32 AM
 */
public class TreeNode {

	protected Object attributes;

	/**
	 * file or folder
	 */
	protected String cls = "folder";
	protected String id;
	protected String text;
	/**
	 * 是否有下级节点
	 */
	protected boolean isLeaf;
	protected String href;
	protected String hrefTarget;
	protected Boolean checked;
	protected Boolean disabled;
	protected Boolean expanded;
	protected String state;
	protected String icon;
	/**
	 * 提示
	 */
	protected String qtip;
	protected Collection<TreeNode> children;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	/**
	 * 当前节点追加子节点
	 */
	public void addChildNode(TreeNode node) {
		this.children.add(node);
	}

	/**
	 * 构造子
	 */
	public TreeNode() {
		text = "new node";
		isLeaf = true;
	}

	/**  Getter Setter  */

	public Collection<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(Collection<TreeNode> children) {
		this.children = children;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getHrefTarget() {
		return hrefTarget;
	}

	public void setHrefTarget(String hrefTarget) {
		this.hrefTarget = hrefTarget;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getQtip() {
		return qtip;
	}

	public void setQtip(String qtip) {
		this.qtip = qtip;
	}

	public Object getAttributes() {
		return attributes;
	}

	public void setAttributes(Object attributes) {
		this.attributes = attributes;
	}

	public String getCls() {
		return cls;
	}

	public void setCls(String cls) {
		this.cls = cls;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public Boolean getExpanded() {
		return expanded;
	}

	public void setExpanded(Boolean expanded) {
		this.expanded = expanded;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

}

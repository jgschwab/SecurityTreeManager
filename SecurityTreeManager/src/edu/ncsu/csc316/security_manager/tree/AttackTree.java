package edu.ncsu.csc316.security_manager.tree;

import edu.ncsu.csc316.security_manager.attack.AttackStep;
import edu.ncsu.csc316.security_manager.list.AttackList;

/**
 * The Attack Tree, which is a general tree that
 * stores AttackSteps as AttackNodes
 * @author Justin Schwab
 *
 */
public class AttackTree {
	public AttackNode root;
	
	public AttackTree(AttackStep root){
		this.root = new AttackNode(root);
	}
	
	/**
	 * Nodes that make up this AttackTree. Each Node
	 * contains an AttackStep and a list of children
	 * @author Justin Schwab
	 *
	 */
	public class AttackNode{
		private AttackStep data;
		private AttackList children;
		public AttackNode(AttackStep data){
			this.data = data;
			this.children = null;
		}
		
		/**
		 * Adds an AttackStep to the tree as an AttackNode
		 * @param s
		 */
		public void addChild(AttackNode n){
			this.children.add(n);
		}
	}
}
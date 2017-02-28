package edu.ncsu.csc316.security_manager.tree;

import edu.ncsu.csc316.security_manager.attack.AttackStep;
import edu.ncsu.csc316.security_manager.list.Queue;

/**
 * The Attack Tree, which is a general tree that
 * stores AttackSteps as AttackNodes
 * 
 * @author Justin Schwab
 */
public class AttackTree {
	/** The root of the Attack Tree */
	public AttackNode root;
	
	/**
	 * Constructs an attack tree with a root Node
	 * @param root The root node to start the Attack Tree
	 */
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
		/** The AttackStep data associated with each node */
		private AttackStep data;
		/** The list of children for each node */
		private Queue<AttackNode> children;
		
		/**
		 * Constructs a node with specified data
		 * @param data The AttackStep to store in this node
		 */
		public AttackNode(AttackStep data){
			this.data = data;
			this.children = null;
		}
		
		/**
		 * Adds an AttackStep to the tree as an AttackNode
		 * @param s
		 */
		public void addChild(AttackNode n){
			this.children.enqueue(n);
		}
	}
}
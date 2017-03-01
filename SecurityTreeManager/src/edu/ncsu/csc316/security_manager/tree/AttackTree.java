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
	 * Produces a level-order traversal as a Queue
	 * @return The level-order traversal
	 */
	public Queue<AttackStep> levelOrder(){
		Queue<AttackStep> list = new Queue<AttackStep>();
		Queue<AttackNode> q = new Queue<AttackNode>();
		if(this.root == null)
			return list;
		q.enqueue(root);
		while(!q.isEmpty()){
			AttackNode n = q.dequeue();
			list.enqueue(n.data);
			Queue<AttackNode> children = n.getChildren();
			while(!children.isEmpty()){
				q.enqueue(children.dequeue());
			}		
		}
		return list;
	}
	
	/**
	 * Nodes that make up this AttackTree. Each Node
	 * contains an AttackStep and a list of children
	 * @author Justin Schwab
	 *
	 */
	public static class AttackNode {
		
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
			this.children = new Queue<AttackNode>();
		}
		
		/**
		 * Adds an AttackStep to the tree as an AttackNode
		 * @param n The AttackNode to add a child to
		 */
		public void addChild(AttackNode n){
			this.children.enqueue(n);
		}
		
		/**
		 * Adds an AttackStep to the tree 
		 * @param s The AttackStep to add as a child node
		 */
		public void addChild(AttackStep s) {
			this.children.enqueue(new AttackNode(s));
		}
		
		/**
		 * Gets the AttackStep data for this Node
		 * @return The AttackStep associated with this AttackNode
		 */
		public AttackStep getData(){
			return this.data;
		}
		
		/**
		 * Gets the children of this Node as a copy
		 * @return The list of children for this Node
		 */
		public Queue<AttackNode> getChildren(){
			return this.children.clone();
		}
	}
}
package edu.ncsu.csc316.security_manager.tree;

import edu.ncsu.csc316.security_manager.log.LogEntry;

/**
 * The Binary Search Tree used for storing log entries
 * @author Justin Schwab
 */
public class LogTree {
	public LogNode root;
	/**
	 * Nodes that make up this LogTree. Each node contains
	 * a log entry and up to two children
	 * @author Justin Schwab
	 *
	 */
	public class LogNode{
		private LogEntry data;
		private LogNode left;
		private LogNode right;
		/**
		 * Constructs a LogNode, given its LogEntry and children
		 * @param data The LogEntry that this LogNode represents
		 * @param left The left child of this LogNode
		 * @param right The right child of this LogNode
		 */
		public LogNode(LogEntry data, LogNode left, LogNode right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
	public void add(LogNode n){
		//TODO implement recursive algorithm
	}
}
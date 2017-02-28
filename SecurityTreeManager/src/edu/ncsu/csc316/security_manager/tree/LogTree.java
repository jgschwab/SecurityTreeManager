package edu.ncsu.csc316.security_manager.tree;

import java.util.Scanner;

import edu.ncsu.csc316.security_manager.date.Date;
import edu.ncsu.csc316.security_manager.list.Queue;
import edu.ncsu.csc316.security_manager.log.LogEntry;

/**
 * A Binary Search Tree used for storing log entries
 * 
 * @author Justin Schwab
 */
public class LogTree {
	
	/** The root of the Log Entry tree */
	public LogNode root;
	
	/**
	 * Constructs a new, empty LogTree
	 */
	public LogTree(){
		root = null;
	}
	
	/**
	 * Adds a node to this tree in a way
	 * to retain the search property
	 * @param n The node to add to this tree
	 */
	public void add(LogNode n){
		if(root == null){
			root = n;
		} else{
			addHelper(n, root);
		}
	}
	
	/**
	 * Private helper method to recursively insert the 
	 * node into the BST, retaining the search property.
	 * @param n The node to insert
	 * @param root The node used to traverse down the BST.
	 */
	private void addHelper(LogNode n, LogNode root){
		if(n.data.compareTo(root.data) < 0){ // smaller than root
			if(root.left == null){
				root.left = n;
			}else{
				addHelper(n, root.left);
			}
		} else if(n.data.compareTo(root.data) > 0){
			if(root.right == null){
				root.right = n;
			}else{
				addHelper(n, root.right);
			}
		} else{
			return;
		}
	}
	
	/**
	 * Nodes that make up this LogTree. Each node contains
	 * a log entry and up to two children
	 * 
	 * @author Justin Schwab
	 */
	public static class LogNode{
		/** The LogEntry data associated with this node */
		private LogEntry data;
		/** The left child of this node */
		private LogNode left;
		/** The right child of this node */
		private LogNode right;
		
		/**
		 * Constructs a LogNode, given its LogEntry and children
		 * @param data The LogEntry that this LogNode represents
		 */
		public LogNode(LogEntry data){
			this.data = data;
		}
	}

	/**
	 * Searches the LogTree for all entries on a certain
	 * day, expressed by the parameterized String
	 * @param date The date to find entries for
	 * @return The list of entries from that day
	 */
	public Queue<LogEntry> lookUp(String date) {
		Queue<LogEntry> list = new Queue<LogEntry>();
		Scanner dateScan = new Scanner(date);
		dateScan.useDelimiter("-");
		Date day = new Date(Integer.parseInt(dateScan.next()),
						Integer.parseInt(dateScan.next()),
						Integer.parseInt(dateScan.next()));
		dateScan.close();
		LogNode n = root;
		//while...
		
		
		return list;
	}

	
}
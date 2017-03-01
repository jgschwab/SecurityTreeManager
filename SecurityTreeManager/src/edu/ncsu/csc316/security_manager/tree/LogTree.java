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
			} else{
				addHelper(n, root.left);
			}
		} else if(n.data.compareTo(root.data) > 0){
			if(root.right == null){
				root.right = n;
			} else{
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
	public static class LogNode {
		/** The LogEntry data associated with this node */
		private LogEntry data;
		/** The left child of this node */
		private LogNode left;
		/** The right child of this node */
		private LogNode right;
		
		/**
		 * Constructs a LogNode, given its LogEntry data
		 * @param data The LogEntry that this LogNode represents
		 */
		public LogNode(LogEntry data){
			this.data = data;
		}
	}

	/**
	 * Searches the LogTree for all entries on a certain
	 * day, expressed by the parameterized String
	 * @param dateStr The date to find entries for
	 * @return The list of entries from that day
	 */
	public Queue<LogEntry> lookUp(String dateStr) {
		Queue<LogEntry> list = new Queue<LogEntry>();
		Scanner dateScan = new Scanner(dateStr);
		dateScan.useDelimiter("-");
		int month = Integer.parseInt(dateScan.next());
		int day = Integer.parseInt(dateScan.next());
		int year = Integer.parseInt(dateScan.next());
		Date date = new Date(year, month, day);
		dateScan.close();
		LogNode n = root;
		while(date.compareTo(n.data.getTimeStamp().getDate()) != 0){ //maybe could have done this recursively...
			if(date.compareTo(n.data.getTimeStamp().getDate()) < 0){
				if(n.left == null){
					return list;
				} else{
					n = n.left;
				}
			} else if(date.compareTo(n.data.getTimeStamp().getDate()) > 0){
				if(n.right == null){
					return list;
				} else{
					n = n.right;
				}
			}
		}
		inOrderSearch(n, list, date);
		return list;
	}

	/**
	 * Recursive helper to in-order traverse the relevant subtree
	 * @param n The top node of the in-order traversal
	 * @param list The list of log entries to add to
	 * @param date The date to search for in log entries
	 */
	private void inOrderSearch(LogNode n, Queue<LogEntry> list, Date date) {
		if(n.left != null)
			inOrderSearch(n.left, list, date);
		if(n.data.getTimeStamp().getDate().compareTo(date) == 0)
			list.enqueue(n.data);
		if(n.right != null)
			inOrderSearch(n.right, list, date);
	}

	/**
	 * Generates a level-order traversal and returns it as a queue
	 * @return A level-order traversal of this log tree
	 */
	public Queue<LogEntry> levelOrder() {
		Queue<LogEntry> list = new Queue<LogEntry>();
		Queue<LogNode> q = new Queue<LogNode>();
		if(root == null)
			return list;
		q.enqueue(root);
		while(!q.isEmpty()){
			LogNode n = q.dequeue();
			list.enqueue(n.data);
			if(n.left != null)
				q.enqueue(n.left);
			if(n.right != null)
				q.enqueue(n.right);			
		}
		return list;
	}
}
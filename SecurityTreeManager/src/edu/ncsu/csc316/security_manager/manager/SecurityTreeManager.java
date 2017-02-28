package edu.ncsu.csc316.security_manager.manager;

import edu.ncsu.csc316.security_manager.attack.AttackStep;
import edu.ncsu.csc316.security_manager.io.FileReader;
import edu.ncsu.csc316.security_manager.list.Queue;
import edu.ncsu.csc316.security_manager.log.LogEntry;
import edu.ncsu.csc316.security_manager.tree.AttackTree;
import edu.ncsu.csc316.security_manager.tree.LogTree;
import edu.ncsu.csc316.security_manager.tree.LogTree.LogNode;

/**
 * The main class in the model part of this software.
 * Contains an Attack tree which is produced from the
 * buildAttackTree() method and a Log tree which one 
 * can search using the getLogEntriesForDate() method.
 * 
 * @author Justin Schwab
 */
public class SecurityTreeManager {
	/** The Attack tree for this SecurityTreeManager */
	private AttackTree atkTree;
	/** The Log entry tree for this SecurityTreeManager */
	private LogTree logTree;
	
	/**
	 * Builds The attack tree using a preorder list and postorder list
	 * @param preorder The preorder list to build the attack tree from
	 * @param postOrder The postorder list to build the attack tree from
	 */
	public void buildAttackTree(Queue<AttackStep> preorder, Queue<AttackStep> postOrder){
		//TODO implement
	}
	
	/**
     * Constructs a new SecurityTreeManager object with the given paths 
     * to the preOrder and postOrder traversal files.
     * @param preOrder - the path to the preOrder traversal file
     * @param postOrder - the path to the postOrder traversal file
     */
	public SecurityTreeManager(String preOrder, String postOrder){
		//TODO implement
	}
	
	
	/**
     * Constructs a new SecurityTreeManager object with the given path
     * to the file that contains the log entries.
     * @param filePath - the path to the log entry file
     */
	public SecurityTreeManager(String filePath){
		logTree = new LogTree();
		Queue<LogEntry> logs = FileReader.readLogFile(filePath);
		while(!logs.isEmpty()){
			logTree.add(new LogNode(logs.dequeue()));
		}
	}
	
	
	/**
     * Returns the level order traversal of the Attack Tree
     * as a string in the format (where each "node" is indented 3 spaces):
     * 
     * LevelOrder[
     *    GOAL Step[Use DDoS Attack to Disrupt All Users, C=0.00, P=0.000, I=0.00]
     *    OR Step[Attack Servers, C=0.00, P=0.000, I=0.00]
     *    OR Step[Attack Comm Infrastructure, C=0.00, P=0.000, I=0.00]
     * ]
     *
     * THE LEVEL ORDER TRAVERSAL MUST NOT RETURN ANY OF THE PROPAGATED VALUES!
     * 
     * @return the level order traversal (as a string) of the attack tree
     */
	public String getAttackTreeLevelOrder(){
		return null;
		//TODO implement
	}
	
	
	/**
     * Return the level order traversal of the Log Tree
     * as a string in the format (where each "node" is indented 3 spaces):
     * 
     * LevelOrder[
     *    LogEntry[timestamp=2015/09/13 02:58:49, user=user2, description=save patient list]
     *    LogEntry[timestamp=2012/12/18 16:25:58, user=user18, description=view diagnoses]
     *    LogEntry[timestamp=2016/12/12 06:28:13, user=user6, description=edit patient representative list]
     * ]
     * 
     * @return the level order traversal (as a string) of the log tree
     */
	public String getLogTreeLevelOrder(){
		return null;
		//TODO implement
	}
	
	
	/**
     * Returns the values (as a string) propagated to the root node
     * using the formulas from the project writeup.
     * For example:
     * GOAL Step[Use DDoS Attack to Disrupt All Users, C=21557.12, P=0.878, I=8.00]
     * 
     * @return the metric values (as a string) that are propagated to the root node
     */
	public String propagateValues(){
		return null;
		//TODO implement
	}
	
	
	/**
     * Returns (as a string, sorted in increasing order) the log entries 
     * for the given date in the format:
     * 
     * LogEntry[timestamp=2015/07/17 15:49:38, user=user4, description=print calendar]
     * LogEntry[timestamp=2015/07/17 15:55:25, user=user8, description=save immunizations]
     * 
     * @param date - the date, in the format MM-DD-YYYY
     * @return the string representation of the log entries for the specified date
     */
	public String getLogEntriesForDate(String date){
		Queue<LogEntry> levelOrderList = logTree.lookUp(date);
		StringBuilder sb = new StringBuilder();
		while(!levelOrderList.isEmpty()){
			sb.append(levelOrderList.dequeue().toString() + "\n");
		}
		return sb.toString();
	}
}
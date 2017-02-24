package edu.ncsu.csc316.security_manager.manager;

import edu.ncsu.csc316.security_manager.attack.AttackStep;
import edu.ncsu.csc316.security_manager.tree.AttackTree;
import edu.ncsu.csc316.security_manager.tree.LogTree;

public class SecurityTreeManager {
	private AttackTree atkTree;
	private LogTree logTree;
	
	public void buildAttackTree(AttackStep[] preorder, AttackStep[] postOrder){
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
		//TODO implement
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
		return null;
		//TODO implement
	}
}

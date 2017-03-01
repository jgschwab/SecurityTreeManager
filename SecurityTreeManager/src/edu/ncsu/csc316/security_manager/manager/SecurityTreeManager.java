package edu.ncsu.csc316.security_manager.manager;

import edu.ncsu.csc316.security_manager.attack.AttackStep;
import edu.ncsu.csc316.security_manager.io.FileReader;
import edu.ncsu.csc316.security_manager.list.Queue;
import edu.ncsu.csc316.security_manager.log.LogEntry;
import edu.ncsu.csc316.security_manager.tree.AttackTree;
import edu.ncsu.csc316.security_manager.tree.AttackTree.AttackNode;
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
	 * @param preOrder The preorder list to build the attack tree from
	 * @param postOrder The postorder list to build the attack tree from
	 */
	public void buildAttackTree(Queue<AttackStep> preOrder, Queue<AttackStep> postOrder){
		AttackStep[] pre = new AttackStep[preOrder.size()];
		for(int i = 0; !preOrder.isEmpty(); i++){
			pre[i] = preOrder.dequeue();
		}
		AttackStep[] post = new AttackStep[postOrder.size()];
		for(int i = 0; !postOrder.isEmpty(); i++){
			post[i] = postOrder.dequeue();
		}
		if(pre.length == 1){
			atkTree = new AttackTree(new AttackStep(pre[0].getTag(), pre[0].getProb(),
					pre[0].getImpact(), pre[0].getCost(), pre[0].getDesc()));
		} else{
			atkTree = new AttackTree(pre[0]);
			pre = subArray(pre, 1, pre.length - 1);
			post = subArray(post, 0, post.length - 2);
			build(pre, post, atkTree.root);
		}
	}
	
	/**
	 * Private helper to get a specific sub-array of a passed-in array
	 * @param list The array to return a portion of
	 * @param i The starting index to copy
	 * @param j The terminal index to copy
	 * @return A partial copy of the parameterized list from index i to j
	 */
	private AttackStep[] subArray(AttackStep[] list, int i, int j) {
		AttackStep[] ret = new AttackStep[j - i + 1];
		int k = 0;
		while(i <= j){
			ret[k] = list[i];
			k++;
			i++;
		}
		return ret;
	}

	/**
	 * Gets the index of an AttackStep in a given AttackStep array
	 * @param list The array to search for the given AttackStep 
	 * @param n The AttackStep to search for
	 * @return The index of the given AttackStep in the given array
	 */
	private int indexOf(AttackStep[] list, AttackStep n) {
		for(int i = 0; i < list.length; i++){
			if(list[i].equals(n)){
				return i;
			}
		}
		return -1;
	}

	/**
	 * FUCK SHIT I HOPE THIS WORKS
	 * @param pre The pre-order traversal of the tree
	 * @param post The post-order traversal of the tree
	 * @param current The current node that this algorithm is inspecting
	 */
	private void build(AttackStep[] pre, AttackStep[] post, AttackNode current) {
		if(pre.length == 1){
			current.addChild(pre[0]);
		} else{
			int p = 0;
			while(p < pre.length){
				if(pre[p].equals(post[p])){
					AttackStep[] leaf = new AttackStep[1];
					leaf[0] = pre[p];
					build(leaf, leaf, current);
					p++;
				} else{
					AttackNode child = new AttackNode(pre[p]);
					current.addChild(child);
					build(subArray(pre, p + 1, indexOf(post, pre[p])),
							subArray(post, p, indexOf(post, pre[p]) - 1), child);
					p = indexOf(post, pre[p]) + 1;
				}
			}
		}
	}

	/**
     * Constructs a new SecurityTreeManager object with the given paths 
     * to the preOrder and postOrder traversal files.
     * @param preOrder - the path to the preOrder traversal file
     * @param postOrder - the path to the postOrder traversal file
     */
	public SecurityTreeManager(String preOrder, String postOrder){
		FileReader f = new FileReader();
		Queue<AttackStep> pre = f.readAttackTraversal(preOrder);
		Queue<AttackStep> post = f.readAttackTraversal(postOrder);
		buildAttackTree(pre, post);
	}
	
	/**
     * Constructs a new SecurityTreeManager object with the given path
     * to the file that contains the log entries.
     * @param filePath - the path to the log entry file
     */
	public SecurityTreeManager(String filePath){
		FileReader f = new FileReader();
		logTree = new LogTree();
		Queue<LogEntry> logs = f.readLogFile(filePath);
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
		Queue<AttackStep> list = atkTree.levelOrder();
		StringBuilder sb = new StringBuilder();
		while(!list.isEmpty()){
			AttackStep step = list.dequeue();
			sb.append("   " + step.toString() + "\n");
		}
		return "LevelOrder[\n" + sb.toString() + "]";
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
		Queue<LogEntry> list = logTree.levelOrder();
		StringBuilder sb = new StringBuilder();
		while(!list.isEmpty()){
			sb.append("   " + list.dequeue().toString() + "\n");
		}
		return "LevelOrder[\n" + sb.toString() + "]";
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
		propagate(atkTree.root);
		return atkTree.root.getData().toString();
	}
	
	/**
	 * Recursive helper method to propagate data up the tree
	 * @param current The current node that the algorithm is inspecting
	 */
	private void propagate(AttackNode current) {
		Queue<AttackNode> children = current.getChildren();
		for(int i = 0; i < children.size(); i++){
			AttackNode child = children.dequeue();
			children.enqueue(child);
			if(child.getChildren().size() != 0){
				propagate(child);
			}
		}
		calculate(current);
	}

	/**
	 * Calculates the values of a node, based on its children's values
	 * @param n The node to calculate values for
	 */
	private void calculate(AttackNode n) {
		Queue<AttackNode> children = n.getChildren();
		if(children.size() == 0)
			return;
		if(children.peek().getData().getTag() == 'A'){
			double prob = 1;
			for(int i = 0; i < children.size(); i++){ //probability mult.
				AttackNode child = children.dequeue();
				children.enqueue(child);
				prob *= child.getData().getProb();
			}
			n.getData().setProb(prob);
			double cost = 0;
			for(int i = 0; i < children.size(); i++){
				AttackNode child = children.dequeue();
				children.enqueue(child);
				cost += child.getData().getCost();
			}
			n.getData().setCost(cost);
			double impact = 1;
			for(int i = 0; i < children.size(); i++){
				AttackNode child = children.dequeue();
				children.enqueue(child);
				impact *= (10 - child.getData().getImpact());
			}
			n.getData().setImpact((Math.pow(10, children.size()) - impact) 
					/ Math.pow(10, children.size() - 1 ) );
		} else{
			double prob = 1;
			for(int i = 0; i < children.size(); i++){ //probability mult.
				AttackNode child = children.dequeue();
				children.enqueue(child);
				prob *= (1 - child.getData().getProb());
			}
			n.getData().setProb(1 - prob);
			double cost = 0;
			prob = 0;
			for(int i = 0; i < children.size(); i++){
				AttackNode child = children.dequeue();
				children.enqueue(child);
				cost += (child.getData().getCost() * child.getData().getProb());
				prob += child.getData().getProb();
			}
			n.getData().setCost(cost / prob);
			double impact = 0;
			for(int i = 0; i < children.size(); i++){
				AttackNode child = children.dequeue();
				children.enqueue(child);
				if(child.getData().getImpact() > impact){
					impact = child.getData().getImpact();
				}
			}
			n.getData().setImpact(impact);
		}
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
		Queue<LogEntry> inOrderList = logTree.lookUp(date);
		StringBuilder sb = new StringBuilder();
		while(inOrderList.size() > 1){
			sb.append(inOrderList.dequeue().toString() + "\n");
		}
		sb.append(inOrderList.dequeue().toString());
		return sb.toString();
	}
}
package edu.ncsu.csc316.security_manager.tree;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.security_manager.attack.AttackStep;
import edu.ncsu.csc316.security_manager.list.Queue;
import edu.ncsu.csc316.security_manager.tree.AttackTree.AttackNode;

/**
 * Tests the AttackTree class
 * @author Justin Schwab
 *
 */
public class AttackTreeTest {

	/**
	 * Tests the methods in the AttackTree class
	 */
	@Test
	public void test() {
		AttackTree atk = new AttackTree(new AttackStep('G', 0, 0, 0, "Use DDoS Attack to Disrupt All Users"));
		atk.root.addChild(new AttackNode(new AttackStep('O', 0.4, 8, 74000, "Bomb the server room")));
		atk.root.getChildren().dequeue().addChild(new AttackNode(new AttackStep('A', 0.8, 2, 23000, "Buy some thermite")));
		atk.root.getChildren().dequeue().addChild(new AttackNode(new AttackStep('A', 0.3, 6, 64000, "Hire a explosives technician")));
		Queue<AttackNode> list = atk.root.getChildren().dequeue().getChildren();
		list.dequeue();
		assertEquals("Hire a explosives technician", list.dequeue().getData().getDesc());
	}
}
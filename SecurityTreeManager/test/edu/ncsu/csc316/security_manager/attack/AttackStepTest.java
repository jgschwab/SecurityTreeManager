package edu.ncsu.csc316.security_manager.attack;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the AttackStep class
 * @author Justin Schwab
 *
 */
public class AttackStepTest {

	/**
	 * Tests the methods in AttackStep
	 */
	@Test
	public void test() {
		AttackStep as0 = new AttackStep('G', 0.52, 6.3, 52000, "description of the goal");
		assertEquals('G', as0.getTag());
		assertEquals(0.52, as0.getProb(), 0.01);
		assertEquals(6.3, as0.getImpact(), 0.01);
		assertEquals(52000, as0.getCost(), 0.01);
		assertEquals("description of the goal", as0.getDesc());
		
		as0.setCost(34000);
		as0.setImpact(9);
		as0.setProb(0.59);
		assertEquals(0.59, as0.getProb(), 0.01);
		assertEquals(9, as0.getImpact(), 0.01);
		assertEquals(34000, as0.getCost(), 0.01);
		
		try{
			as0 = new AttackStep('J', 0.52, 6.3, 52000, "invalid sub-goal");
		} catch(IllegalArgumentException e){
			assertEquals("Invalid AttackStep tag", e.getMessage());
		}
		assertEquals(0.59, as0.getProb(), 0.01);
		assertEquals(9, as0.getImpact(), 0.01);
		assertEquals(34000, as0.getCost(), 0.01);
		assertEquals('G', as0.getTag());
		assertEquals("description of the goal", as0.getDesc());
	}
}
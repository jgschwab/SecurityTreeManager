package edu.ncsu.csc316.security_manager.list;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public class QueueTest {

	@Test
	public void test() {
		Queue<String> q1 = new Queue<String>();
		assertTrue(q1.isEmpty());
		assertEquals(0, q1.size());
		try{
			q1.dequeue();
		} catch(NoSuchElementException e){
			assertEquals("Queue is empty; cannot dequeue.", e.getMessage());
		}
		
		q1.enqueue("pikachu");
		assertEquals(1, q1.size());
		try{
			q1.dequeue();
		} catch(NoSuchElementException e){
			fail();
		}
		
		assertTrue(q1.isEmpty());
		q1.enqueue("pikachu");
		assertEquals(1, q1.size());
		q1.enqueue("charmander");
		assertEquals(2, q1.size());
		q1.enqueue("flygon");
		assertEquals(3, q1.size());
		q1.enqueue("sceptile");
		assertEquals(4, q1.size());
		
		assertEquals("sceptile", q1.dequeue());
		assertEquals(3, q1.size());
		assertEquals("flygon", q1.dequeue());
		assertEquals(2, q1.size());
		assertEquals("charmander", q1.dequeue());
		assertEquals(1, q1.size());
		assertEquals("pikachu", q1.dequeue());
		assertEquals(0, q1.size());
		assertTrue(q1.isEmpty());
		try{
			q1.dequeue();
		} catch(NoSuchElementException e){
			assertEquals("Queue is empty; cannot dequeue.", e.getMessage());
		}
		assertTrue(q1.isEmpty());
	}
}
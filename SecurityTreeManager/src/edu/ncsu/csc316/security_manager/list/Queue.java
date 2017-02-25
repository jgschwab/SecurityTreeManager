package edu.ncsu.csc316.security_manager.list;

import java.util.NoSuchElementException;

/**
 * Defines a Circular-Linked-List-based Queue
 * @author Justin Schwab
 * @param <E> the element Type of the Linked Queue
 */
public class Queue<E> {
	
	private int size;
	private Node<E> back;
	
	/**
	 * Defines the Node in this linked queue
	 * @author Justin Schwab
	 * @param <T>
	 */
	public class Node<T>{
		private T data;
		private Node<T> next;
		public Node(T data, Node<T> next){
			this.data = data;
			this.next = next;
		}
	}
	/**
	 * Constructs the LinkedQueue with the parameterized capacity
	 * Note that the FRONT of the LinkedList refers to the FRONT of the Queue
	 */
	public Queue(){
		size = 0;
		back = null;
	}
	
	/**
	 * Adds an element to the back of the queue
	 * @param element The element to add
	 */
	public void enqueue(E element) {
		if(size == 0){
			back = new Node<E>(element, null);
		} else if(size == 1){
			back.next = new Node<E>(element, back);
		} else {
			back.next = new Node<E>(element, back.next);
		}
		size++;
	}

	/**
	 * Removes an element from the front of the queue
	 * @return The element that was removed from the queue
	 */
	public E dequeue(){
		E element = null;
		if(size == 0){
			throw new NoSuchElementException("Queue is empty; cannot dequeue.");
		} else if(size == 1){
			element = back.data;
			back = null;
		} else {
			Node<E> temp = back.next;
			back.next = back.next.next;
			element = temp.data;
			temp.next = null; // garbage-collect
		}
		size--;
		return element;
	}

	/**
	 * Determines whether or not the queue is empty
	 * @return True if the queue is empty
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * Gets the size of the queue
	 * @return size
	 */
	public int size() {
		return size;
	}
}

package edu.ncsu.csc316.security_manager.list;

import java.util.NoSuchElementException;

/**
 * Defines a Circular-Linked-List-based Queue
 * @author Justin Schwab
 * @param <E> the element type of the Linked Queue
 */
public class Queue<E> implements Cloneable {
	
	/** The number of elements in the queue */
	private int size;
	/** Reference to the last element of the queue */
	private Node<E> tail;
	
	/**
	 * Defines the Node in this linked queue
	 * @author Justin Schwab
	 * @param <T> The element type of the Node
	 */
	public class Node<T> {
		/** The data in this node */
		private T data;
		/** The next element in this queue */
		private Node<T> next;
		/**
		 * Constructs a new generic node
		 * @param data The data to instantiate the node with
		 * @param next A reference to the Node that this should point to
		 */
		public Node(T data, Node<T> next){
			this.data = data;
			this.next = next;
		}
	}
	
	/**
	 * Constructs the Linked Queue of size 0
	 */
	public Queue(){
		size = 0;
		tail = null;
	}
	
	/**
	 * Adds an element to the back of the queue
	 * @param element The element to add
	 */
	public void enqueue(E element) {
		if(size == 0){
			tail = new Node<E>(element, null);
		} else if(size == 1){
			tail.next = new Node<E>(element, tail);
			tail = tail.next;
		} else {
			tail.next = new Node<E>(element, tail.next);
			tail = tail.next;
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
			element = tail.data;
			tail = null;
		} else {
			Node<E> temp = tail.next;
			tail.next = tail.next.next;
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
	
	/**
	 * Clones this Queue
	 * @return A copy of this Queue
	 */
	@Override
	public Queue<E> clone(){
		Queue<E> copy = new Queue<E>();
		for(int i = 0; i < this.size; i++){
			E e = this.dequeue();
			copy.enqueue(e);
			this.enqueue(e);
		}
		return copy;
	}

	/**
	 * Gets the first element without removing it.
	 * This is useful for propagating values
	 * @return The element at the front of the list
	 */
	public E peek() {
		if(size == 0){
			return null;
		} else if(size == 1){
			return tail.data;
		} else{
			return tail.next.data;
		}
	}
}
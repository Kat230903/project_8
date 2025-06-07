/*
 * IOANNA KARDARA (p3210065)
 * AIKATERINH PALAIOLOGOY (p3210149)
 * file name: StringQueueImpl.java
 */

import java.util.NoSuchElementException;
import java.io.PrintStream;

public class StringQueueImpl<T> implements StringQueue<T>{
	private Node<T> head = null;
    private Node<T> tail = null;
	private int size = 0;
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public void put(T item) {
		Node<T> n = new Node<T>(item);
		if (isEmpty()) {
            head = n;
            tail = n;
        } 
		else {
            tail.setNext(n);
            tail = n;
        }
		size++;
	}
	
	public T get() throws NoSuchElementException {
		if (isEmpty()) throw new NoSuchElementException();
		
		T data = head.getData();
		if (head==tail) {
            head = tail = null;
		}	
        else {
            head = head.getNext();
		}
		size--;
        return data;
	}
	
	public T peek() throws NoSuchElementException {
		if (isEmpty()) throw new NoSuchElementException();
		T data = head.getData();
		return data;
	}
	
	public void printQueue(PrintStream stream) {
		PrintStream queue = new PrintStream(stream);
		Node<T> node = head; 
		while (node != null) {
			queue.println(node.getData());
			queue.flush();
			node = node.getNext();
		}
	}
	
	public int size() {
		return size;
	}

}
/*

 * file name: StringQueueWithOnePointerImpl.java
 */

import java.util.NoSuchElementException;
import java.io.PrintStream;

public class StringQueueWithOnePointerImpl<T> implements StringQueue<T> {
    private Node<T> head = null;
	private int size = 0;

    public boolean isEmpty() { 
        return size==0;
    }

    public void put(T item) {
        Node<T> n = new Node<T>(item);
        
        if (isEmpty()) {
            head = n;
            head.setNext(head);
            head.setPrev(head);
            size++;
        }

        else if (size==1) {
            head.setNext(n);
            head.setPrev(n);
            n.setPrev(head);
            n.setNext(head);
            size++;
        }

        else {
            n.setPrev(head.getPrev()); //o prohgoymenos toy kainoyrioy node einai o palios teleytaios
            head.getPrev().setNext(n); //to epomeno toy teleytaioy stoixeioy einai to n
            n.setNext(head); //o epomenos toy teleytaioy einai o prvtos giati exv kyklikh lista
            head.setPrev(n); //o prohgoymenos toy prvtoy einai o teleytaios giati exv lista diplhs syndeshs
            size++; 
        }
    }

    public T get() throws NoSuchElementException {
		if (isEmpty()) throw new NoSuchElementException();
		
		if (size==1) { //an exv mono ena stoixeio sth lista
            T data = head.getData();
            head = null;
        	size--;
            return data;            
		}	

        else {
            T data = head.getData(); //apo8hkeyv to periexomeno ths kefalhs se prosvrinh metablhth gia na mhn to xasv afoy skopeyv na to afairesv
            head.getPrev().setNext(head.getNext()); //to prohgoymeno toy head einai to teleytaio kai o epomenos kombos aytoy 8a einai o kainoyrios prvtos meta thn afairesh dhladh o epomenos toy head
            head.getNext().setPrev(head.getPrev()); //o epomenos to head 8a ginei tvra o prvtos ara 8elv na exei prohgoymeno ton teleytaio
            head = head.getNext(); //o head deixnei ston epomeno kombo tvra
        	size--;
            return data; //epistrefv ayto poy afairesa
		}
	}

	public T peek() throws NoSuchElementException {
		if (isEmpty()) throw new NoSuchElementException();
		T data = head.getData();
		return data;
	}
	
	public void printQueue(PrintStream stream) {
		PrintStream queue = new PrintStream(stream);
		Node<T> node = head; 
        int k = 1;
		while (k<=size) {
			queue.println(node.getData());
			queue.flush();
			node = node.getNext();
            k++;
		}
	}

    public int size() {
		return size;
	}
    
}

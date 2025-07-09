/*
 * file name: StringStackImpl.java
 */

import java.util.NoSuchElementException;
import java.io.PrintStream;

public class StringStackImpl<T> implements StringStack<T> {
 
    private Node<T> head = null;
    private int size = 0;

    public boolean isEmpty() {
		return size==0;
	}

    public void push(T item) {
        Node<T> temp = head;
        head = new Node<T>(item);
        head.setNext(temp);
        size++; //ka8e fora poy pros8etv 1 antikeimeno sth stoiba ayjanv to mege8os
    }

    public T pop() throws NoSuchElementException {
        if (isEmpty()) throw new NoSuchElementException();
        
        else {
            T item = head.getData(); //to item poy 8elv na bgalv einai ekeino sto opoio deixnei o head
            if(size==1) { //an eixa mono 1 antikeimeno o head na ginei null kai oxi next gia na apofygv tyxon kindynoys me th diaxeirhsh mnhmhs
                head = null;
                size--; 
                return item;
            } 
            else {
                head = head.getNext(); //to head deixnei sto epomeno stoixeio gia na ginei h diagrafh toy 1oy
                size--; //ka8e fora poy afairv 1 antikeimeno sth stoiba meivnv to mege8os
                return item; //epistrefetai ayto poy ekana delete apo thn arxh ths stoibas
            }   
        }
    }

    public T peek() throws NoSuchElementException {
        if (isEmpty()) throw new NoSuchElementException();
        else {
            T item = head.getData(); //ayto poy brisketai sto head einai ayto poy 8elv na dv
            return item;
        }
    }

    public void printStack(PrintStream stream) {
        PrintStream stack = new PrintStream(stream);
        Node<T> newHead = head;
        while (newHead != null) {
            stack.println(newHead.getData()); 
			stack.flush();
			newHead = newHead.next;
        }
    }

    public int size() {
        return size; //h eyresh mege8oys ginetai se xrono O(1) dhladh sta8ero giati h metablhth size enhmervnetai amesvs me ka8e allagh sth stoiba kai edv apla th zhtav
    }

} //public class StringStackImpl implements StringStack

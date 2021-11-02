import java.util.NoSuchElementException;

/**
 * Your implementation of a Singly-Linked List.
 */
public class SinglyLinkedList<T> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private SinglyLinkedListNode<T> head;
    private SinglyLinkedListNode<T> tail;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the element to the front of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
    	if(data == null) {
    		throw new IllegalArgumentException("Error: Bad Input");
    	}
       if(size == 0) {
    	   SinglyLinkedListNode<T> x = new SinglyLinkedListNode<>(data, null);
    	   this.head = x;
    	   this.tail = x;
       }
       else {
    	   SinglyLinkedListNode<T> x = new SinglyLinkedListNode<>(data, head);
    	   head = x;
       }
       size++;
    }

    /**
     * Adds the element to the back of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
    	if(data == null) {
    		throw new IllegalArgumentException("Error: Bad Input");
    	}
    	if(size == 0) {
     	   SinglyLinkedListNode<T> x = new SinglyLinkedListNode<>(data, null);
     	   this.head = x;
     	   this.tail = x;
        }
    	else
    	{
    		SinglyLinkedListNode<T> x = new SinglyLinkedListNode<>(data, null);
    		tail.setNext(x);
    		tail = x;
    		
    	}
    	size++;
    }

    /**
     * Removes and returns the first data of the list.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
    	T temp;
    	if(size == 0) {
    		throw new NoSuchElementException("Error: Array is empty");
    		
    	}
    	else if(size == 1)
    	{
    		temp = head.getData();
    		head = null; 
    		tail = null;
    	}
    	else {
    		
    	temp = head.getData();
        this.head = head.getNext();
        
    	}
    	size--;
    	return temp;
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
    	T temp;
    	if(size == 0) {
    		throw new NoSuchElementException("Error: Array is empty");
    		
    	}
    	else if(size == 1)
    	{
    		temp = head.getData();
    		head = null; 
    		tail = null;
    	}
    	else {
    		SinglyLinkedListNode<T> iter = head;
    		while(iter.getNext() != tail) {
    			iter = iter.getNext();
    		}
    	
    	temp = tail.getData();
        iter.setNext(null);
        tail = iter;
        
    	}
    	size--;
    	return temp;
    }
    public void addAtIndex(int index, T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        SinglyLinkedListNode<T> temp = head;
        if(index == 0)
        {
            SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>(data, head);
            head = newNode;
            tail = newNode;
        }
        else if(index >= size - 1)
        {
                        SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>(data);
            tail.setNext(newNode);
            tail = newNode;

        }
        else{
            for(int i = 1; i < index; i++){
                temp = temp.getNext();
            }
        SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>(data, temp.getNext());
        temp.setNext(newNode);
        }
        
        
        size++;
    }
    

    /**
     * Returns the head node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the head of the list
     */
    public SinglyLinkedListNode<T> getHead() {
        // DO NOT MODIFY THIS METHOD!
        return head;
    }

    /**
     * Returns the tail node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the tail of the list
     */
    public SinglyLinkedListNode<T> getTail() {
        // DO NOT MODIFY THIS METHOD!
        return tail;
    }

    /**
     * Returns the size of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}
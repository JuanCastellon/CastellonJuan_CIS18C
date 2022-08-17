/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dequedemo;

/**
 *
 * @author Juan
 */
public class Deque<T> implements DequeInterface<T>
{
    // linked list containing the items in the deque
    private Node<T> head=null, tail=null;

    // current number of items in deque
    private int numberOfItems;

    // Queue constructor that starts with empty deque.
    public Deque()
    {
        numberOfItems=0; // no items yet!
    }
	
    // displays current contents of the deque
    @Override
    public void display()
    {
        Node current=head;
        for(int i=0;i<numberOfItems;i++)
        {
            System.out.print(current.getValue()+" ");
            current=current.getNext();
            if ( current==null ) break;
        }
    }
	
    // ----- functions/methods in the interface that must be implemented -----

    // returns true if the deque is empty (no items in deque) 
    // false if deque is (has at least one or more items in deque)
    @Override
    public boolean isEmpty()
    {
        return numberOfItems==0;
    }
	
	// return the number of items currently in the deque
    @Override
    public int size()
    {
        return numberOfItems;
    }
 
    // returns the value of the item currently at front of deque
    public T front()
    {
        if ( head==null ) return null;
        return head.getValue(); // return item stored at head node
    }
	
    // returns the value of the item currently at the end of the deque
    @Override
    public T back()
    {
        if ( tail==null ) return null;
        return tail.getValue(); // return item stored at tail node
    }
	
    // places parameter item onto the end of the deque
    @Override
    public void push_back(T newItem)
    {
        // if head node is null, make head and tail node contain the first node
        if ( head == null)
        {
            head = new Node(newItem);
            tail=head; // when first item is enqueued, head and tail are the same
            numberOfItems++; // increment the number of items in the deque
        }
        else
        {
            Node<T> newNode = new Node(newItem);
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail=newNode;
            numberOfItems++;
        }
    }
	
    @Override
    public void enqueue_back(T newItem) // this is the same concept as push_back
    {
        this.push_back(newItem); // since it's the same as push_back, just call push_back
    }

    // returns and removes the current item at the front of the deque
    // the item that is in the deque behind the item becomes the new front item
    @Override
    public T pop_front()
    {
	T headDataValue = null;
	if ( numberOfItems > 0 )
	{
            headDataValue = head.getValue();
            Node<T> oldHead=head;
            head=head.getNext();
            oldHead.setNext(null);
            oldHead.setPrevious(null);

            numberOfItems--;
        }
        return headDataValue;  // returns the data value from the popped head, null if deque empty
    }
	
    // returns and removes the current item at the back of the deque
    // the item that is in the deque in front of the item being removed becomes the new back item
    @Override
    public T pop_back()
    {
	T tailDataValue = null;
	if ( numberOfItems > 0 )
	{
            tailDataValue = tail.getValue();
            Node<T> oldTail=tail;
            tail=tail.getPrevious();
            
            //Previously this was "tail.setNext(null) but this does not make
            //sense because the old tail should be what's becoming null, not the
            //new tail. We're popping this off the back
            oldTail.setNext(null);
            oldTail.setPrevious(null);

            numberOfItems--;
        }
        return tailDataValue;  // returns the data value from the popped tail, null if deque empty
    }
    
    @Override
    public T dequeue_back() // this is the same as pop_back
    {
        return this.pop_back();
    }
    
    @Override
    public T dequeue_front() // this is the same concept as pop_front
    {
        return this.pop_front(); // since it's the same as pop_front, just call pop_front
    }
	
    @Override
    public void enqueue_front(T newItem) // this is the same concept as push_front
    {
        this.push_front(newItem); // since it's the same as push_front, just call push_front
    }
    
    // places parameter item onto the end of the deque
    @Override
    public void push_front(T newItem)
    {
        //The issue here is that tail is tied to head. Changing head changes
        //tail. We have to change this.
        
        Node<T> newNode = new Node(newItem);//Declaring the new node
        newNode._next=head;//This is making sure that newNode is the new head
                           //We will change head accordingly below
        
        //If the head is not null, then we can just append the new node to the
        //front of the deque
        if(head!=null){
            head._previous=newNode;
        }
        //If the tail is null, set the tail newNode to tail, just like before.
        if(tail==null){
            tail=newNode;
        }
        //At the end, newNode will become the new head since were are enqueueing
        //to the front. The previous two if statements are just checking if
        //if this is first node/making sure to change the previous head's
        //pointer to the write place
        head=newNode;
        numberOfItems++;
        
        //The old code is below.
        
//        if head node is null, make head and tail node contain the first node
//        if ( head == null )
//        {
//            head = new Node(newItem);
//            tail=head;//when first item is enqueued, head and tail are the same
//            numberOfItems++; // increment the number of items in the deque
//        }
//        
//        
//        else
//        {
//            Node<T> newNode = new Node(newItem);
//            newNode.setNext(head);
//            head.setPrevious(newNode);
//            head=newNode;
//            numberOfItems++;
//        }
//        else 
//        {
//            Node<T> newNode = new Node(newItem);
//            newNode.setNext(head);
//            head.setPrevious(newNode);            
//            head=newNode;
//            numberOfItems++;
//        }
    }
    
    // Node Inner Class
    private class Node<T> {
        private T value;
        private Node _previous, _next;

        public Node(T data) {
            value = data;
            _previous = null;
            _next = null;
        }
    
        protected Node(T data, Node previousNode, Node nextNode) {
            value = data;
            _previous = previousNode;
            _next = nextNode;
        }
		
        public Node getNext() {
            return _next;
        }

        public Node getPrevious() {
            return _previous;
        }

        public void setValue(T newValue)
        {
            value=newValue;
        }

        public T getValue() {
            return value;
        }

        public void setNext(Node newNextNode) {
            _next = newNextNode;
        }
		
        public void setPrevious(Node newPreviousNode) {
            _next = newPreviousNode;
        }
    }
}
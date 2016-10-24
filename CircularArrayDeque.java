/**
 * Class CurcularArrayDeque to implement the Deque data structure using a circular array
 * With a default Capacity of 100 for the deque
 * Written by Moussa Sarr on October 24 2016

 */


public class CircularArrayDeque<T> {
    private static final int DEFAULT_CAPACITY = 100;
    private static int front, rear, size, capacity;
    private T[] container;
    
    
    //Initialize the Deque with default capacity
    public CircularArrayDeque(){
        front = -1;
        rear = -1;
        container = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
        capacity = DEFAULT_CAPACITY;
    }
    
    //Initialize the Deque with capacity n
    public CircularArrayDeque(int n){
        front = -1;
        rear = -1;
        container = (T[]) new Object[n];
        size = 0;
        capacity = n;
    }
    
    public static boolean isEmpty(){
        return size == 0 ;
    }
    
    
    public static boolean isFull(){
        return size == capacity;
    }
    
    
    public void addAtFront(T item){
        if(isEmpty()){
            front = 0;
            rear  = 0;
            container[front]= item;
            size++;
        }
        
        else if( isFull()){
            System.out.println("Deque is full. Adding another element will cause deque overflow");
        }
        
        else{
            
            front = (front + capacity - 2) % (capacity -1);
            container[front] = item;
            size++;
        }
    
    
    }
    
    
    public void addAtRear(T item){
        if(isEmpty()){
            front = 0;
            rear  = 0;
            container[front]= item;
            size++;
        }
        
        else if(isFull()){
            System.out.println("Deque is full. Adding another element will cause deque overflow");
        }
        
        else{
            rear = (rear +1)% (capacity -1);
            container[rear] = item;
            size++;
        }
        
    }
    
    
    public T removeFromFront(){
        T item = container[front];
        front = (front + 1)% (capacity-1);
        size--;
        return item;
    }
    
    
    public T removeFromRear(){
        T item = container[rear];
        rear = (rear- 2 + capacity)%(capacity-1);
        size--;
        return item;
    }
    
    
    public void PrintAllElementsInDeque(){
        
        if(isEmpty()){
            System.out.println("The Deque is emty");
        }
        
        else if (front == rear){
            System.out.println(" Front is at position " + front + " and rear is at position "+ rear + " . Both front and rear contain the element "+ container[front]);
        }
    
        else {
            int iterator = front;
            int count = 0;
            while(iterator != rear){
                System.out.println("Entry at position " + iterator + " is "+ container[iterator]);
                iterator = (iterator + 1)% (capacity-1);
            }
            System.out.println("Entry at position " + rear + " is "+ container[rear]);
            System.out.println(" Front is at position " + front + " and contains "+ container[front] + "and rear is at position "+ rear + " . Rear contains the element "+ container[rear]);
            
        }
    }
    
    // And finally test and play around with my deque
    public static void main( String args[]){
        CircularArrayDeque mydeque = new CircularArrayDeque();
        System.out.println("My deque capacity should be 100 and is " + mydeque.capacity);
        System.out.println("----------------------------------------------------------" );
        mydeque = new CircularArrayDeque(10);
        System.out.println("Now my deque capacity should be 10 and is " + mydeque.capacity);
        System.out.println("----------------------------------------------------------" );
        mydeque.addAtFront(20);
        mydeque.addAtFront(40);
        mydeque.addAtFront(60);
        mydeque.addAtFront(80);
        mydeque.addAtFront(20);
        mydeque.addAtFront(40);
        mydeque.addAtFront(60);
        mydeque.addAtFront(80);
        mydeque.addAtFront(60);
      
        mydeque.PrintAllElementsInDeque();
        mydeque.addAtFront(80);
        mydeque.addAtFront(60);
        
        mydeque.removeFromFront();
        mydeque.removeFromFront();
        mydeque.removeFromFront();
        mydeque.removeFromFront();
        
        
        mydeque.removeFromRear();
        mydeque.removeFromRear();
        mydeque.removeFromRear();
        mydeque.removeFromRear();
        mydeque.removeFromRear();
        mydeque.removeFromRear();
        mydeque.addAtFront(80);
        mydeque.addAtFront(60);
        mydeque.addAtRear(20);
        mydeque.addAtRear(40);
        mydeque.addAtRear(60);
        
        mydeque.PrintAllElementsInDeque();
    }
    
    


}
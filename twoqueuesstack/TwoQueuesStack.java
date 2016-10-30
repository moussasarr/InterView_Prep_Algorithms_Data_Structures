package twoqueuesstack;

// Defines Stack Overflow and stack underflow Exceptions

class StackOverflowException extends Exception {
    public StackOverflowException(int capacity){
        super("STACK OVERFLOW: Stack is full. It already contains " + capacity + " elements, which is its capacity. You cannot add more items in the stack. Please choose a stack with bigger capacity more suitable to your data size");
    }
}



class StackUnderflowException extends Exception{
    public StackUnderflowException(){
        super("STACK UNDERFLOW: Stack is empty. You cannot pop ");
    }
}

// Defines the Stack implemented with two queues
public class TwoQueuesStack<T>{
    private Queue queueA, queueB;
    private int size, capacity, top;
    private static final int DEFAULT_CAPACITY = 100;
    
    public TwoQueuesStack(int n){
        queueA = new Queue<T>(n);
        queueB = new Queue<T>(n);
        capacity = n;
        size = 0;
        top = queueA.tail;
    }
    
    public TwoQueuesStack(){
        this(DEFAULT_CAPACITY);
    }
    
    public boolean isFull(){
        return size == capacity;
    }
    
    public boolean isEmpty(){
        return size == 0 ;
    }
    
    public void push(T item) throws StackOverflowException{
        if(isFull()){
            throw new StackOverflowException(size);
        }
        
        else if(isEmpty()){
            queueA.enqueue(item);
            size ++ ;
            top = queueA.tail;
        }
        
        else {
            queueB.enqueue(queueA.dequeue());
            queueA.enqueue(item);
            size ++;
            top = queueA.tail;
        }
        
    }
    
    
    public T pop() throws StackUnderflowException{
        if(isEmpty()){
            throw new StackUnderflowException();
        }
        else{
            T item = (T) queueA.dequeue();
            // Make sure now that the top of the stack is the tail of QA
            // And that QA only contains one element
           
            int i = 0;
            for(i=0; i<= queueB.size()-1; i++){
                    queueA.enqueue(queueB.dequeue());
            }
            Queue referenceToOldQueueA = queueA;
            queueA = queueB;
            queueB = referenceToOldQueueA;
            size--;
            top = queueA.tail;
            return item;
            }
    }
    

    

}
    
   
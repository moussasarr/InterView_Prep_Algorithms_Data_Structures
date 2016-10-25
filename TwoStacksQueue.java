/* A queue implementation using two stcks of arrays
    The queue has a default capacity of 100
        and a dynamic/generic capacity of n
    Implementation by MS on October 25 2016
 */



public class TwoStacksQueue<T>{
    private Stack stackA, stackB;
    int head, tail, size, capacity;
    private static final int DEFAULT_CAPACITY = 100;
    
    
    
    
    /* First let ' s implement the stack
     * using an array for simple implementation and for memory minimization
     * Capacity for queue requested will determine capacity for array. So no need to resize array
     */
    private class Stack{
        private T[] arrayStack;
        private int top, capacity, size;
        
        
        public Stack(int n){
            top = -1;
            arrayStack = (T[]) new Object[n];
            capacity = n;
            size = 0;
            
        }
        
        public boolean isFull(){
            return size == capacity;
        }
        
        public boolean isEmpty(){
            return size == 0;
        }
       
        
        public void push(T item){
            if(isFull()){
                System.out.println("Stack Overflow");
            }
            else{
                top ++;
                arrayStack[top] = item;
                size++;
            }
            
        }
        
        public T pop(){
            if (isEmpty()){
                System.out.println("Stack underflow");
                System.exit(1);
                return null;
            }
            else{
                T item = arrayStack[top];
                top --;
                size --;
                return item;
            }
            
        }
        
    }
    
    public TwoStacksQueue(int n){
        stackA = new Stack(n);
        stackB = new Stack(n);
        head = stackA.top;
        tail = stackB.top;
        size = 0;
        capacity = n;
    }
    
    public TwoStacksQueue(){
        this(DEFAULT_CAPACITY);
    }
    
    
    
    public void enqueue(T item){
        stackB.push(item);
        tail = stackB.top;
        size++;
    }
    
    
    public T dequeue(){
        if(stackA.isEmpty() && !(stackB.isEmpty())){
            int i = 0;
            for(i=0; i<= tail; i++){
                stackA.push(stackB.pop());
            }

        }
          size--;
          head = stackA.top;
          tail = stackB.top;
          return (stackA.pop());
        }




// Now testing time
    public static void main(String[] args){
        TwoStacksQueue myQueue = new TwoStacksQueue(5);
        System.out.println("Just created a queue. Size of the que is " + myQueue.size);
        System.out.println("The head of the queue is " + myQueue.head);
        System.out.println("The tail of the queue is " + myQueue.tail);
        System.out.println("The capacity of the queue is " + myQueue.capacity);
        myQueue.enqueue(100);
        System.out.println("Now I enqueue 100, and the size is " + myQueue.size);
        myQueue.enqueue(200);
        myQueue.enqueue(300);
        myQueue.enqueue(400);
        myQueue.enqueue(500);
        myQueue.enqueue(600);
        
        System.out.println("Now I enqueue 200, 300, 400, 500 and 600 , and the size is " + myQueue.size);
        System.out.println("Now the tail is " + myQueue.tail +  " and the head is " + myQueue.head);
        
        myQueue.dequeue();
        myQueue.dequeue();
        myQueue.dequeue();
        myQueue.dequeue();
        myQueue.dequeue();
        
        System.out.println("Now I dequeued 5 times , and the size is " + myQueue.size);
        System.out.println("Now the tail is " + myQueue.tail +  " and the head is " + myQueue.head);
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        
        
    }


}
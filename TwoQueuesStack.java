public class TwoQueuesStack<T>{
    private static final int DEFAULT_CAPACITY = 100;
    private int top, size, capacity;
     private Queue queueA, queueB;
    
    
    // Implement the Queue
    private class Queue{
        T[] containerArray;
        private int head, tail, size, capacity, arrayLastIndex;
       
        
        
        public Queue(int n){
            containerArray = (T[]) new Object[n];
            head = -1;
            tail = -1;
            size = 0;
            capacity = n;
            arrayLastIndex = capacity - 1;
            
        }
        
        public boolean isEmpty(){
            return size == 0;
            
        }
        
        public boolean isFull(){
           return size == capacity;
        }
        
        
        public void enqueue(T item){
            
             if (isFull()){
                System.out.println("Queue overflow");
            }
            else if (isEmpty()){
                head = (head +1)% arrayLastIndex;
                tail = (tail +1)% arrayLastIndex;
                containerArray[tail] = item;
                size++;
                
            }
            else{
                tail = (tail +1)% arrayLastIndex;
                containerArray[tail] = item;
                size++;
            }
            
        }
        
        
        public T dequeue(){
            if(isEmpty()){
                System.out.println("Queue underflow");
                System.exit(1);
                return null;
            }
            else{
                T element = containerArray[head];
                head = (head +1)% arrayLastIndex;
                size--;
                return element;
            }
        }
            
        }
    
    
    
    public TwoQueuesStack(int n){
        queueA = new Queue(Math.floor(n/2));
        queueB = new Queue(Math.ceiling(n/2));
        capacity = n;
        top = queueA.head;
        size = queueA.size + queueB.size;
    }
    
    public TwoQueuesStack(){
        this(DEFAULT_CAPACITY);
    }
    
    public boolean isEmpty(){
        return (queueA.isEmpty()&& queueB.empty()) ;
    }
    
    public boolean isFull(){
        return (queueA.isFull() && queueB.isFull()) ;
    }
    
    
   
    
   
    
    public void push(T item){
        if(isFull()){
            System.out.println("Stack overflow");
        }
        
        elseif(isEmpty()){
            queueA.enqueue(item);
            top = queueA.tail;
            size = queueA.size;
        }
        
        
        else{
            if(queueA.isFull() && queueB.isEmpty()){
                int i =0;
                for(i=0;i<queueA.size;i++){
                    queueB.enqueue(queueA.dequeue());
                }
                queueA.enqueue(item);
                size = queueA.size + queueB.size;
                top = queueA.tail;
            }
    }
    
    public T pop(){
        if(isEmpty()){
            System.out.println("Stack underflow");
        }
        else if(queueA.epmty()){
            queueB.deque
            
        }
        
    }


    public static void main(String[] main){
        TwoQueuesStack myStack = new TwoQueuesStack();
        
    }



}
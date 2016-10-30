package twoqueuesstack;

    public class Queue<T>{
        int head, tail;
        private int size, capacity;
        private T[] container;
        private static final int DEFAULT_CAPACITY = 100;
    
    
    
        public Queue(int n){
            capacity = n;
            head = -1;
            tail = -1;
            size = 0;
            container = (T[]) new Object[capacity];
        }
    
    
        public Queue(){
            this(DEFAULT_CAPACITY);
        }
    
        public boolean isEmpty(){
            return size == 0;
        }
    
        public boolean isFull(){
            return size == capacity;
        }
    
        public void enqueue(T item){
            if(isFull()){
                System.out.println("Queue Oveflow");
            }
            else if(isEmpty()){
                head = 0;
                tail = 0;
                container[tail] = item;
                size++;
            
            }
            else{
                tail = (tail + 1) % (capacity - 1);
                size++;
                container[tail] = item;
            }
        }
        
        public int size(){
            return size;
        }
        
        public int capacity(){
            return capacity;
        }
    
        public T dequeue(){
            if(isEmpty()){
                System.out.println("Queue underflow");
                System.exit(1);
                return null;
            }
            else {
                if(head == tail){
                    T item = container[head];
                    head = -1;
                    tail = -1;
                    size --;
                    return item;
                
                }
                else{
                    T item = container[head];
                    head = (head + 1) % (capacity -1);
                    size --;
                    return item;
                }
            }
        }
    
    
        public static void main(String[] args){
            Queue myQueue = new Queue();
            myQueue.enqueue(34);
            myQueue.enqueue(38);
            myQueue.enqueue(34);
            System.out.println(myQueue.dequeue());
    
        }

    }
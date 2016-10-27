/* A queue data structure made with a singly-linked list
 * Implemented by Moussa Sarr from scratch on Oct 26 2016
 * The que can store any Object type (generics)
 */


public class ListQueue<T>{
    private SList list;
    private int size;
    private SListNode front, rear;
    
    
    private class SListNode{
        SListNode next;
        T item;
        
        public SListNode(T item, SListNode next){
            this.next = next;
            this.item = item;
        }
        
        public SListNode(T item){
            this(item,null);
        }
    }
    
    
    private class SList{
        private SListNode head, tail;
        private int size;
        
        public SList(){
            this.head = null;
            this.tail = null;
            size = 0;
        }
        
        public boolean isEmpty(){
            return size == 0;
        }
        
        public SListNode removeFront(){
            if(isEmpty()){
                System.out.println("List is empty");
                System.exit(0);
                return null;
            }
            
            else if (head.next == null){
                SListNode node = head;
                head = null;
                tail = null;
                size--;
                return node;
                
            }
            else{
                SListNode node = head;
                head = head.next;
                size --;
                return node;
            }
        }
        
        public void insertEnd(T item){
            if(isEmpty()){
                head = new SListNode(item);
                tail = head;
                size++;
            }
            else{
                tail.next = new SListNode(item);
                tail = tail.next;
                size++;
                
            }
            
        }
        
    }
    
    
    public ListQueue(){
        list = new SList();
        front = list.head;
        rear = list.tail;
        size = list.size;
    }
    
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    
    public void updateSizeFrontAndRear(){
        front = list.head;
        rear = list.tail;
        size = list.size;
    }
    
    public void enqueue(T item){
        list.insertEnd(item);
        updateSizeFrontAndRear();
        
        
    }
    
    public SListNode dequeue(){
        if(isEmpty()){
            System.out.println("Queue Underflow. Queue is empty");
            System.exit(1);
            return null;
        }
        else{
            SListNode node = list.removeFront();
            updateSizeFrontAndRear();
            return node;
           
           
        }
      
    }
    
    
    
    
    
    public static void main(String args[]){
        ListQueue myListQueue = new ListQueue();
        myListQueue.enqueue("Moussa");
        myListQueue.enqueue("Tendai");
        myListQueue.enqueue("Brian");
        myListQueue.enqueue(40);
       
        
        
        System.out.println(" I enqueued Moussa, Tendai, Brian and then 40 . The size of my queue should be " + myListQueue.size);
        System.out.println("The rear of my queue should contain 40 and actually contains " + myListQueue.rear.item );
        System.out.println("The front of my queue should contain Moussa and actually contains " + myListQueue.front.item );
        myListQueue.dequeue();
        
        System.out.println(" I just dequeued . The rear of my queue should contain 40 and actually contains " + myListQueue.rear.item );
        System.out.println("The front of my queue should contain Tendai and actually contains " + myListQueue.front.item );
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}


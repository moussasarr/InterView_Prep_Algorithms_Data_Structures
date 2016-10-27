/* A stack data structure made with a singly-linked list
 * Implemented by Moussa Sarr from scratch on Oct 26 2016
 * The stack can store any Object type (generics)
 */



public class StackList<T>{
    private int size;
    private SList list;
    private SListNode top;
    
    
    private class SListNode{
        private T item;
        private SListNode next, top;
        
        
        public SListNode(T item, SListNode next){
            this.item = item;
            this.next = next;
        }
        
        public SListNode(T item){
            this(item,null);
        }
        
    }

    
    private class SList{
        private SListNode head;
        private int size;
        
        
        
        
      
        public SList(){
            head = null;
            size = 0;

        }
        
        
        public void insertFront(T item){
            head = new SListNode(item, head);
            size++;
        }
        
        public void removeFront(){
            head = head.next;
            size--;
        }
        
    }


    public StackList(){
        list = new SList();
        updateSizeAndTop();
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public void push(T item){
            list.insertFront(item);
            updateSizeAndTop();
    }
    
    public T pop(){
        if(isEmpty()){
            System.out.println("Stack underflow");
            System.exit(1);
            return null;
        }
        else{
            T item = list.head.item;
            list.removeFront();
            updateSizeAndTop();
            return item;
            
        }
    }
    
    public SListNode top(){
        return top;
    }
    
    public void updateSizeAndTop(){
        size = list.size;
        top = list.head;
        
    }



// Testing time
    public static void main(String[] args){
        StackList myStack = new StackList();
        myStack.push("Moussa");
        myStack.push(25);
        myStack.push("Franco");
        myStack.pop();
        System.out.println(" I just pushed Moussa, then Brian and then Franco. Then I popped. The size of the stack should be "+ "2 " + "and it is actually "+ myStack.size);
        System.out.println(" The element at the top of the stack should be 25. It s actually "+ myStack.list.head.item  + " and the top of the stack is "+ myStack.top());
       
        
        
    }


}
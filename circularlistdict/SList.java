// A circular SList ADT of Objects that implements the dictionary operations:
     // INSERT, DELETE, SEARCH implemented for a circular SList
// By Moussa Sarr on Nov 16 216

package circularlistdict;

public class SList{
    
    //Use head as sentinel
    private SListNode head;
    
    private int size;
    
    
    public SList(){
        this.head = new SListNode(null);
        this.size = 0;
    }
    
    
    
    
    
    //Dictionary operations
    
    
    
    //Search or find node at nth position
    // Returns null if node not found
    // Returns Node if found
    // Gives O(N) in the average case
    
    public SListNode nth(int position){
        
        if(position < 0 || head.next == null){
            return null;
        }
        else{
            SListNode currentNode = head;
            int counter = 0;
            while(counter < position){
                currentNode = currentNode.next;
                counter ++;
                
                if(currentNode == null ){
                    return null;
                }
            }
            return currentNode;
            }
    }
    
    
    
    //Insert Node at Front of List gives O(1) time
    public void insertFront(Object item){
        head.next = new SListNode(item, head.next);
    }
    
    
    // Delete Node nth object
    public SListNode delete(int position){
        SListNode node = nth(position);
        SListNode previous = head;
        
        for(int i=0; i< position; i++){
            previous = previous.next;
        }
        
        previous.next = node.next;
        return node;
    }
    
    
    
}

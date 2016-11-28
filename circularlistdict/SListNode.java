// Singly-linked list node Abstract Data Type
// By Moussa Sarr on Nov 28 2016

package circularlistdict;

public class SListNode {
    private Object item;
    SListNode next;
    
    
   
    
    public SListNode(Object item, SListNode next){
        this.item = item;
        this.next = next;
    }
    
    public SListNode(Object item) {
        this(item, null);
    }
    
    

}


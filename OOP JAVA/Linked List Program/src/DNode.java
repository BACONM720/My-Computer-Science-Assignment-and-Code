/**
 * 
 * This defines a single node used in a Doubly Linked List.
 * @author Michael Madden
 *
 */
public class DNode 
{
   // Instance variables:
   private Object element;
   private DNode prev;
   private DNode next;

   /** Creates a node with null references to its element, prev & next nodes. */
   public DNode() {
     this(null, null, null);
   }

   /** Creates a node with the given element, prev & next nodes. */
   public DNode(Object e, DNode p, DNode n) {
     element = e;
     prev = p;
     next = n;
   }
   
   // Accessor methods:
   public Object getElement() {
     return element;
   }

   public DNode getNext() {
     return next;
   }

   public DNode getPrev() {
	     return prev;
   }
   
   // Modifier methods:
   public void setElement(Object newElem) {
     element = newElem;
   }

   public void setNext(DNode newNext) {
     next = newNext;
   }
   
   public void setPrev(DNode newPrev) {
	     prev = newPrev;
   }
}


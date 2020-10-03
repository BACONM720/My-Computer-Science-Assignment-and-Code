/**
 * This defines a Doubly Linked List structure.
 * @author Michael Madden
 */

public class DLinkedList 
{
  protected DNode head;	 // head node of the list
  protected DNode tail;	 // tail node of the list
  protected DNode curr;	 // node referencing current position in the list
  protected long size;	 // number of nodes in the list
  
  /** Default constructor that creates an empty list. */
  public DLinkedList() {
    head = null;
    tail = null;
    curr = null;
    size = 0;
  }

  public long size() { 
	  return size;
  }
  
  public boolean isEmpty() { 
	  return (head == null);
  }

  public Object getCurr() {
	  if (curr == null)   // Verify that there is a current node
		  return null;
	  return curr.getElement();	
  }
  
  public boolean gotoHead() {
	  if (curr == null) return false;
	  curr = head;
	  return true;
  }

  public boolean gotoTail() {
	  if (curr == null) 
		  return false;
	  curr = tail;
	  return true;
  }

  public boolean gotoNext() {
	  if (curr == tail) 
		  return false;  // no next node: either at end or list is empty (both nodes null)
	  curr = curr.getNext(); // there must be a next node, so go to it	  
	  return true;	  
  }
  
  public boolean gotoPrev() { // This method not in our SLinkedList class
	  if (curr == head) 
		  return false;  // no prev node: either start or list is empty (both nodes null)
	  curr = curr.getPrev(); // there must be a prev node, so go to it	  
	  return true;	  
  }

  public void insertNext(Object el) {
      if (head == null) { 
	       insertHead(el);  // If haven't inserted a head, do so now 
	       return;
	  } 
	 
	  // create new node with its prev node being the current one and its next node being curr's next node
	  DNode newnode = new DNode(el, curr, curr.getNext());  
	  size++;	  

	  // update the current node's "next" ref.
	  curr.setNext(newnode); 

	  // update the next node's "prev" ref; 
	  //if at the end of the list there is no next node, so update the tail ref instead
	  if (curr == tail) {
		  tail = newnode;
	  } 
	  else {
		  newnode.getNext().setPrev(newnode); 
	  }
	  
	  // make this new node the current one
	  curr = newnode;
  }
  
  public void deleteNext() {
	  if (curr == null || curr.getNext() == null) return; // no next: list empty or already at end
	  
	  curr.setNext(curr.getNext().getNext());  // set curr's next equal to the next node's next
	  // Note: Garbage collector will automatically clear up the node no longer referenced

	  // update prev reference of the next node
	  curr.getNext().setPrev(curr);
	  
	  if (curr.getNext() == null) // keep tail node reference up to date
		  tail = curr;
	  
	  size--;
  }

  public void insertHead(Object el) {
	  DNode oldhead = head; // may be null
	  head = new DNode(el, null, oldhead); // head node's "prev" is null
	  size++;	  
	  curr = head;
	  // If this is the first node in the list, it is also the tail
	  if (tail == null)
		  tail = head;
  }

  public void insertTail(Object el) {
	  DNode oldtail = tail;
	  tail = new DNode(el, oldtail, null); // tail node's "next" is null
	  size++;	  
	  curr = tail;
	  // If this is the first node in the list, it is also the head
	  if (head == null)
		  head = tail;
  }
   
  public void deleteHead() {
	  if (head == null) return; // list already empty
	  
	  head = head.getNext();
	  head.setPrev(null);
	  size--;
	  curr = head;

	  // if the list was 2 els, this new node is the head AND the tail
	  if (head.getNext() == null)
		  tail = head;
  }
}

import javax.swing.JOptionPane;

// M Madden, January 2013

public class DLLTest 
{
	public static void main(String[] args)
	{
		// Create an empty doubly linked list
		DLinkedList list = new DLinkedList();

		// Add some items to the list
		list.insertNext("AA"); 
		list.insertNext("BB");
		list.insertNext("CC");
		list.insertNext("DD");
		list.insertNext("EE");
		display(list);
		displayBackwards(list);
		
		list.gotoTail();
		list.insertNext("FF");
		JOptionPane.showMessageDialog(null, "Tail is: " + list.getCurr());
		
		list.gotoHead();
		list.insertNext("Second");
		display(list);
		displayBackwards(list);
		
		JOptionPane.showMessageDialog(null, "Size of list = " + list.size());
	}

	public static void display(DLinkedList list)
	{
		StringBuilder s = new StringBuilder();
		int i = 0;
		list.gotoHead();
		while(i < list.size()){

			s.append(" " + list.getCurr());

			list.gotoNext();

			i++;
		}

		System.out.println(s);
	}
	
	public static void displayBackwards(DLinkedList list)
	{
		StringBuilder s = new StringBuilder();
		int i = (int)list.size() - 1;
		list.gotoTail();
		while(i >= 0){

			s.append(" " + list.getCurr());

			list.gotoPrev();

			i--;
		}

		System.out.println(s);
	}


}

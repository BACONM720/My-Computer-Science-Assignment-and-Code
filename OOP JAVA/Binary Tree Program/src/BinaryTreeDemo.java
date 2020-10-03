import java.io.*;
import java.util.Scanner;

public class BinaryTreeDemo {

	private static String FilePath = System.getProperty("user.dir") + "\\";//user file path
	private  static Scanner input = new Scanner(System.in);//my scanner
	//main method that handle the main functions of the program.
	public static void main(String[] args) throws IOException {

		BinaryTree<String> tree1 = new BinaryTree<>();
		createTree(tree1);// create base tree case
		//ask user to load a previous saved tree, if yes load the tree from the file else go with the base case, if the file is null also carry out the base case
		System.out.println("Would you like to load previous tree");
		String s = input.nextLine();
		if(s.equals("yes")) {
			System.out.println("Loading the following...." + "\n" );
			print(System.out, load());//print out the tree
			System.out.println("\n\n");
			start(load());//start the game
		}
		else if(s.equals("no")) {
			System.out.println("Loading the following...."+ "\n" );
			print(System.out, tree1);
			System.out.println("\n\n");
			start(tree1);
		}
		else{
			System.out.println("invalid yes/no please");

		}

	}
//save method that uses serialization to store the tree
	public static void save(BinaryTree<String> tree) throws IOException {
		BinaryNode<String> curr = (BinaryNode<String>) tree.getRootNode();
		String filename = FilePath + "tree.txt";
		BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

		String str = (curr.serialize(curr));//serialize method in Binary node
		writer.write(str);
		writer.close();
	}
//load method using deserialization to reassemble the tree
	public static BinaryTree<String> load( ) throws IOException {
		String filename = FilePath + "tree.txt";
		BinaryNode<String> node = new BinaryNode<>();
		BinaryTree<String> tree = new BinaryTree<>();
		String textinput = "";
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		textinput = reader.readLine();
		if(textinput != null) {
			node = node.deserialize(textinput);//deserialize method found in binary node
			tree.setRootNode(node);
			return tree;//return the assembled tree
		}
		else//if file is empty return the base tree
			{
			System.out.println("File is empty, Starting with default tree....");
			createTree(tree);
			return tree;
		}
	}
//create tree method , which just builds our base case tree
	public static void createTree(BinaryTree<String> tree)
	{
		// To create a tree, build it up from the bottom:
		// create subtree for each leaf, then create subtrees linking them,
		// until we reach the root.
		//define leafs
		BinaryTree<String> leaf1 = new BinaryTree<String>("Lion");
		BinaryTree<String> leaf2 = new BinaryTree<String>("Dog");
		BinaryTree<String> leaf3 = new BinaryTree<String>("Crow");
		BinaryTree<String> leaf4 = new BinaryTree<String>("Snake");
		BinaryTree<String> leaf5 = new BinaryTree<String>("Cristiano Ronaldo" );
		BinaryTree<String> leaf6 = new BinaryTree<String>("Brad Pitt");
		BinaryTree<String> leaf7 = new BinaryTree<String>("Toaster" );
		BinaryTree<String> leaf8 = new BinaryTree<String>("Shovel");

		//define subtrees
		BinaryTree<String> Tree1 = new BinaryTree<String>("Is it a type of large cat?",leaf1, leaf2);
		BinaryTree<String> Tree2 = new BinaryTree<String>("Is it a bird, Maybe?", leaf3, leaf4);
		BinaryTree<String> Tree3 = new BinaryTree<String>("Is the Celebrity known for sports?", leaf5, leaf6);
		BinaryTree<String> Tree4 = new BinaryTree<String>("hmm, is it an item found in the house?", leaf7, leaf8);


		BinaryTree<String> Tree5 = new BinaryTree<String>("Is it a Mammal?", Tree1, Tree2);
		BinaryTree<String> Tree6 = new BinaryTree<String>("Ok, is it a Celebrity/person?", Tree3, Tree4);

		// Now the root
		tree.setTree("Are you thinking of an Animal?",Tree5,Tree6);
	} // end createTree1

//start method that contains most of the user handling
	public static void start(BinaryTree<String> tree) throws IOException {
		BinaryNodeInterface<String> currNode = tree.getRootNode();
		System.out.println(currNode.getData());
		while (true) {
			String c;
			while (!currNode.isLeaf()) {
				c = input.nextLine();
				//if yes get the the left child of the current node then print the data
				if (c.equals("yes") && !currNode.isLeaf()) {
					currNode = currNode.getLeftChild();
					System.out.println(currNode.getData());
					//else if no, set to the right child of the current node and print its data
				} else if (c.equals("no") && !currNode.isLeaf()) {
					currNode = currNode.getRightChild();
					System.out.println(currNode.getData());
					//else input is invalid and prompt the user again
				} else {
					System.out.println("invalid, try again: " + " " + currNode.getData());

				}
			}
			//if its a leaf node carry out this code
			String ans = currNode.getData();
			System.out.println("is this your answer: " + ans);
			c = input.nextLine();
			//if the user prompts yes prompt them with the menu
			if (c.equals("yes")) {
				System.out.println("Woo Hoo Im Right");
				menu(tree);
				//if no prompt them for their answer and question
			} else if (c.equals("no")) {
				System.out.println("Damn guess im wrong what was it that you were thinking of?");
				String UserAns = input.nextLine();

				System.out.println("Give me a Question to put in then.");
				String Question = input.nextLine();
				//validate the question and answer and replace the nodes then prompt the menu again
				if(validate(Question) && validate(UserAns)) {
					BinaryNode<String> oldAns = new BinaryNode<>(currNode.getData());

					currNode.setData(Question);
					currNode.setLeftChild((new BinaryNode<>(UserAns)));

					currNode.setRightChild(oldAns);
					menu(tree);
				}
				else{//else the question or answer is invalid
					System.out.println("Question or answer is invalid");
				}

			} else {
				System.out.println("invalid enter yes/no please!!!");
			}

		}
	}
//basic validate just to make sure the user enters nothing
	public static boolean validate(String s){
		s = s.toLowerCase();
		return s.length() > 1 && s.length() < 30;
	}
//basic method that just prompts the user with the menu
public static void menu(BinaryTree<String> tree) throws IOException  {

	System.out.println(" S: Save \n L: Load \n R: Replay \n Q: Quit");
	String s = input.nextLine();
	switch (s) {
		case "S":
			save(tree);
			menu(tree);
		case "Q":
			System.exit(0);
		case "L":
			start(load());
		case "R":
			start(load());
		case "":
			System.out.println("Enter something pls");
			menu(tree);
	}
}
//method to pre order traverse the tree
	public static void traversePreOrder(StringBuilder sb, BinaryNode<String> node) {
		if (node != null) {
			sb.append(node.getData());
			sb.append("\n");
			//recursively call the method to achieve the traversal
			traversePreOrder(sb, (BinaryNode<String>) node.getLeftChild());
			traversePreOrder(sb, (BinaryNode<String>) node.getRightChild());
		}
	}
	//method to print out the current tree
	public static void print(PrintStream os, BinaryTree<String> tree) {
		StringBuilder sb = new StringBuilder();
		//call traverse method
		traversePreOrder(sb, (BinaryNode<String>) tree.getRootNode());
		os.print(sb.toString());// print the string
	}
}

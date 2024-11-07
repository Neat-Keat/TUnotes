// Java program to search a given key in a given BST

import java.io.*;
import java.util.Scanner;

class Node {
	int key;
	Node left, right;
    int size;                    //ADDED AS PER INSTRUCTIONS

	public Node(int item) {
		key = item;
		left = right = null;

        size = nodeSize(this);                            //ADDED TO CALCULATE SIZE
	}

	//ADDED TO CALCULATE SIZE

	public static int nodeSize(Node node){
		if (node == null){
			return 0;
		} else{
			return(1 + nodeSize(node.left) + nodeSize(node.right));
		}
	}
}

class BST {
	Node root;

	// Constructor
	BST() {
		root = null;
	}

	// A utility function to insert
	// a new node with given key in BST
	Node insert(Node node, int key) {
		// If the tree is empty, return a new node
		if (node == null) {
			node = new Node(key);
			return node;
		}

		// Otherwise, recur down the tree
		if (key <= node.key){                                     //MODIFIED TO INSERT DUPLICATES
			node.size = node.size + 1;
			node.left = insert(node.left, key);
		}else if (key > node.key) {
			node.size = node.size + 1;
			node.right = insert(node.right, key);
		}

		// Return the (unchanged) node pointer
		return node;
	}

	// Utility function to search a key in a BST
	Node search(Node root, int key) {
		// Base Cases: root is null or key is present at root
		if (root == null || root.key == key)
			return root;

		// Key is greater than root's key
		if (root.key < key)
			return search(root.right, key);

		// Key is smaller than root's key
		return search(root.left, key);
	}

	Node leftRotate(Node t){ 
        if ( t == null || t.right == null)
            {   return t; }
        Node x = t.right;
        t.right = x.left; 
        x.left = t; 
        
        t.size = 1 + t.left.size + t.right.size; 
        x.size = 1 + x.left.size + x.right.size; 
        return x; // new root 
    }

	Node rightRotate(Node t){ 
        if ( t == null || t.left == null){
            return t; }
        Node x = t.left;
        t.left = x.right; 
        x.right = t; 
        
        t.size = 1 + t.left.size + t.right.size; 
        x.size = 1 + x.left.size + x.right.size; 
        return x; //new root
    }

    public static void PreorderTraversal(Node node){          //ADDED FOR ASSIGNMENT
        if (node != null){
            System.out.println("(" + node.key + "," + node.size + ")");
			if(node.left != null)
            	PreorderTraversal(node.left);
			if(node.left != null)
            	PreorderTraversal(node.right);
        }
    } 


	// Driver Code
	public static void main(String[] args) throws FileNotFoundException {
		BST tree = new BST();

		//inserting nodes
		File file = new File("input3.txt");  //INSERT NEW FILES HERE
		Scanner scanner = new Scanner(file);

		scanner.nextInt(); //Throw away size token

		tree.root = tree.insert(tree.root, scanner.nextInt()); //FIRST NODE
		while(scanner.hasNextInt()){
			tree.insert(tree.root, scanner.nextInt()); //REST OF NODES
		}

		//TO ANSWER HW QUESTIONS
        System.out.println("Preorder Traversal: ");
        PreorderTraversal(tree.root);
		tree.root = tree.leftRotate(tree.root);   //LEFT ROTATE
		System.out.println("AFTER ROTATION");          
		PreorderTraversal(tree.root);   //PRINT ROTATED TREE


		/*
		// Key to be found
		int key = 6;

		// Searching in a BST
		if (tree.search(tree.root, key) == null)
			System.out.println(key + " not found");
		else
			System.out.println(key + " found");

		// Searching in a BST
		if (tree.search(tree.root, key) == null)
			System.out.println(key + " not found");
		else {
			System.out.println(key + " found");
        }
		*/


	}
}

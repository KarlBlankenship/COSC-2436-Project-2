/*
 * This project loads the data below as text file. The implantation of this 
 * project shall be done using Binary Search Tree using linked list. You should
 * insert the information from the text file using binary tree sorted insertion
 * method. You need to create remove, and search methods as well. There is a 
 * condition during insertion or adding this data to the binary tree. Compare 
 * the price differences of the previous salary to the current salary that you 
 * are reading. Thus, don't insert any salary differences that is less than 
 * $3000 .
 *
 * The search method shall allow a search by salary and print both the name and
 * salary that is found, otherwise return not found message.
 *
 * The delete method shall allow to delete by salary. 
 *
 *
 * Name 	Salary
 * Betty 	44000
 * Bob          48000
 * Dilbert 	98000
 * Joseph 	22300
 * Nathan 	90000
 * Sally 	91000
 * Sam          87000
 * Susan 	8900
 * Veronica 	150000
 */

package Project2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * BST Class is a binary search tree class utilizing a node structure
 * that contains an Employee object for the field and contains a left node
 * for Employee objects with salaries lower than the root node and right 
 * node for salaries higher than the root node.
 * @author Karl
 */
public class BST 
{
    /**
     * Node class contains an Employee field as well as left and right nodes.
     */
    private class Node
    {
        private Employee employee;  // Employee object.
        private Node left, right;   // Left and Right Nodes.
        
        /**
         * Constructor.
         * @param emp 
         */
        Node(Employee emp)
        {
            employee = emp;
            left = null;
            right = null;
        }
        
        /**
         * Constructor.
         * @param emp
         * @param leftChild
         * @param rightChild 
         */
        Node(Employee emp, Node leftChild, Node rightChild)
        {
            employee.equals(emp);
            left = leftChild;
            right = rightChild;
        }
    }
    
    private Node root = null;   // Define the root node as null initially.
    
    /**
     * Public add method can be used from the main method to call the 
     * recursive add method.
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void add() throws FileNotFoundException, IOException
    {
        // Create FileReader object and pass in file.
        FileReader fr = new FileReader("employee.txt");
        
        // Read file into a buffer.
        BufferedReader br = new BufferedReader(fr);
        
        // Create String var to hold each buffered line and burn file header.
        String line = br.readLine(); // Reads in file header which isn't used.
        line = br.readLine(); // Read first line of data after header.
        
        // Write all buffered lines into Employee Instances and write to List.
        while (line != null) {
            // Split out name and manager from line and create Employee object.
            String[] lineEM = line.split(","); 
            Employee emp = new Employee(lineEM[0], Integer.parseInt(lineEM[1]));

            // If there are no current nodes, create the root node.
            if(root == null)
                root = add(emp, root);
            else
                add(emp, root);

            // Read next line of file.
            line = br.readLine();    
        }
    }
    
    /**
     * Private add method for adding nodes recursively. This method will add
     * add the nodes to the left or right based on the binary search algorithm
     * based on the value of the Employee salary. This method also looks for 
     * a difference between salaries of less than $3000 and will leave those 
     * salaries out.
     * @param emp
     * @param bstree
     * @return Node
     */
    private Node add(Employee emp, Node bstree)
    {
        if(bstree == null)
            return new Node(emp); //return new Node(x);
        if(emp.getSalary() < bstree.employee.getSalary() && 
                Math.abs(emp.getSalary() - bstree.employee.getSalary()) >= 3000)
            bstree.left = add(emp, bstree.left);
        else if(emp.getSalary() > bstree.employee.getSalary() && 
                Math.abs(emp.getSalary() - bstree.employee.getSalary()) >= 3000)
            bstree.right = add(emp, bstree.right);
        return bstree;
    }
    
    
    /**
     * Private class RemoveResult is a class that used to remove a node from
     * tree. This class will store the removed node and the remaining tree in
     * an object.
     */
    private class RemovalResult
    {
        Node node;  // removed Node.
        Node tree;  // remaining tree.
        
        /**
         * Constructor.
         * @param node
         * @param tree 
         */
        RemovalResult(Node node, Node tree)
        {
            this.node = node;
            this.tree = tree;
        }
    }
    
    /**
     * Public remove method is used from the main method to call the recursive
     * remove method. This method searches for the node to be removed by looking
     * for a specified salary.
     * @param x
     * @return boolean
     */
    public boolean remove(int x)
    {
        RemovalResult result = remove(root, x);
        if(result == null) 
            return false;
        else
        {
            root = result.tree;
            return true;
        }
    }
    
    /**
     * Private recursive removal method will remove a node from the binary
     * search tree. This method will search for the node to be removed based
     * on the specified salary.
     * search tree. 
     * @param bTree
     * @param x
     * @return 
     */
    private RemovalResult remove(Node bTree, int x)
    {
        if(bTree == null)
            return null;
        if(x < bTree.employee.getSalary())
        {
            RemovalResult result = remove(bTree.left, x);
            if(result == null)
                return null;
            bTree.left = result.tree;
            result.tree = bTree;
            return result;
        }
        if(x > bTree.employee.getSalary())
        {
            RemovalResult result = remove(bTree.right, x);
            if(result == null)
                return null;
            bTree.right = result.tree;
            result.tree = bTree;
            return result;
        }
        if(bTree.right == null && bTree.left == null)
            return new RemovalResult(bTree, null);
        if(bTree.right != null && bTree.left != null)
        {
            RemovalResult remResult = removeLargest(bTree.left);
            Node newRoot = remResult.node;
            newRoot.left = remResult.tree;
            newRoot.right = bTree.right;
            bTree.left = null;
            bTree.right = null;
            return new RemovalResult(bTree, newRoot);
        }
        Node node = bTree;
        Node tree;
        if(bTree.left != null)
            tree = bTree.left;
        else
            tree = bTree.right;
        node.left = null;
        node.right = null;
        return new RemovalResult(node, tree);
    }
    
    /**
     * Private method that removes the largest node in the binary tree. 
     * This method is called by the recursive remove method.
     * @param bTree
     * @return 
     */
    private RemovalResult removeLargest(Node bTree)
    {
        if(bTree == null)
            return null;
        if(bTree.right == null)
        {
            Node tree = bTree.left;
            bTree.left = null;
            return new RemovalResult(bTree, tree);
        }
        else
        {
            RemovalResult remResult = removeLargest(bTree.right);
            bTree.right = remResult.tree;
            remResult.tree = bTree;
            return remResult;
        }
    }

    /**
     * Public search method is the search method that can be called from the
     * main method. This method will call the recursive search method to find
     * a node, if it exists, based on a specified salary. This method will also
     * display the name of the Employee and the Salary of the Employee if the
     * specified salary was found. Not Found will be displayed if the Employee
     * was not found.
     * @param x 
     */
    public void search(int x)
    {
        // Create a temp Employee object that is equal to the search result.
        Employee temp = search(x, root);
        
        // Display the Name and Salary.
        System.out.println("Name " + temp.getName());
        System.out.println("Salary " + temp.getSalary());
    }
    
    /**
     * Private recursive search method that will search the binary tree and
     * return the employee object if found.
     * @param x
     * @param bstree
     * @return 
     */
    private Employee search(int x, Node bstree)
    {
       
        // If the node exists, recursively search for the salary value.
        if(bstree != null)
        {
            if(bstree.employee.getSalary() == x)
                return bstree.employee;
            if(x < bstree.employee.getSalary())
                return search(x, bstree.left);
            else
                return search(x, bstree.right);
        }
        else
            return new Employee("Not Found", 0); 
    }
    
    /**
     * Public display method that can be called from the main method. 
     * This method will call the recursive display method.
     */
    public void display()
    {
        display(root);
    }
    
    /**
     * Private method for recursively displaying the binary search tree. 
     * @param root 
     */
    private void display(Node root)
    {
        if(root != null)
        {
            display(root.left);
            System.out.println(root.employee.getName() + " ");
            display(root.right);
        }
    }
    
    /**
     * The main method for calling the above methods. 
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException 
    {
        // Create a new binary search tree object.
        BST bst = new BST();
        
        // Call the add method method to load the text file into
        // the binary search tree structure.
        bst.add();
        // Display the results to confirm that test file loaded properly.
        // Confirm that Sally was not loaded since her salary was onlt $1000
        // different than Nathans.
        System.out.println("Employees from test file minus Sally: ");
        bst.display();
        System.out.println("");
        
        // Test the remove functionality by entering an invalid salary.
        bst.remove(98001);
        // Display the results which should be the full list minus Sally.
        System.out.println("Employees minus anyone making $98001: ");
        bst.display();
        System.out.println("");
        
        // Test the remove functionality by entering a valid salary of 
        // $98000 thus removing Dilbert.
        bst.remove(98000);
        System.out.println("Remove Dilbert at $98000: ");
        bst.display();
        System.out.println("");
        
        // Test the search functionality by searching for an invalid salary.
        System.out.println("The employee making $43297: ");
        bst.search(43297);
        System.out.println("");
        
        // Test the system by searching for Veronica at $150,000.
        System.out.println("The employee making $150000: ");
        bst.search(150000);
        System.out.println("");
    } 
}

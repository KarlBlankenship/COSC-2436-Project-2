/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Karl
 */



public class BST 
{
    
    public class Node
    {
        //int value;
        Employee employee;
        Node left, right;
        
        //Node(int val)
        Node(Employee emp)
        {
            //value = val;
            employee = emp;
            left = null;
            right = null;
        }
        
        //Node(int val, Node leftChild, Node rightChild)
        Node(Employee emp, Node leftChild, Node rightChild)
        {
            //value = val;
            employee.equals(emp);
            left = leftChild;
            right = rightChild;
        }
    }
    
    public Node root = null;
    
    public void add() throws FileNotFoundException, IOException
    {
        //Employee emp = new Employee("Karl", 44000);
        //root = add(emp, root);
//        root = add(44000, null);
//        add(48000, root);
//        add(98000, root);
//        add(23000, root);
//        add(90000, root);
//        add(91000, root);
//        add(87000, root);
//        add(8900, root);
//        add(150000, root);

        // Create List to hold Employee objects and for return.
        //List<Employee> employeeList = new ArrayList();
        
        // Create FileReader object and pass in file.
        FileReader fr = new FileReader("employee.txt");
        
        // Read file into a buffer.
        BufferedReader br = new BufferedReader(fr);
        
        // Create String var to hold each buffered line and burn file header.
        String line = br.readLine(); // Reads in file header which isn't used.
        line = br.readLine(); // Read first line of data after header.
        
        // Write all buffered lines into Employee Instances and write to List.
        while (line != null) {
            
            // Create an instance of Employee.
            //Employee emp = new Employee();
            
            // Split out name and manager from line.
            // -1 is needed since the Veronica line has no second name
            // after the comma in the text file.
            String[] lineEM = line.split(","); 
            Employee emp = new Employee(lineEM[0], Integer.parseInt(lineEM[1]));
            // Set instance fields using array created above.
            //emp.setName(lineEM[0]);
            //emp.setManager(lineEM[1]);
            
            if(root == null)
                root = add(emp, root);
            else
                add(emp, root);
            
            // Add the employee instance to the List.
            //employeeList.add(emp);
            
            // Read next line of file.
            line = br.readLine();    
        }
        //return employeeList; // Return employee list.
        
    }
    
    //private Node add(int x, Node bstree)
    private Node add(Employee emp, Node bstree)
    {
        if(bstree == null)
            return new Node(emp); //return new Node(x);
        if(emp.getSalary() < bstree.employee.getSalary() && Math.abs(emp.getSalary() - bstree.employee.getSalary()) >= 3000)
            bstree.left = add(emp, bstree.left);
        else if(emp.getSalary() > bstree.employee.getSalary() && Math.abs(emp.getSalary() - bstree.employee.getSalary()) >= 3000)
            bstree.right = add(emp, bstree.right);
        return bstree;
    }
    
    
    
    private class RemovalResult
    {
        Node node;  // removed Node.
        Node tree;  // remaining tree.
        
        RemovalResult(Node node, Node tree)
        {
            this.node = node;
            this.tree = tree;
        }
    }
    
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
    
//    public boolean contains(Employee emp)
//    {
//        return contains(emp, root);
//    }
//    
//    private boolean contains(Employee emp, Node bstree)
//    {
//        if(bstree == null)
//            return false;
//        if(emp.salary == bstree.employee.getSalary())
//            return true;
//        if(emp.salary < bstree.employee.getSalary())
//            return contains(emp, bstree.left);
//        else
//            return contains(emp, bstree.right);
//    }
    
//    public int search(int x)
//    {
//        if(contains(x))
//        {
//            System.out.println("Value " + x + " was found in BST");
//            return x;
//        }
//        else
//        {
//            System.out.println("Value " + x + " was not found in BST");
//            return -1;
//        }
//    }
    
    public void search(int x)
    {
       
        
        
        Employee temp = search(x, root);
        
        System.out.println("Name " + temp.getName());
        System.out.println("Salary " + temp.getSalary());
        
    }
    
    private Employee search(int x, Node bstree)
    {
       

        if(bstree != null)
        {
            System.out.println("hello" + bstree.employee.getSalary());
            if(bstree.employee.getSalary() == x)
            {
                System.out.println(x + " equals " + bstree.employee.getSalary()); 
                return bstree.employee;
            }
            if(x < bstree.employee.getSalary())
            {
                System.out.println(x + " less than " + bstree.employee.getSalary());
                return search(x, bstree.left);
            }
            else
            {
                System.out.println(x + " greater than " + bstree.employee.getSalary());
                return search(x, bstree.right);
            }
        }
        else
        {
            return new Employee("Not Found", 0);
        }
            
    }
    
    private void inorder(Node root)
    {
        if(root != null)
        {
            inorder(root.left);
            System.out.println(root.employee.getName() + " ");
            inorder(root.right);
            
        }
    }
    
    public void display()
    {
        inorder(root);
    }
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException 
    {
        BST bst = new BST();
        bst.add();
        bst.display();
        System.out.println(" ");
        bst.remove(98000);
        bst.display();
        System.out.println(" ");
        bst.search(22000);
        
        
    }
    
}

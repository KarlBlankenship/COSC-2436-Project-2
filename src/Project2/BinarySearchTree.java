/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project2;

/**
 *
 * @author Karl
 */
public class BinarySearchTree 
{

    
    private class Node
    {
        Employee employee;      // Element
        Node next;              // Reference to successor.
        Node prev;              // Reference to predecessor.
        
        Node(Employee emp, Node n, Node p)
        {
            employee = emp;
            next = n;
            prev = p;            
        }
        
        Node(Employee emp)
        {
            this(emp, null, null);
        }
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}

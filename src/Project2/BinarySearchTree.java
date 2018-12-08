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

    public class Node 
    {
        private Employee employee;      // Element
        private Node next;              // Reference to successor.
        private Node prev;              // Reference to predecessor.

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
    
    public class Employee 
{
        // Create private variables to hold employee name and employee salary.
        String name;
        int salary;

        public Employee(String name, int salary) 
        {
            this.name = name;
            this.salary = salary;
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}

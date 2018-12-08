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

    private class Employee
    {
        // Create private variables to hold employee name and employee salary.
        private String name;
        private int salary;
    
        /**
         * Default constructor.
         */
        public Employee() 
        {
        }

        /**
         * Overload constructor.
         * @param name
         * @param salary 
         */
        public Employee(String name, int salary) 
        {
            this.name = name;
            this.salary = salary;
        }

        /**
         * Accessor method for getting employee name.
         * @return name
         */
        public String getName() 
        {
            return name;
        }
    
        /**
         * Mutator method for setting employee name.
         * @param name 
         */
        public void setName(String name) 
        {
            this.name = name;
        }
    
        /**
         * Accessor method for getting employee salary.
         * @return salary
         */
        public int getSalary() 
        {
            return salary;
        }

        /**
         * Mutator method for setting employee salary.
         * @param salary
         */
        public void setManager(int salary) 
        {
            this.salary = salary;
        }        
    }
    
    private class Node
    {
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}

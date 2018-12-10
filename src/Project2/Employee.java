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

/**
 * Employee class for storing employing objects. 
 * @author Karl
 */
public class Employee 
{
    // Create private variables to hold employee name and employee salary.
    private String name;
    private int salary;
        
    /**
     * Constructor for creating an employee object with both name and
     * a salary.
     * @param name
     * @param salary 
     */
    Employee(String name, int salary) 
    {
        this.name = name;
        this.salary = salary;
    }
        
    /**
     * Getter method for retrieving the employee name.
     * @return name
     */
    public String getName()
    {
        return name;
    }
        
    /**
     * Getter method for retrieving the employee salary.
     * @return salary 
     */
    public int getSalary()
    {
        return salary;
    }
}

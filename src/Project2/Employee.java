/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

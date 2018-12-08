/*
 * COSC 2436 Programming Fundamentals III with Java
 * Project 2
 * Create a Binary Search Tree for searching employee data.
 */

package Project2;

/**
 * Employee class which will be used for holding the employee name and
 * employee salary.
 * @author Karl Blankenship
 */
public class Employee 
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

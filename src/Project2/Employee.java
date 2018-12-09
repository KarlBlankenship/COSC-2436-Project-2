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
public class Employee {
    // Create private variables to hold employee name and employee salary.
        String name;
        int salary;
        
        Employee(String name, int salary) 
        {
            this.name = name;
            this.salary = salary;
        }
        
        public String getName()
        {
            return name;
        }
        
        public int getSalary()
        {
            return salary;
        }
}

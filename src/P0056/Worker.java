/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0056;

public class Worker {

    private String id;
    private String Name;
    private int age;
    protected float salary;
    private String worklocation;

    public Worker() {
    };

    public Worker(String id, String Name, int age, float salary, String worklocation) {
        this.id = id;
        this.Name = Name;
        this.age = age;
        this.salary = salary;
        this.worklocation = worklocation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getWorklocation() {
        return worklocation;
    }

    public void setWorklocation(String worklocation) {
        this.worklocation = worklocation;
    }
    
    public void display(){
        System.out.printf("%-17s %-20s %-20s %-20s %-20s", id, Name, age, salary, worklocation);
    }

    public int compareTo(Worker o) {
        return o.id.compareTo(this.id);
    }
}

package org.example;

public class Person {
    public int age;
    public String name;
    Person(int age , String name){
        this.name = name;
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }
    public String getName(){
        return this.name;
    }
    public String printPerson(){
        return this.getName() + " " + this.getAge();
    }
}

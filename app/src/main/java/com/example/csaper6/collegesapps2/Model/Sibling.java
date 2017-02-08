package com.example.csaper6.collegesapps2.Model;

/**
 * Created by csaper6 on 12/9/16.
 */
public class Sibling extends Person {
    private int age;
    private String relationship;

    public Sibling() {

        age = 10;
        relationship = "brother";

    }

    public Sibling(int age, String relationship) {
        this.age = age;
        this.relationship = relationship;
    }

    public Sibling(String firstName, String lastName, String relationship, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.relationship = relationship;
    }

    @Override
    public int getAge() {
        return age;
    }

    public String getRelationship() {
        return relationship;
    }
}

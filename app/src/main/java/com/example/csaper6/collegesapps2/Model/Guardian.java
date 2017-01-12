package com.example.csaper6.collegesapps2.Model;

/**
 * Created by csaper6 on 12/9/16.
 */
public class Guardian extends Person {
    private String occupation;
    private int age;

    public Guardian()
    {
        occupation = "unemployed";
        age = 16;

    }

    public Guardian(String job, int age) {
        this.occupation = job;
        this.age = age;
    }

    public Guardian(String firstName, String lastName, String job, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.occupation = job;
        this.age = age;
    }
}

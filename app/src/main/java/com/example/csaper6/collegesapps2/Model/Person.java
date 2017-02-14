package com.example.csaper6.collegesapps2.Model;

/**
 * Created by csaper6 on 12/9/16.
 */
public abstract class Person {
    protected String firstName;
    protected String lastName;
    protected int age;
    protected String objectId;
    protected String ownerId;

    public Person(){
        firstName = "roger";
        lastName = "rabbit";
        age = 555;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public int getAge(){return age;}
}

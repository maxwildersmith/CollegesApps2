package com.example.csaper6.collegesapps2.Model;

import java.util.Date;

/**
 * Created by csaper6 on 12/7/16.
 */
public class Profile {
    private String fname;
    private Date birthday;
    private String lname;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}

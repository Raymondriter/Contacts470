package com.example.contactapp2;

public class Contacts {
    private String fname;
    private String lname;
    private String phonenum;
    private String email;


    public Contacts(String fname, String lname, String phonenum, String email) {
        this.fname = fname;
        this.lname = lname;
        this.phonenum = phonenum;
        this.email = email;
    }




    public String getFname() {
        return fname;
    }


    public String getLname() {
        return lname;
    }


    public String getPhonenum() {
        return phonenum;
    }


    public String getEmail() {
        return email;
    }


}




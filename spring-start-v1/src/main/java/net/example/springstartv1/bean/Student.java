package net.example.springstartv1.bean;

import lombok.Getter;

//java bean is a class
@Getter
public class Student {
    private String FirstName;
    private String LastName;
    private int id;


    //parameterized constructor
    public Student(String FirstName, String LastName, int id) {
            this.FirstName = FirstName;
            this.LastName = LastName;
            this.id = id;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setId(int id) {
        this.id = id;
    }
}

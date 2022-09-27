package com.example.demo2.user;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
  
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private Long id;
private String username;
private String fname;
private String lname;
private String email;
private String password;
private LocalDate dob;
private Integer age;
private String alignment;



public User() {
}


public User(String username, String fname, String lname, String email, LocalDate dob, Integer age, String alignment) {
    this.username = username;
    this.fname = fname;
    this.lname = lname;
    this.email = email;
    this.dob = dob;
    this.age = age;
    this.alignment = alignment;
}


public User(Long id, String username, String fname, String lname, String email, LocalDate dob, Integer age,
        String alignment) {
    this.id = id;
    this.username = username;
    this.fname = fname;
    this.lname = lname;
    this.email = email;
    this.dob = dob;
    this.age = age;
    this.alignment = alignment;
}


public Long getId() {
    return id;
}


public void setId(Long id) {
    this.id = id;
}


public String getUsername() {
    return username;
}


public void setUsername(String username) {
    this.username = username;
}


public String getFname() {
    return fname;
}


public void setFname(String fname) {
    this.fname = fname;
}


public String getLname() {
    return lname;
}


public void setLname(String lname) {
    this.lname = lname;
}


public String getEmail() {
    return email;
}


public void setEmail(String email) {
    this.email = email;
}


public LocalDate getDob() {
    return dob;
}


public void setDob(LocalDate dob) {
    this.dob = dob;
}


public Integer getAge() {
    return age;
}


public void setAge(Integer age) {
    this.age = age;
}


public String getAlignment() {
    return alignment;
}


public void setAlignment(String alignment) {
    this.alignment = alignment;
}

public String getPassword() {
    return password;
}


public void setPassword(String password) {
    this.password = password;
}


@Override
public String toString() {
    return "User [age=" + age + ", alignment=" + alignment + ", dob=" + dob + ", email=" + email + ", fname=" + fname
            + ", id=" + id + ", lname=" + lname + ", password=" + password + ", username=" + username + "]";
}



}

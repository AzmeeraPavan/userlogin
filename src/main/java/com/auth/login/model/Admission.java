package com.auth.login.model;

import jakarta.persistence.*;

@Entity
@Table(name = "admissions")
public class Admission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String surname;
    private String name;
    private String father_name;
    private String mother_name;
    private String date_of_birth;
    private String address;
    private String religion;
    private String caste;
    private String last_school_attended;
    private String blood_group;

    // Getters and Setters
    public Long getId() { return id; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getFather_name() { return father_name; }
    public void setFather_name(String father_name) { this.father_name = father_name; }

    public String getMother_name() { return mother_name; }
    public void setMother_name(String mother_name) { this.mother_name = mother_name; }

    public String getDate_of_birth() { return date_of_birth; }
    public void setDate_of_birth(String date_of_birth) { this.date_of_birth = date_of_birth; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getReligion() { return religion; }
    public void setReligion(String religion) { this.religion = religion; }

    public String getCaste() { return caste; }
    public void setCaste(String caste) { this.caste = caste; }

    public String getLast_school_attended() { return last_school_attended; }
    public void setLast_school_attended(String last_school_attended) { this.last_school_attended = last_school_attended; }

    public String getBlood_group() { return blood_group; }
    public void setBlood_group(String blood_group) { this.blood_group = blood_group; }
}

package com.vishnuparasu.EnforcementDirectorate.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ed_admin")
public class EdAdminEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private int id;

    @Column(name = "edaid")
    private String edaid;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private  Date dob;

    @Column(name = "gender")
    private String gender;

    @Column(name = "pho")
    private String pho;


    @Column(name = "gmail")
    private  String gmail;

    @Column(name = "fname")
    private String fname;

    @Column(name = "adharNumber")
    private String adharNumber;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "edaid", referencedColumnName = "edaid")
    private Set<EdUserCredentials> edUserCredentials = new HashSet<>();

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getAdharNumber() {
        return adharNumber;
    }

    public void setAdharNumber(String adharNumber) {
        this.adharNumber = adharNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPho() {
        return pho;
    }

    public void setPho(String pho) {
        this.pho = pho;
    }

    public String getEdaid() {
        return edaid;
    }

    public void setEdaid(String edaid) {
        this.edaid = edaid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public Set<EdUserCredentials> getEdUserCredentials() {
        return edUserCredentials;
    }

    public void setEdUserCredentials(Set<EdUserCredentials> edUserCredentials) {
        this.edUserCredentials = edUserCredentials;
    }
}

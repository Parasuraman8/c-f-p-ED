package com.vishnuparasu.EnforcementDirectorate.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ed_officers")
public class EdOfficerEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "officer_id")
    private int id;
    @Column(name = "edoid")
    private String edoid;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    @Column(name = "dob")
    private Date dob;

    @Column(name = "pho")
    private long pho;

    @Column(name = "gmail")
    private String gmail;

    @Column(name = "f_name")
    private String fname;

    @Column(name = "community")
    private String community;

    @Column(name = "religion")
    private String religion;

    @Column(name = "adhar_number")
    private String adharNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "qualification")
    private String qualification;

    @Column(name = "job")
    private  String job;

    @Column(name = "job_position")
    private  String jobPosition;

    @Column(name = "salary")
    private String salary;

    @Column(name = "jsd")
    private String jsd;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "edoid", referencedColumnName = "edoid")
    private Set<EdUserCredentials> edUserCredentials = new HashSet<>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEdoid() {
        return edoid;
    }

    public void setEdoid(String edoid) {
        this.edoid = edoid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public long getPho() {
        return pho;
    }

    public void setPho(long pho) {
        this.pho = pho;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getAdharNumber() {
        return adharNumber;
    }

    public void setAdharNumber(String adharNumber) {
        this.adharNumber = adharNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getJsd() {
        return jsd;
    }

    public void setJsd(String jsd) {
        this.jsd = jsd;
    }

    public Set<EdUserCredentials> getEdUserCredentials() {
        return edUserCredentials;
    }

    public void setEdUserCredentials(Set<EdUserCredentials> edUserCredentials) {
        this.edUserCredentials = edUserCredentials;
    }
}
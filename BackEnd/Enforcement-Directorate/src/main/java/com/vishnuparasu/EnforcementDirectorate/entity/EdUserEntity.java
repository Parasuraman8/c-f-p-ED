package com.vishnuparasu.EnforcementDirectorate.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ed_user")
public class EdUserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private int userid;

    @Column(name = "eduid")
    private String eduid;
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

    @Column(name = "fname")
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
    private String job;

    @Column(name = "job_position")
    private String jobPosition;

    @Column(name = "salary")
    private String salary;

    @Column(name = "jsd")
    private String jsd;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "eduid", referencedColumnName = "eduid")
    private List<EdUserCredentials> edUserCredentials = new ArrayList<>();


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "eduid", referencedColumnName ="eduid")
    private List<EdUserBankEntity> edUserBankEntities = new ArrayList<>();

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getEduid() {
        return eduid;
    }

    public void setEduid(String eduid) {
        this.eduid = eduid;
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

    public List<EdUserCredentials> getEdUserCredentials() {
        return edUserCredentials;
    }

    public void setEdUserCredentials(List<EdUserCredentials> edUserCredentials) {
        this.edUserCredentials = edUserCredentials;
    }

    public List<EdUserBankEntity> getEdUserBankEntities() {
        return edUserBankEntities;
    }

    public void setEdUserBankEntities(List<EdUserBankEntity> edUserBankEntities) {
        this.edUserBankEntities = edUserBankEntities;
    }
}

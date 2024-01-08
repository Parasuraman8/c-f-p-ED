package com.vishnuparasu.EnforcementDirectorate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "ed_user_payment")
public class EdUserPaymentEntity {

    @Id
    @Column(name = "eduid_sender")
    private String eduidSender;

    @Column(name = "eduid_recevier")
    private String eduidRecevier;

    @Column(name = "sender_acct_no")
    private long senderAcctNo;

    @Column(name = "recevier_acct_no")
    private long RecevierAcctNo;

    @Column(name = "amount")
    private long amount;

    @Column(name = "date_and_time")
    private Date dateAndTime;

    @Column(name = "is_legal")
    private String isLegal;

    @Column(name = "bank_name_sender")
    private String bankNameSender;

    @Column(name = "bank_name_reciver")
    private String bankNameReciver;

    @Column(name = "bank_country_sender")
    private String bankCountrySender;

    @Column(name = "bank_country_rece")
    private String bankCountryReciver;


    public String getEduidSender() {
        return eduidSender;
    }

    public void setEduidSender(String eduidSender) {
        this.eduidSender = eduidSender;
    }

    public String getEduidRecevier() {
        return eduidRecevier;
    }

    public void setEduidRecevier(String eduidRecevier) {
        this.eduidRecevier = eduidRecevier;
    }

    public long getSenderAcctNo() {
        return senderAcctNo;
    }

    public void setSenderAcctNo(long senderAcctNo) {
        this.senderAcctNo = senderAcctNo;
    }

    public long getRecevierAcctNo() {
        return RecevierAcctNo;
    }

    public void setRecevierAcctNo(long recevierAcctNo) {
        RecevierAcctNo = recevierAcctNo;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getIsLegal() {
        return isLegal;
    }

    public void setIsLegal(String isLegal) {
        this.isLegal = isLegal;
    }

    public String getBankNameSender() {
        return bankNameSender;
    }

    public void setBankNameSender(String bankNameSender) {
        this.bankNameSender = bankNameSender;
    }

    public String getBankNameReciver() {
        return bankNameReciver;
    }

    public void setBankNameReciver(String bankNameReciver) {
        this.bankNameReciver = bankNameReciver;
    }

    public String getBankCountrySender() {
        return bankCountrySender;
    }

    public void setBankCountrySender(String bankCountrySender) {
        this.bankCountrySender = bankCountrySender;
    }

    public String getBankCountryReciver() {
        return bankCountryReciver;
    }

    public void setBankCountryReciver(String bankCountryReciver) {
        this.bankCountryReciver = bankCountryReciver;
    }
}

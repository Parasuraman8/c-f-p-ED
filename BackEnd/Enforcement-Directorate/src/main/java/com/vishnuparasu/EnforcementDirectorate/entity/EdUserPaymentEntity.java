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
    String eduidSender;

    @Column(name = "eduid_recevier")
    String eduidRecevier;

    @Column(name = "sender_acct_no")
    String senderAcctNo;

    @Column(name = "recevier_acct_no")
    String RecevierAcctNo;

    @Column(name = "amount")
    long amount;

    @Column(name = "date_and_time")
    Date dateAndTime;

    @Column(name = "is_legal")
    boolean isLegal;

    @Column(name = "bank_name_sender")
    String bankNameSender;

    @Column(name = "bank_name_reciver")
    String bankNameReciver;

    @Column(name = "bank_country_sender")
    String bankCountrySender;

    @Column(name = "bank_country_rece")
    String bankCountryReciver;


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

    public String getSenderAcctNo() {
        return senderAcctNo;
    }

    public void setSenderAcctNo(String senderAcctNo) {
        this.senderAcctNo = senderAcctNo;
    }

    public String getRecevierAcctNo() {
        return RecevierAcctNo;
    }

    public void setRecevierAcctNo(String recevierAcctNo) {
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

    public boolean isLegal() {
        return isLegal;
    }

    public void setLegal(boolean legal) {
        isLegal = legal;
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

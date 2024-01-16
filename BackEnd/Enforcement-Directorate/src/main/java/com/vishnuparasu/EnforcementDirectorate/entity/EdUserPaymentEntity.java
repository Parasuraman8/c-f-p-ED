package com.vishnuparasu.EnforcementDirectorate.entity;

import com.sun.org.glassfish.external.statistics.TimeStatistic;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "ed_user_payment")
public class EdUserPaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private  int paymentId;
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
    private String dateAndTime;

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

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

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
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

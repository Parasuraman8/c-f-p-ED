package com.vishnuparasu.EnforcementDirectorate.entity;

import javax.persistence.*;

@Entity
@Table(name = "ed_user_bank")
public class EdUserBankEntity {

    @Id
    @Column(name = "acct_no")
    private long acctNo;

    @Column(name = "eduid")
    private String eduid;

    @Column(name = "bank_country")
    private String bankCountry;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "branch")
    private String branch;

    @Column(name = "total_amount")
    private long totalAmount;

    @Column(name = "acct_status")
    private String acctStatus;

    public long getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(long acctNo) {
        this.acctNo = acctNo;
    }

    public String getBankCountry() {
        return bankCountry;
    }

    public void setBankCountry(String bankCountry) {
        this.bankCountry = bankCountry;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(String acctStatus) {
        this.acctStatus = acctStatus;
    }
}

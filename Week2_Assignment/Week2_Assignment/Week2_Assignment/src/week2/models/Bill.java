package week2.models;

import week2.enums.BillType;

import java.util.Date;

public class Bill {

    //MemberAccount member;

    private long id;

    private double amount;

    private String processDate;

    private BillType billType; //ENUM Olabilir.

    private String memberCode;

    private static long lastID=0;

    private int paidInformation;

    public Bill() {

    }

    public Bill(double amount, String processDate, BillType billType , String memberCode) {
        this.id = lastID+1;
        this.amount = amount;
        this.processDate = processDate;
        this.billType = billType;
        this.memberCode = memberCode;
        this.paidInformation=-1;
        lastID+=1;
    }

    public long getId() {
        return id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getPaidInformation() {
        return paidInformation;
    }

    public void setPaidInformation(int paidInformation) {
        this.paidInformation = paidInformation;
    }

    public void setBillType(BillType billType) {
        this.billType = billType;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public double getAmount() {
        return amount;
    }

    public String getProcessDate() {
        return processDate;
    }

    public void setProcessDate(String processDate) {
        this.processDate = processDate;
    }

    public BillType getBillType() {
        return billType;
    }

    public String getMemberCode() {
        return memberCode;
    }
}

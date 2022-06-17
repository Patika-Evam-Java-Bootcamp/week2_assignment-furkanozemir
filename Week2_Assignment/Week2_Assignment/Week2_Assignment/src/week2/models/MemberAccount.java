package week2.models;

public class MemberAccount {

    private long id;
    private String name;
    private String surName;
    private String memberCode;
    private double balance;
    private String telephoneNumber;

    private static long lastID=0;

    public MemberAccount() {

    }

    public MemberAccount(String name, String surName, double balance, String telephoneNumber) {
        this.id = lastID+1;
        this.name = name;
        this.surName = surName;
        this.memberCode = String.valueOf(this.id)+this.name.substring(0,2).toUpperCase();
        this.balance = balance;
        this.telephoneNumber = telephoneNumber;
        lastID+=1;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getMemberCode() {
        return String.valueOf(this.id)+this.name.substring(0,2).toUpperCase();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
}

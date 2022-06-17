package week2.interfaces;

import week2.enums.BillType;
import week2.exceptions.InsufficientBalance;
import week2.exceptions.MemberNotFoundException;
import week2.models.Bill;
import week2.models.MemberAccount;
import week2.models.Response;

public interface BillServiceImp {

    Response toPay(Bill bill, String memberCode) throws Exception;

    Response find(BillType billType, String memberCode) throws Exception;

    Response cancelToPay(Bill bill,String memberCode) throws Exception;

    void removeBill(Bill bill) throws Exception;

    void createBill(Bill bill) throws Exception;

    void updateBill(Bill bill,double amount, String processDate, BillType billType , String memberCode) throws Exception;

    void readBill(Bill bill) throws Exception;

/*
    Response find(Bill bill, MemberAccount memberAccount, String telephoneNumber) throws Exception;
*/
}

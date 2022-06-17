package week2.services;

import week2.enums.BillType;
import week2.models.Bill;
import week2.models.MemberAccount;
import week2.models.Response;

public class Client extends BillService{

    @Override
    public Response toPay(Bill bill, String memberCode) throws Exception {
        return super.toPay(bill, memberCode);
    }

    @Override
    public void createBill(Bill bill) throws Exception {
        super.createBill(bill);
    }

    @Override
    public void updateBill(Bill bill,double amount, String processDate, BillType billType , String memberCode) throws Exception {
        super.updateBill(bill,amount,processDate,billType,memberCode);
    }

    @Override
    public void readBill(Bill bill) throws Exception {
        super.readBill(bill);
    }

    @Override
    public Response find(BillType billType,String memberCode) throws Exception {
        return super.find(billType, memberCode);
    }

    @Override
    public Response find(BillType billType, String memberCode,String telephoneNumber) throws Exception {
        return super.find( billType, memberCode,telephoneNumber);
    }

    @Override
    public void removeBill(Bill bill) throws Exception {
        super.removeBill(bill);
    }

    @Override
    public Response cancelToPay(Bill bill, String memberCode) throws Exception {
        return super.cancelToPay(bill, memberCode);
    }
}

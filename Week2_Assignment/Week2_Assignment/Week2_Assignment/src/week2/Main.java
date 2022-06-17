package week2;

import week2.enums.BillType;
import week2.models.Bill;
import week2.models.MemberAccount;
import week2.models.Response;
import week2.services.BillService;
import week2.services.MemberAccountService;

public class Main {
    public static void main(String[] args) throws Exception {
        Response response;
        MemberAccountService service = new MemberAccountService();
        BillService billService = new BillService();

        MemberAccount member = new MemberAccount("Furkan","OZEMIR",2000,"0531XXX1001");
        service.create(member);

        MemberAccount memberX = new MemberAccount("SINAN","OZEMIR",2000,"0539XXX2032");
        service.create(memberX);

        Bill bill = new Bill(1000, Response.getNow(), BillType.TELEFON,"1FU");
        billService.createBill(bill);

        response = billService.find(BillType.TELEFON,"1FU","0531XXX1001");
        System.out.println(response.getReturnStatus().equals("1") ? "Başarılı" : "Başarısız");

        response = billService.toPay(bill,"1FU");
        System.out.println(response.getReturnStatus().equals("1") ? "Başarılı" : "Başarısız");

        response = billService.cancelToPay(bill,"1FU");
        System.out.println(response.getReturnStatus().equals("1") ? "Başarılı" : "Başarısız");

        response = billService.cancelToPay(bill,"2SI");
        System.out.println(response.getReturnStatus().equals("1") ? "Başarılı" : "Başarısız");

        billService.readBill(bill);
        billService.updateBill(bill,2000,Response.getNow(),BillType.SU,"2SI");
        billService.readBill(bill);

        response = billService.find(BillType.SU,"2SI");
        System.out.println(response.getReturnStatus().equals("1") ? "Başarılı" : "Başarısız");

        billService.updateBill(bill,2000,Response.getNow(),BillType.TELEFON,"2SI");
        response = billService.find(BillType.TELEFON,"2SI","0539XXX2032");
        System.out.println(response.getReturnStatus().equals("1") ? "Başarılı" : "Başarısız");
    }
}

package week2.services;

import week2.enums.BillType;
import week2.exceptions.BillNotFoundException;
import week2.exceptions.InsufficientBalance;
import week2.exceptions.MemberNotFoundException;
import week2.interfaces.BillServiceImp;
import week2.models.Bill;
import week2.models.MemberAccount;
import week2.models.Response;

import java.util.ArrayList;
import java.util.List;

public class BillService implements BillServiceImp {

    private List<Bill> billList = new ArrayList<Bill>();
    private MemberAccountService memberAccountService = new MemberAccountService();
    private Response response;

    @Override
    public Response toPay(Bill bill,String memberCode) throws Exception {
        try {
            response = new Response();
            MemberAccount memberAccount = memberAccountService.findByMemberCode(memberCode);
            if(bill.getMemberCode().equals(memberAccount.getMemberCode())){
               if (bill!=null){
                   if(bill.getPaidInformation()<0){
                       if(bill.getAmount() < memberAccount.getBalance()){
                           memberAccount.setBalance(memberAccount.getBalance()-bill.getAmount());
                           bill.setPaidInformation(1);
                           response.setReturnCode("1");
                       }else{
                           throw  new InsufficientBalance("Ödeme için yeterli bakiye bulunmamaktadır.");
                       }
                   }else{
                       response.setReturnCode("0");
                   }
               }else{
                   throw new BillNotFoundException("Fatura bulunamadı.\n");
               }
            }else {
                throw  new MemberNotFoundException("Kullanıcı bulunamadı.\n");
            }
        }catch (Exception e){
            response.setReturnCode("0");
        }
           finally {
            return response;
        }
    }

    @Override
    public void createBill(Bill bill) throws Exception {
        try {
            billList.add(bill);
            System.out.format("%d id numaralı fatura oluşturuldu ve sisteme kayıt edildi.\n",bill.getId());
        }catch (Exception e){
            throw new BillNotFoundException("Fatura bulunamadı.");
        }
    }

    @Override
    public void updateBill(Bill bill,double amount, String processDate, BillType billType , String memberCode) throws Exception {
        bill.setBillType(billType);
        bill.setAmount(amount);
        bill.setMemberCode(memberCode);
        bill.setProcessDate(Response.getNow());
    }

    @Override
    public void readBill(Bill bill) throws Exception {
        try {
            System.out.format(" ID : %d \n Process-Date : %s \n Amount : %.2f \n" +
                    " Bill-Type : %s \n Member-Code : %s \n Paid-Information : %s \n",bill.getId(),bill.getProcessDate()
            ,bill.getAmount(),bill.getBillType(),bill.getMemberCode(),
                    bill.getPaidInformation()>0 ? new String("Paid") : new String("Not Paid"));
        }catch (Exception e){
            throw new BillNotFoundException("Fatura bulunamadı.\n");
        }
    }

    @Override
    public Response find(BillType billType,String memberCode) throws Exception {
        List<Bill> findBills = new ArrayList<Bill>();
        MemberAccount member = memberAccountService.findByMemberCode(memberCode);
        try {
            response = new Response();
            if(member!=null){
                for(Bill bills : billList){
                    if(bills.getBillType().equals(billType) &&
                            bills.getMemberCode().equals(memberCode)){
                        response.setReturnCode("1");
                    }else {
                        response.setReturnCode("0");
                    }
                }
            }else{
                throw new MemberNotFoundException("Kullanıcı bulunamadı.\n");
            }
        }catch (Exception e){
            response.setReturnCode("0");
        }
        finally {
            return response;
        }
    }

    public Response find(BillType billType,String memberCode,String telephoneNumber) throws Exception {
            List<Bill> findBills = new ArrayList<Bill>();
            MemberAccount member = memberAccountService.findByMemberCode(memberCode);
        try {
            response = new Response();
            if(member!=null){
                for(Bill bills : billList){
                    if(bills.getBillType().equals(BillType.TELEFON) &&
                            bills.getMemberCode().equals(memberCode) &&
                                    member.getTelephoneNumber().equals(telephoneNumber)){
                        response.setReturnCode("1");
                    }else {
                        response.setReturnCode("0");
                    }
                }
            }else{
                throw new MemberNotFoundException("Kullanıcı bulunamadı.\n");
            }
        }catch (Exception e){
            response.setReturnCode("0");
        }
        finally {
            return response;
        }
    }

    @Override
    public void removeBill(Bill bill) throws Exception {
            try {
                billList.remove(bill);
                System.out.println("%d id li fatura sistemden kaldırıldı.");
            }catch (Exception e){
                throw new BillNotFoundException("Fatura bulunamadı.");
            }
    }

    @Override
    public Response cancelToPay(Bill bill,String memberCode) throws Exception{
        try{
            response = new Response();
            MemberAccount memberAccount = memberAccountService.findByMemberCode(memberCode);
            if (memberAccount!=null){
                if(bill!=null){
                    if(bill.getMemberCode().equals(memberAccount.getMemberCode())){
                        if(bill.getPaidInformation()>0){
                            bill.setPaidInformation(-1);
                            response.setReturnCode("1");
                        }else{
                            response.setReturnCode("0");
                        }
                    }else {
                        throw  new MemberNotFoundException("Başkası adına fatura ödeyemezsiniz.\n");
                    }
                }else{
                    throw new BillNotFoundException("Fatura bulunamadı.\n");
                }
            }else{
                throw new MemberNotFoundException("Kullanıcı bulunamadı.\n");
            }
    }catch (Exception e){
        response.setReturnCode("0");
    }
            finally {
            return  response;
        }
    }
}

package week2.services;

import week2.exceptions.MemberNotFoundException;
import week2.interfaces.MemberAccountServiceImp;
import week2.models.MemberAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class MemberAccountService implements MemberAccountServiceImp {

    public static List<MemberAccount> memberAccountList = new ArrayList<MemberAccount>();

    @Override
    public void create(MemberAccount member) throws Exception {
          try {
              memberAccountList.add(member);
              System.out.format("%d id numaralı yeni %s-%s isimli kullanıcı oluşturuldu.\n",member.getId(),
                      member.getName(),member.getSurName());
          }catch(Exception e){
               throw new MemberNotFoundException("Kullanıcı bulunamadı.\n");
          }
    }

    @Override
    public void delete(MemberAccount member) throws Exception {
        try {
            memberAccountList.remove(member);
            System.out.format("%d id numaralı yeni %s-%s isimli kullanıcı sistemden kaldırıldı.\n",member.getId(),
                    member.getName(),member.getSurName());
        }catch (Exception e){
            throw new MemberNotFoundException("Kullanıcı bulunamadı.\n");
        }
    }

    @Override
    public void update(MemberAccount id) throws Exception {
        try {

        }catch (Exception e){
            throw new MemberNotFoundException("Kullanıcı bulunamadı.\n");
        }
    }

    @Override
    public void read(MemberAccount member) throws Exception {
       try {
           System.out.format("\nKullanıcı adı : %s \nKullanıcı soyadı : %s \nKullanıcı bakiyesi : %.2f \n" +
                           "Kullanıcı telefon numarası : %s \nKullanıcı kodu: %s\n",member.getName(),member.getSurName(),
                   member.getBalance(),member.getTelephoneNumber(),member.getMemberCode());
       }catch (Exception e){
           throw new MemberNotFoundException("Kullanıcı bulunamadı.\n");
       }
    }

    @Override
    public MemberAccount findById(long id) throws Exception {
        try {
            return memberAccountList.stream().findAny().filter(memberAccount -> memberAccount.getId()==id).get();
        }catch (Exception e){
            throw new MemberNotFoundException("Kullanıcı bulunamadı.\n");
        }
    }

    @Override
    public MemberAccount findByMemberCode(String memberCode) throws Exception {
        MemberAccount memberAccountX = null;
        try {
            for (MemberAccount memberAccount : memberAccountList) {
                if (memberAccount.getMemberCode().equals(memberCode)) {
                    memberAccountX = memberAccount;
                }
            }
        } catch (Exception e) {
            throw new MemberNotFoundException("Kullanıcı bulunamadı.\n");
        }
        finally {
            return memberAccountX;
        }
    }
}

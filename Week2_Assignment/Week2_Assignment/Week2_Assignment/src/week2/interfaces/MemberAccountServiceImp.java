package week2.interfaces;

import week2.models.MemberAccount;

import java.util.Optional;

public interface MemberAccountServiceImp {

    void create(MemberAccount member) throws Exception;

    void delete(MemberAccount member) throws Exception;

    void update(MemberAccount member) throws Exception;

    void read(MemberAccount member) throws Exception;

    MemberAccount findById(long id) throws Exception;

    MemberAccount findByMemberCode(String memberCode) throws Exception;
}

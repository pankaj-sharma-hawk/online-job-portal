package com.onlinejobportal.portal.repositories;

import com.onlinejobportal.portal.model.dos.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by pankaj on 08,2018
 */
public interface UserAccountRepository extends JpaRepository<UserAccount,Integer> {

    @Query("SELECT u from UserAccount u where u.email=?1 AND u.password=?2")
    UserAccount fetchUserDetail(String emailId,String password);
}

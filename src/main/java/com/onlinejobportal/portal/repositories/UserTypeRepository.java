package com.onlinejobportal.portal.repositories;

import com.onlinejobportal.portal.model.dos.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by pankaj on 08,2018
 */
public interface UserTypeRepository extends JpaRepository<UserType,Integer> {

    @Query("select u from UserType u where u.userTypeName = ?1")
    UserType findUserTypeIdByName(String name);
}

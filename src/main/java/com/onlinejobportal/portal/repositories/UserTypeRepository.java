package com.onlinejobportal.portal.repositories;

import com.onlinejobportal.portal.model.dos.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pankaj on 08,2018
 */
public interface UserTypeRepository extends JpaRepository<UserType,Integer> {
}

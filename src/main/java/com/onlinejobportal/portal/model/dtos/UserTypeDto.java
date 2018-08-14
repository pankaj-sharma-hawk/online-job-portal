package com.onlinejobportal.portal.model.dtos;

import com.onlinejobportal.portal.model.dos.UserAccount;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by pankaj on 08,2018
 */
public class UserTypeDto {
    private Integer id;
    private String userTypeName;
    private List<UserAccountDto> listOfUserAccounts;
}

package com.onlinejobportal.portal.model.dtos;

import com.onlinejobportal.portal.model.dos.UserAccount;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by pankaj on 08,2018
 */
public class UserLogDto {
    private Integer id;
    private UserAccountDto userAccount;
    private Date lastLoginDate;
    private Date lastJobApply;

}

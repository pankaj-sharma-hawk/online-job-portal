package com.onlinejobportal.portal.model.dtos;

import com.onlinejobportal.portal.model.dos.UserLog;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by pankaj on 08,2018
 */
public class UserAccountDto {

    private Integer id;
    private UserTypeDto userType;
    private String email;
    private String password;
    private Date dateOfBirth;
    private Character gender;
    private Character isActive;
    private String contactNumber;
    private Character smsNotificationActive;
    private Character emailNotificationActive;
    private String userImageUrl;
    private Date registrationDate;
    private List<UserLogDto> listOfUserLogs;


}

package com.onlinejobportal.portal.model.dos;

import sun.rmi.runtime.Log;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;

/**
 * Created by pankaj on 08,2018
 */
@Entity
@Table(name = "user_account")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_type_id")
    private UserType userType;

    private String email;
    @Column(name="password",length = 100)
    private String password;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    private Character gender;
    private Character isActive;
    @Column(name="contact_number",length = 10)
    private String contactNumber;
    private Character smsNotificationActive;
    private Character emailNotificationActive;
    private String userImageUrl;
    private Date registrationDate;


    @OneToMany(targetEntity = UserLog.class,mappedBy = "userAccount" , cascade = CascadeType.ALL,
    fetch = FetchType.LAZY)
    private List<UserLog> listOfUserLogs;


}

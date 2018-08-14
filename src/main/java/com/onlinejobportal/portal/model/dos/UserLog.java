package com.onlinejobportal.portal.model.dos;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by pankaj on 08,2018
 */
@Entity
@Data
@Table(name="user_log")
public class UserLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="user_account_id")
    private UserAccount userAccount;

    private Date lastLoginDate;
    private Date lastJobApply;

}

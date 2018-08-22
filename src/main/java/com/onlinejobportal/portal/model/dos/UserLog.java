package com.onlinejobportal.portal.model.dos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by pankaj on 08,2018
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="user_log")
public class UserLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //@ManyToOne
    @JoinColumn(name="user_account_id")
    private Integer userAccountId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DATE", updatable = false)
    private Date lastLoginDate;

    private Date lastJobApply;

    public UserLog(int userAccountId){
        this.userAccountId=userAccountId;
    }

}

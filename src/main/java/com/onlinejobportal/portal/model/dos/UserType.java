package com.onlinejobportal.portal.model.dos;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pankaj on 08,2018
 */
@Entity
@Data
@Table(name = "user_type")
public class UserType {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "user_type_name")
    private String userTypeName;

    @OneToMany(targetEntity = UserAccount.class,mappedBy = "userType" , cascade = CascadeType.ALL,
    fetch = FetchType.LAZY)
    private List<UserAccount> listOfUserAccounts;
}

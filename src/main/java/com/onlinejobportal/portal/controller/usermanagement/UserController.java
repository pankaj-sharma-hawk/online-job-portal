package com.onlinejobportal.portal.controller.usermanagement;

import com.onlinejobportal.common.constant.Constants;
import com.onlinejobportal.common.dto.ResponseDto;
import com.onlinejobportal.portal.handler.UserHandler;
import com.onlinejobportal.portal.model.dos.UserAccount;
import com.onlinejobportal.portal.model.dos.UserLog;
import com.onlinejobportal.portal.model.dos.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by pankaj on 08,2018
 */
@RestController
@RequestMapping(Constants.USER)
public class UserController {

    @Autowired
    private UserHandler userAccountHandler;

    @GetMapping(Constants.USER_LOG)
    public List<UserLog> getAllUserLogs(){
        return userAccountHandler.getAllUserLogs();
    }

    @GetMapping(Constants.USER_TYPE)
    public List<UserType> getAllUserTypes(){
        return userAccountHandler.getAllUserTypes();
    }

    @GetMapping(Constants.USER_ACCOUNT)
    public List<UserAccount> getAllUserAccounts(){
        return userAccountHandler.getAllUserAccounts();
    }

    @PostMapping(Constants.USER_LOG)
    public ResponseDto saveUserLog(@RequestBody UserLog userLog){
        return userAccountHandler.saveUserLog(userLog);
    }

    @PostMapping(Constants.USER_TYPE)
    public ResponseDto saveUserType(@RequestBody UserType userType){
        return userAccountHandler.saveUserType(userType);
    }

    @PostMapping(Constants.USER_ACCOUNT)
    public ResponseDto saveUserAccount(@RequestBody UserAccount userAccount){
        return userAccountHandler.saveUserAccount(userAccount);
    }
}

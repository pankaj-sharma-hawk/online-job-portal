package com.onlinejobportal.portal.controller.usermanagement;

import com.onlinejobportal.common.constant.Constants;
import com.onlinejobportal.common.dto.ResponseDto;
import com.onlinejobportal.portal.handler.UserHandler;
import com.onlinejobportal.portal.model.dos.UserAccount;
import com.onlinejobportal.portal.model.dos.UserLog;
import com.onlinejobportal.portal.model.dos.UserType;
import com.onlinejobportal.portal.model.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by pankaj on 08,2018
 */
@RestController
@RequestMapping(Constants.USER)
public class UserController {

    @Autowired
    private UserHandler userAccountHandler;

    @GetMapping(Constants.LOG)
    public List<UserLog> getAllUserLogs(){
        return userAccountHandler.getAllUserLogs();
    }

    @GetMapping(Constants.TYPE)
    public List<UserType> getAllUserTypes(){
        return userAccountHandler.getAllUserTypes();
    }

    @GetMapping(Constants.TYPE+Constants.ID)
    public UserType fetchUserTypeId(@PathParam(Constants.USER_TYPE)String userTypeName){
        return userAccountHandler.fetchUserTypeId(userTypeName);
    }

    @GetMapping(Constants.ACCOUNT)
    public List<UserAccount> getAllUserAccounts(){
        return userAccountHandler.getAllUserAccounts();
    }

    @PostMapping(Constants.LOG)
    public ResponseDto saveUserLog(@RequestBody UserLog userLog) throws Exception {
        return userAccountHandler.saveUserLog(userLog);
    }

    @PostMapping(Constants.TYPE)
    public ResponseDto saveUserType(@RequestBody UserType userType) throws Exception {
        return userAccountHandler.saveUserType(userType);
    }

    @PostMapping(Constants.ACCOUNT)
    public ResponseDto saveUserAccount(@RequestBody UserAccount userAccount) throws Exception {
        return userAccountHandler.saveUserAccount(userAccount);
    }

    @PostMapping(Constants.USER+Constants.LOGIN)
    public ResponseDto login(@RequestBody UserDto userDto) throws Exception {
        return userAccountHandler.userLogin(userDto);
    }
}

package com.onlinejobportal.portal.handler;

import com.onlinejobportal.common.constant.Constants;
import com.onlinejobportal.common.dto.ResponseDto;
import com.onlinejobportal.portal.model.dos.UserAccount;
import com.onlinejobportal.portal.model.dos.UserLog;
import com.onlinejobportal.portal.model.dos.UserType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by pankaj on 08,2018
 */
@Service
public class UserAccountHandler {

    
    public List<UserLog> getAllUserLogs() {
        return null;
    }

    public List<UserType> getAllUserTypes() {
        return null;
    }

    public List<UserAccount> getAllUserAccounts() {
        return null;
    }

    public ResponseDto saveUserLog(UserLog userLog) {
        return null;

    }

    public ResponseDto saveUserType(UserType userType) {
        return null;
    }

    public ResponseDto saveUserAccount(UserAccount userAccount) {
        return null;

    }
}

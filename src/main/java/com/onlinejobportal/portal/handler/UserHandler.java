package com.onlinejobportal.portal.handler;

import com.onlinejobportal.common.constant.Constants;
import com.onlinejobportal.common.dto.ResponseDto;
import com.onlinejobportal.common.exceptions.JPAException;
import com.onlinejobportal.portal.model.dos.UserAccount;
import com.onlinejobportal.portal.model.dos.UserLog;
import com.onlinejobportal.portal.model.dos.UserType;
import com.onlinejobportal.portal.repositories.UserAccountRepository;
import com.onlinejobportal.portal.repositories.UserLogRepository;
import com.onlinejobportal.portal.repositories.UserTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by pankaj on 08,2018
 */
@Service
@Slf4j
public class UserHandler{

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private UserLogRepository userLogRepository;

    @Autowired
    private UserTypeRepository userTypeRepository;

    public List<UserLog> getAllUserLogs() {
        return userLogRepository.findAll();
    }

    public List<UserType> getAllUserTypes() {
        return userTypeRepository.findAll();
    }

    public List<UserAccount> getAllUserAccounts() {
        return userAccountRepository.findAll();
    }

    public ResponseDto saveUserLog(UserLog userLog) {
        ResponseDto responseDto = null;
        try {
            userLogRepository.save(userLog);
            responseDto.setMessage("Success");
        } catch (Exception e) {

         log.error("[saveUserLog] [Message :- {} ] [Exception :- {} ]",Constants.JPA_REPOSITARY_EXCEPTION,e.getStackTrace());
         throw new JPAException(Constants.JPA_REPOSITARY_EXCEPTION);
        }
        return responseDto;

    }

   public ResponseDto saveUserType(UserType userType) {
        ResponseDto responseDto = null;
        try {
            userTypeRepository.save(userType);
            responseDto.setMessage("Success");
        } catch (Exception e) {

            log.error("[saveUserType] [Message :- {} ] [Exception :- {} ]",Constants.JPA_REPOSITARY_EXCEPTION,e.getStackTrace());
            throw new JPAException(Constants.JPA_REPOSITARY_EXCEPTION);
        }
        return responseDto;
    }

    public ResponseDto saveUserAccount(UserAccount userAccount) {
        ResponseDto responseDto = null;
        try {
            userAccountRepository.save(userAccount);
            responseDto.setMessage("Success");
        } catch (Exception e) {

            log.error("[saveUserAccount] [Message :- {} ] [Exception :- {} ]",Constants.JPA_REPOSITARY_EXCEPTION,e.getStackTrace());
            throw new JPAException(Constants.JPA_REPOSITARY_EXCEPTION);
        }
        return responseDto;

    }
}

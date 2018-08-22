package com.onlinejobportal.portal.handler;

import com.onlinejobportal.common.constant.Constants;
import com.onlinejobportal.common.dto.ResponseDto;
import com.onlinejobportal.common.exceptions.JPAException;
import com.onlinejobportal.common.util.StringUtil;
import com.onlinejobportal.portal.model.dos.UserAccount;
import com.onlinejobportal.portal.model.dos.UserLog;
import com.onlinejobportal.portal.model.dos.UserType;
import com.onlinejobportal.portal.model.dtos.UserDto;
import com.onlinejobportal.portal.repositories.UserAccountRepository;
import com.onlinejobportal.portal.repositories.UserLogRepository;
import com.onlinejobportal.portal.repositories.UserTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public ResponseDto saveUserLog(UserLog userLog){
        ResponseDto responseDto = new ResponseDto();
        try {
            userLogRepository.save(userLog);
            responseDto.setMessage("Success");
            responseDto.setSuccess(true);
        } catch (Exception e) {
            responseDto.setSuccess(false);
            responseDto.setMessage("Failed");
            log.error("[saveUserLog] [Message :- {} ] [Exception :- {} ]",Constants.JPA_REPOSITORY_EXCEPTION,e.getStackTrace());
        }
        return responseDto;

    }

   public ResponseDto saveUserType(UserType userType) throws Exception {
        ResponseDto responseDto = null;
        try {
            userTypeRepository.save(userType);
            responseDto.setMessage("Success");
            responseDto.setSuccess(true);
        } catch (Exception e) {

            log.error("[saveUserType] [Message :- {} ] [Exception :- {} ]",Constants.JPA_REPOSITORY_EXCEPTION,e.getStackTrace());
            throw new JPAException(Constants.JPA_REPOSITORY_EXCEPTION);
        }
        return responseDto;
    }

    public ResponseDto saveUserAccount(UserAccount userAccount)throws Exception {
        ResponseDto responseDto = null;
        try {
            userAccountRepository.save(userAccount);
            responseDto.setMessage("Success");
            responseDto.setSuccess(true);
        } catch (Exception e) {

            log.error("[saveUserAccount] [Message :- {} ] [Exception :- {} ]",Constants.JPA_REPOSITORY_EXCEPTION,e.getStackTrace());
            throw new JPAException(Constants.JPA_REPOSITORY_EXCEPTION);
        }
        return responseDto;

    }

    public UserType fetchUserTypeId(String userTypeName) {
        try {
            return userTypeRepository.findUserTypeIdByName(userTypeName);
        } catch (Exception e) {
            log.error("[fetchUserTypeId] [Message :- {} ] [Exception :- {} ]",Constants.JPA_REPOSITORY_EXCEPTION,e.getStackTrace());
            throw new JPAException(Constants.JPA_REPOSITORY_EXCEPTION);
        }
    }

    public ResponseDto userLogin(UserDto userDto) throws Exception {
        ResponseDto responseDto=null;
        try {
            UserAccount userAccount = userAccountRepository.fetchUserDetail(userDto.getEmailId(), userDto.getPassword());

            if(StringUtil.isNull(userAccount)){
                responseDto=new ResponseDto("Success",true);
                log.info("[userLogin] [Message :- {} ]",Constants.USER_LOGGED_IN_SUCCESSFULLY);
                saveUserLog(new UserLog());
            }else{
                responseDto=new ResponseDto("Faild",false);
                log.info("[userLogin] [Message :- {} ] ",Constants.INVALID_CREDENTIAL);
            }
            return responseDto;
        } catch (Exception e) {
            log.error("[fetchUserTypeId] [Message :- {} ] [Exception :- {} ]",Constants.JPA_REPOSITORY_EXCEPTION,e.getStackTrace());
            throw new JPAException(Constants.JPA_REPOSITORY_EXCEPTION);
        }
    }
}

package com.onlinejobportal.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by pankaj on 08,2018
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {

    private String message;
    private Boolean success;
}

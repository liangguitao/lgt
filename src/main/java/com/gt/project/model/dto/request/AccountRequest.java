package com.gt.project.model.dto.request;

import lombok.Data;

import java.math.BigDecimal;

/**
* @Param
* @description   账户信息
* @author liangguitao
* @date 2021/6/4 14:37
* @return
* @throws
*/
@Data
public class AccountRequest {

    private String name;

    private BigDecimal input;

    private BigDecimal out;

}

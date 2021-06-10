package com.gt.project.model.service;

import com.gt.project.model.common.RestResponse;
import com.gt.project.model.dto.request.AccountRequest;

/**
* @Param
* @description   账户
* @author liangguitao
* @date 2021/6/4 14:35
* @return
* @throws
*/
public interface AccountService {

    RestResponse<?> account(AccountRequest accountRequest);

}

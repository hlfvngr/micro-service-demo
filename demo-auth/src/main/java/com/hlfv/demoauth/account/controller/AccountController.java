package com.hlfv.demoauth.account.controller;

import com.hlfv.demoauth.account.dto.AccountLoginDTO;
import com.hlfv.demoauth.account.entity.Account;
import com.hlfv.demoauth.account.service.AccountService;
import com.hlfv.democommon.vo.CommonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("/login")
    public CommonResult<String> login(AccountLoginDTO accountLoginDTO) {

        return CommonResult.success("token");
    }


}

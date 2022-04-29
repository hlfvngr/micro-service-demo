package com.hlfv.demoauth.account.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hlfv.demoauth.account.entity.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService  extends IService<Account>, UserDetailsService {

}

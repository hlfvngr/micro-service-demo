package com.hlfv.demoauth.account.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hlfv.demoauth.account.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountMapper extends BaseMapper<Account> {

    Account selectByAccountName(@Param("accountName") String accountName);
}

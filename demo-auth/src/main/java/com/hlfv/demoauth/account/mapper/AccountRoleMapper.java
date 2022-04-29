package com.hlfv.demoauth.account.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hlfv.demoauth.account.entity.AccountRole;
import com.hlfv.demoauth.role.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * <p>
 * 用户角色关联 Mapper 接口
 * </p>
 *
 * @author hflv
 * @since 2022-04-26
 */
public interface AccountRoleMapper extends BaseMapper<AccountRole> {

    Set<Role> selectRoleByAccount(@Param("accountId") Long accountId);
}

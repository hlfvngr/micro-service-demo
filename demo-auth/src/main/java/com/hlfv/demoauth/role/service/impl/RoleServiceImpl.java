package com.hlfv.demoauth.role.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hlfv.demoauth.role.entity.Role;
import com.hlfv.demoauth.role.mapper.RoleMapper;
import com.hlfv.demoauth.role.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author hflv
 * @since 2022-04-26
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}

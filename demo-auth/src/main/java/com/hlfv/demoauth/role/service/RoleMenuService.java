package com.hlfv.demoauth.role.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hlfv.demoauth.menu.entity.Menu;
import com.hlfv.demoauth.role.entity.RoleMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色菜单关联 服务类
 * </p>
 *
 * @author hflv
 * @since 2022-04-26
 */
public interface RoleMenuService extends IService<RoleMenu> {

    List<Menu> getMenuByRoleIds(@Param("roleIds") List<Long> roleIds);
}

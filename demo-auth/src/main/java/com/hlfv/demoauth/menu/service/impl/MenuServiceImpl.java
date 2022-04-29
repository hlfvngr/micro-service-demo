package com.hlfv.demoauth.menu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hlfv.demoauth.menu.entity.Menu;
import com.hlfv.demoauth.menu.mapper.MenuMapper;
import com.hlfv.demoauth.menu.service.MenuService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统菜单 服务实现类
 * </p>
 *
 * @author hflv
 * @since 2022-04-26
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

}

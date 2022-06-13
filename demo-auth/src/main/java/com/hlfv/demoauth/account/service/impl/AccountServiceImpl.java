package com.hlfv.demoauth.account.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hlfv.demoauth.account.entity.Account;
import com.hlfv.demoauth.account.mapper.AccountMapper;
import com.hlfv.demoauth.account.service.AccountService;
import com.hlfv.demoauth.menu.entity.Menu;
import com.hlfv.demoauth.role.entity.Role;
import com.hlfv.demoauth.role.service.RoleMenuService;
import com.hlfv.democommon.exception.DemoException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    /*@Resource
    private AccountMapper accountMapper;
    @Resource
    private AccountRoleService accountRoleService;
    @Resource
    private RoleMenuService roleMenuService;*/

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if  ("admin".equals(username)) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            List<GrantedAuthority> authorityList = AuthorityUtils.createAuthorityList("admin", "sale");
            return new User("admin", passwordEncoder.encode("123456"), authorityList);
        }
        throw new UsernameNotFoundException("该用户不存在！");
    }

    /*@Override
    public UserDetails loadUserByUsername(String accountName) throws UsernameNotFoundException {
        Account account = accountMapper.selectByAccountName(accountName);
        if (account == null) {
            throw new DemoException("该用户不存在！");
        }
        Set<Role> roles = accountRoleService.getRoleByAccount(account.getAccountId());

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        List<Menu> menus = null;
        if (!CollectionUtils.isEmpty(roles)) {
            List<Long> roleIds = roles.stream()
                    .map(Role::getRoleId)
                    .collect(Collectors.toList());

            for (Role role : roles) {
                String name = role.getName();
                if (name != null && !"".equals(name)) {
                    grantedAuthorities.add(new SimpleGrantedAuthority( "ROLE_" + name.toUpperCase()));
                }
            }
            menus = roleMenuService.getMenuByRoleIds(roleIds);
        }

        if (!CollectionUtils.isEmpty(menus)) {
            for (Menu menu : menus) {
                String permission = menu.getPermission();
                if (permission != null && !"".equals(permission)) {
                    grantedAuthorities.add(new SimpleGrantedAuthority( permission));
                }
            }
        }

        return new User(account.getAccountName(), account.getPassword(), grantedAuthorities);
    }*/
}

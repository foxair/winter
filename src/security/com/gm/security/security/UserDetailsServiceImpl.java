package com.gm.security.security;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.gm.security.model.RoleInfo;
import com.gm.security.model.UserInfo;
import com.gm.security.service.UserInfoManager;

/**
 * 实现SpringSecurity的UserDetailsService接口,实现获取用户Detail信息的回调函数.
 * 
 * 扩展SpringSecurity的User类加入loginTime信息.
 */
@Transactional(readOnly = true)
public class UserDetailsServiceImpl implements UserDetailsService {

	private UserInfoManager userInfoManager;

	/**
	 * 获取用户Detail信息的回调函数.
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {

		UserInfo user = userInfoManager.getById(Long.valueOf(username));
		// TODO
		List<RoleInfo> roles = null;// (Role)roleManager.getRolesByAccount(username);
		if (user == null) {
			throw new UsernameNotFoundException("用户" + username + " 不存在");
		}

		Set<GrantedAuthority> grantedAuths = obtainGrantedAuthorities(user, roles);

		// showcase的User类中无以下属性,暂时全部设为true.
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		OperatorDetails userDetails = new OperatorDetails(user.getLoginAccount(), user.getLoginPwd(), enabled,
				accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuths);
		// 加入登录时间信息和用户角色
		userDetails.setLoginTime(new Date());
		userDetails.setRoleList(roles);
		return userDetails;
	}

	/**
	 * 获得用户所有角色的权限.
	 */
	private Set<GrantedAuthority> obtainGrantedAuthorities(UserInfo user, List<RoleInfo> roles) {
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		for (RoleInfo role : roles) {
			authSet.add(new GrantedAuthorityImpl("ROLE_" + role.getRoleName()));
		}
		return authSet;
	}

	@Resource
	public void setUserManager(UserInfoManager userInfoManager) {
		this.userInfoManager = userInfoManager;
	}

}

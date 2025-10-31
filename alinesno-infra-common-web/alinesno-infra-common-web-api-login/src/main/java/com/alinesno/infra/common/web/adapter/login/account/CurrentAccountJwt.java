package com.alinesno.infra.common.web.adapter.login.account;

import cn.dev33.satoken.stp.StpUtil;
import com.alinesno.infra.common.web.adapter.base.dto.LoginUserDto;
import com.alinesno.infra.common.web.adapter.base.dto.ManagerAccountDto;
import lombok.extern.slf4j.Slf4j;

/**
 * 获取当前用户基本信息
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Slf4j
public class CurrentAccountJwt {

	private static final String currentAccountDto = "CURRENT_ACCOUNT_DTO" ;

	/**
	 * 获取当前登陆用户
	 * 
	 * @return
	 */
	public static LoginUserDto getUserVo()  {
		LoginUserDto loginUser = null;
		return loginUser;
	}

	/**
	 * 获取当前登陆的UserVo
	 * 
	 * @return
	 */
	public static ManagerAccountDto get()  {
        return (ManagerAccountDto) StpUtil.getSession().get(currentAccountDto);
	}
	
	/**
	 * 获取当前登陆的UserVo
	 * 
	 * @return
	 */
	public static CurrentAccountBean getAccount()  {
		CurrentAccountBean e = new CurrentAccountBean();
		return e;
	}

	/**
	 * 判断是否登陆
	 *
	 * @return
	 */
	public static boolean isLogin()  {
		return StpUtil.isLogin() ;
	}

	/**
	 * 获取当前登陆的用户id
	 * 
	 * @return
	 */
	public static long getUserId()  {
		return StpUtil.getLoginIdAsLong();
	}

}

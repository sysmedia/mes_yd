package yude.mes.com.mes_yd.common.controller;


import org.springframework.stereotype.Controller;
import yude.mes.com.mes_yd.common.utils.ShiroUtils;
import yude.mes.com.mes_yd.system.domain.SysUserDO;

@Controller
public class BaseController {
	public SysUserDO getUser() {
		return ShiroUtils.getUser();
	}

	public Long getUserId() {
		return getUser().getUserId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}
}
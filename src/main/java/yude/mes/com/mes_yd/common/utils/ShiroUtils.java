package yude.mes.com.mes_yd.common.utils;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import yude.mes.com.mes_yd.system.domain.SysUserDO;

public class ShiroUtils {
	public static Subject getSubjct() {
		return SecurityUtils.getSubject();
	}
	public static SysUserDO getUser() {
		return (SysUserDO)getSubjct().getPrincipal();
	}
	public static Long getUserId() {
		return getUser().getUserId();
	}
	public static void logout() {
		getSubjct().logout();
	}
}

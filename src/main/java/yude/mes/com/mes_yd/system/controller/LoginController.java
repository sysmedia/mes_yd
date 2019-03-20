package yude.mes.com.mes_yd.system.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yude.mes.com.mes_yd.common.annotation.Log;
import yude.mes.com.mes_yd.common.controller.BaseController;
import yude.mes.com.mes_yd.common.domain.Tree;
import yude.mes.com.mes_yd.common.utils.MD5Utils;
import yude.mes.com.mes_yd.common.utils.R;
import yude.mes.com.mes_yd.common.utils.ShiroUtils;
import yude.mes.com.mes_yd.system.dao.UserMapper;
import yude.mes.com.mes_yd.system.domain.MenuDO;
import yude.mes.com.mes_yd.system.service.MenuService;

import java.util.List;

@Controller
public class LoginController extends BaseController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	MenuService menuService;

	@Log("sent main UI")
	@GetMapping({ "/", "", "/index" })
	String Index(Model model) {
		// Tree<MenuDO> menuTree = menuService.getSysMenuTree(getUserId());
		List<Tree<MenuDO>> menus = menuService.listMenuTree(getUserId());
		model.addAttribute("menus", menus);
		model.addAttribute("name", getUser().getName());
		logger.info(getUser().getName());
		return "index";
	}


	@GetMapping("/login")
	String login() {

		return "login";
	}

	@PostMapping("/login_bak")
	String doLogin(String username, String password) {
		password = MD5Utils.encrypt(username, password);
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			return "redirect:/index";
		} catch (AuthenticationException e) {
			System.out.println("登录失败信息------" + e.getMessage());
			return "redirect:/login";
		}
	}

	@Log("Login request")
	@PostMapping("/login")
	@ResponseBody
	R ajaxLogin(String username, String password) {
		//password="123456";
		//username="admin";
		password = MD5Utils.encrypt(username, password);

		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			return R.ok();
		} catch (AuthenticationException e) {
			return R.error("用户或密码错误");
		}
	}

	@GetMapping("/logout")
	String logout() {
		ShiroUtils.logout();
		return "redirect:/login";
	}

	@GetMapping("/main")
	String main() {
		return "main";
	}

	@GetMapping("/403")
	String error403() {
		return "403";
	}

}

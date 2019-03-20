package yude.mes.com.mes_yd.system.controller;


import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import yude.mes.com.mes_yd.common.annotation.Log;
import yude.mes.com.mes_yd.common.controller.BaseController;
import yude.mes.com.mes_yd.common.utils.*;
import yude.mes.com.mes_yd.system.domain.RoleDO;
import yude.mes.com.mes_yd.system.domain.SysUserDO;
import yude.mes.com.mes_yd.system.service.RoleService;
import yude.mes.com.mes_yd.system.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RequestMapping("/sys/user")
@Controller
public class UserController extends BaseController {
	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;

	@RequiresPermissions("sys:user:user")
	@GetMapping("")
	String user(Model model) {
		return "sys/user/user";
	}

	@GetMapping("/list")
	@ResponseBody
	PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<SysUserDO> sysUserList = userService.list(query);
		int total = userService.count(query);
		PageUtils pageUtil = new PageUtils(sysUserList, total);
		return pageUtil;
	}

	@RequiresPermissions("sys:user:add")
	@Log("add user action")
	@GetMapping("/add")
	String add(Model model) {
		List<RoleDO> roles = roleService.list();
		model.addAttribute("roles", roles);
		return "sys/user/add";
	}

	@RequiresPermissions("sys:user:edit")
	@Log("edit user action")
	@GetMapping("/edit/{id}")
	String edit(Model model, @PathVariable("id") Long id) {
		SysUserDO userDO = userService.get(id);
		model.addAttribute("user", userDO);
		List<RoleDO> roles = roleService.list(id);
		model.addAttribute("roles", roles);
		return "sys/user/edit";
	}

	@RequiresPermissions("sys:user:add")
	@Log("save user action")
	@PostMapping("/save")
	@ResponseBody
	R save(SysUserDO user) {
		if ("test"==getUsername()) {
			return R.error(1, "演示系统不允许删除,完整体验请部署程序");
		}
		user.setPassword(MD5Utils.encrypt(user.getUsername(), user.getPassword()));
		if (userService.save(user) > 0) {
			return R.ok();
		}
		return R.error();
	}

	@RequiresPermissions("sys:user:edit")
	@Log("update user action")
	@PostMapping("/update")
	@ResponseBody
	R update(SysUserDO user) {
		// return R.error(1, "演示系统不允许修改");
		if (userService.update(user) > 0) {
			return R.ok();
		}
		return R.error();
	}

	@RequiresPermissions("sys:user:remove")
	@Log("delete user action")
	@PostMapping("/remove")
	@ResponseBody
	R remove(Long id) {
		// return R.error("演示系统不允许删除");
		if (userService.remove(id) > 0) {
			return R.ok();
		}
		return R.error();
	}

	@RequiresPermissions("sys:user:batchRemove")
	@Log("deleteMore user action")
	@PostMapping("/batchRemove")
	@ResponseBody
	R batchRemove(@RequestParam("ids[]") Long[] userIds) {
		// return R.error("演示系统不允许删除");
		List<Long> Ids = Arrays.asList(userIds);
		int r = userService.batchremove(Ids);
		System.out.println(r);
		if (r > 0) {
			return R.ok();
		}
		return R.error();
	}

	@PostMapping("/exit")
	@ResponseBody
	boolean exit(@RequestParam Map<String, Object> params) {
		// Query query = new Query(params);
		return !userService.exit(params);// 存在，不通过，false
	}

	@RequiresPermissions("sys:user:resetPwd")
	@Log("update  user  password UI")
	@GetMapping("/resetPwd/{id}")
	String resetPwd(@PathVariable("id") Long userId, Model model) {

		SysUserDO userDO = new SysUserDO();
		userDO.setUserId(userId);
		model.addAttribute("user", userDO);
		return "sys/user/reset_pwd";
	}

	@Log("update  user  password action")
	@PostMapping("/resetPwd")
	@ResponseBody
	R resetPwd(SysUserDO user) {
		if (1L == user.getUserId()) {
			return R.error("演示系统不允许修改管理员密码");
		}
		user.setPassword(MD5Utils.encrypt(userService.get(user.getUserId()).getUsername(), user.getPassword()));
		if (userService.resetPwd(user) > 0) {
			return R.ok();
		}
		return R.error();
	}


    @GetMapping("/userExport")
    public void export(HttpServletResponse response, HttpServletRequest request) {
		HashMap<String,Object> hashMap=new HashMap<>();
		hashMap.put("offset", "1");
		hashMap.put("page", (1 / 1 + 1)+"");
		hashMap.put("limit", "200000");
		Query query = new Query(hashMap);
		List<SysUserDO> list = userService.list(query);
        ExportExcel<SysUserDO> ee= new ExportExcel<SysUserDO>();
        String[] headers = { "userId", "username", "password", "email",  "status"};
        String fileName = UUID.randomUUID()+"excel";
        ee.exportExcel(headers,list,fileName,response);

    }

}

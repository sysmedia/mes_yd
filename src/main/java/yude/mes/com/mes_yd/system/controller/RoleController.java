package yude.mes.com.mes_yd.system.controller;


import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import yude.mes.com.mes_yd.common.annotation.Log;
import yude.mes.com.mes_yd.common.controller.BaseController;
import yude.mes.com.mes_yd.common.utils.R;
import yude.mes.com.mes_yd.system.domain.RoleDO;
import yude.mes.com.mes_yd.system.service.RoleService;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/sys/role")
@Controller
public class RoleController extends BaseController {
	String prefix = "sys/role";
	@Autowired
	RoleService roleService;

	@RequiresPermissions("sys:role:role")
	@GetMapping()
	String role() {
		return prefix + "/role";
	}

	@RequiresPermissions("sys:role:role")
	@GetMapping("/list")
	@ResponseBody()
	List<RoleDO> list() {
		List<RoleDO> roles = roleService.list();
		return roles;
	}

	@Log("add role action")
	@RequiresPermissions("sys:role:add")
	@GetMapping("/add")
	String add() {
		return prefix + "/add";
	}

	@Log("edit role action")
	@RequiresPermissions("sys:role:edit")
	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Long id, Model model) {
		RoleDO roleDO = roleService.get(id);
		model.addAttribute("role", roleDO);
		return prefix + "/edit";
	}

	@Log("save role action")
	@RequiresPermissions("sys:role:add")
	@PostMapping("/save")
	@ResponseBody()
	R save(RoleDO role) {
		if ("test"==getUsername()) {
			return R.error(1, "演示系统不允许删除,完整体验请部署程序");
		}
		if (roleService.save(role) > 0) {
			return R.ok();
		} else {
			return R.error(1, "保存失败");
		}
	}

	@Log("update role action")
	@RequiresPermissions("sys:role:edit")
	@PostMapping("/update")
	@ResponseBody()
	R update(RoleDO role) {
		if ("test"==getUsername()) {
			return R.error(1, "演示系统不允许删除,完整体验请部署程序");
		}
		if (roleService.update(role) > 0) {
			return R.ok();
		} else {
			return R.error(1, "保存失败");
		}
	}

	@Log("deelet role action")
	@RequiresPermissions("sys:role:remove")
	@PostMapping("/remove")
	@ResponseBody()
	R save(Long id) {
		if ("test"==getUsername()) {
			return R.error(1, "演示系统不允许删除,完整体验请部署程序");
		}
		if (roleService.remove(id) > 0) {
			return R.ok();
		} else {
			return R.error(1, "删除失败");
		}
	}


	@RequiresPermissions("sys:role:batchRemove")
	@Log("deleteMore role action")
	@PostMapping("/batchRemove")
	@ResponseBody
	R batchRemove(@RequestParam("ids[]") Long[] userIds) {
		// return R.error("演示系统不允许删除");
		List<Long> Ids = Arrays.asList(userIds);
		int r = roleService.batchremove(Ids);
		System.out.println(r);
		if (r > 0) {
			return R.ok();
		}
		return R.error();
	}

}

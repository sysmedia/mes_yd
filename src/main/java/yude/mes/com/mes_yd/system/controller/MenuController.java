package yude.mes.com.mes_yd.system.controller;


import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import yude.mes.com.mes_yd.common.annotation.Log;
import yude.mes.com.mes_yd.common.controller.BaseController;
import yude.mes.com.mes_yd.common.domain.Tree;
import yude.mes.com.mes_yd.common.utils.R;
import yude.mes.com.mes_yd.system.domain.MenuDO;
import yude.mes.com.mes_yd.system.service.MenuService;

import java.util.List;

@RequestMapping("/sys/menu")
@Controller
public class MenuController extends BaseController {
	String prefix = "sys/menu";
	@Autowired
	MenuService menuService;

	@RequiresPermissions("sys:menu:menu")
	@GetMapping()
	String menu(Model model) {
		return "sys/menu/menu";
	}

	@RequiresPermissions("sys:menu:menu")
	@RequestMapping("/list")
	@ResponseBody
	List<MenuDO> list() {
		List<MenuDO> menus = menuService.list();
		return menus;
	}

	@Log("add menu action")
	@RequiresPermissions("sys:menu:add")
	@GetMapping("/add/{pId}")
	String add(Model model, @PathVariable("pId") Long pId) {
		model.addAttribute("pId", pId);
		if (pId == 0) {
			model.addAttribute("pName", "根目录");
		} else {
			model.addAttribute("pName", menuService.get(pId).getName());
		}
		return "sys/menu/add";
	}

	@Log("edit menu action")
	@RequiresPermissions("sys:menu:edit")
	@GetMapping("/edit/{id}")
	String edit(Model model, @PathVariable("id") Long id) {
		model.addAttribute("menu", menuService.get(id));
		return "sys/menu/edit";
	}

	@Log("delete menu action")
	@RequiresPermissions("sys:menu:remove")
	@PostMapping("/remove")
	@ResponseBody
	R remove(Long id) {
		if ("test"==getUsername()) {
			return R.error(1, "演示系统不允许删除,完整体验请部署程序");
		}
		
		if (menuService.remove(id) > 0) {
			return R.ok();
		} else {
			return R.error(1, "删除失败");
		}
	}

	@Log("sava menu action")
	@RequiresPermissions("sys:menu:add")
	@PostMapping("/save")
	@ResponseBody
	R save(MenuDO menu) {
		if ("test"==getUsername()) {
			return R.error(1, "演示系统不允许删除,完整体验请部署程序");
		}
		
		if (menuService.save(menu) > 0) {
			return R.ok();
		} else {
			return R.error(1, "保存失败");
		}
	}

	@Log("update menu action")
	@RequiresPermissions("sys:menu:edit")
	@PostMapping("/update")
	@ResponseBody
	R update(MenuDO menu) {
		if ("test"==getUsername()) {
			return R.error(1, "演示系统不允许删除,完整体验请部署程序");
		}
		if (menuService.update(menu) > 0) {
			return R.ok();
		} else {
			return R.error(1, "更新失败");
		}
	}

	@GetMapping("/tree")
	@ResponseBody
	Tree<MenuDO> tree() {
		Tree<MenuDO> tree = new Tree<MenuDO>();
		tree = menuService.getTree();
		return tree;
	}

	@GetMapping("/tree/{roleId}")
	@ResponseBody
	Tree<MenuDO> tree(@PathVariable("roleId") Long roleId) {
		Tree<MenuDO> tree = new Tree<MenuDO>();
		tree = menuService.getTree(roleId);
		return tree;
	}
}

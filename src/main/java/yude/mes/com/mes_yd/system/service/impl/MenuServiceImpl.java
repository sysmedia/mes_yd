package yude.mes.com.mes_yd.system.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import yude.mes.com.mes_yd.common.domain.Tree;
import yude.mes.com.mes_yd.common.utils.BuildTree;
import yude.mes.com.mes_yd.system.dao.MenuMapper;
import yude.mes.com.mes_yd.system.dao.RoleMenuMapper;
import yude.mes.com.mes_yd.system.domain.MenuDO;
import yude.mes.com.mes_yd.system.service.MenuService;

import java.util.*;

@Service
public class MenuServiceImpl implements MenuService {
	@Autowired
	MenuMapper menuMapper;
	@Autowired
	RoleMenuMapper roleMenuMapper;

	/**
	 * @param 用户ID
	 * @return 树形菜单
	 */
	@Cacheable
	@Override
	public Tree<MenuDO> getSysMenuTree(Long id) {
		List<Tree<MenuDO>> trees = new ArrayList<Tree<MenuDO>>();
		List<MenuDO> menuDOs = menuMapper.listMenuByUserId(id);
		for (MenuDO sysMenuDO : menuDOs) {
			Tree<MenuDO> tree = new Tree<MenuDO>();
			tree.setId(sysMenuDO.getMenuId().toString());
			tree.setParentId(sysMenuDO.getParentId().toString());
			tree.setText(sysMenuDO.getName());
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("url", sysMenuDO.getUrl());
			attributes.put("icon", sysMenuDO.getIcon());
			tree.setAttributes(attributes);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<MenuDO> t = BuildTree.build(trees);
		return t;
	}

	@Override
	public List<MenuDO> list() {
		List<MenuDO> menus = menuMapper.listMenu();
		return menus;
	}

	@Override
	public int remove(Long id) {
		int result = menuMapper.remove(id);
		return result;
	}

	@Override
	public int save(MenuDO menu) {
		int r = menuMapper.save(menu);
		return r;
	}

	@Override
	public int update(MenuDO menu) {
		int r = menuMapper.update(menu);
		return r;
	}

	@Override
	public MenuDO get(Long id) {
		MenuDO menuDO = menuMapper.getMenu(id);
		return menuDO;
	}

	@Override
	public Tree<MenuDO> getTree() {
		List<Tree<MenuDO>> trees = new ArrayList<Tree<MenuDO>>();
		List<MenuDO> menuDOs = menuMapper.listMenu();
		for (MenuDO sysMenuDO : menuDOs) {
			Tree<MenuDO> tree = new Tree<MenuDO>();
			tree.setId(sysMenuDO.getMenuId().toString());
			tree.setParentId(sysMenuDO.getParentId().toString());
			tree.setText(sysMenuDO.getName());
			// Map<String, Object> attribute = new HashMap<>();
			// attribute.put("url", sysMenuDO.getUrl());
			// attribute.put("icon", sysMenuDO.getIcon());
			// List<Map<String, Object>> attributes = new ArrayList<>();
			// attributes.add(attribute);
			// tree.setAttributes(attributes);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<MenuDO> t = BuildTree.build(trees);
		return t;
	}

	@Override
	public Tree<MenuDO> getTree(Long id) {
		// 根据roleId查询权限
		List<Long> menuIds = roleMenuMapper.listMenuIdByRoleId(id);
		List<Tree<MenuDO>> trees = new ArrayList<Tree<MenuDO>>();
		List<MenuDO> menuDOs = menuMapper.listMenu();
		for (MenuDO sysMenuDO : menuDOs) {
			Tree<MenuDO> tree = new Tree<MenuDO>();
			tree.setId(sysMenuDO.getMenuId().toString());
			tree.setParentId(sysMenuDO.getParentId().toString());
			tree.setText(sysMenuDO.getName());
			Map<String, Object> state = new HashMap<>();
			Long menuId = sysMenuDO.getMenuId();
			if (menuIds.contains(menuId)) {
				state.put("selected", true);
			} else {
				state.put("selected", false);
			}
			tree.setState(state);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<MenuDO> t = BuildTree.build(trees);
		return t;
	}

	@Override
	public Set<String> listPerms(Long userId) {
		List<String> perms = menuMapper.listUserPerms(userId);
		Set<String> permsSet = new HashSet<>();
		for (String perm : perms) {
			if (StringUtils.isNotBlank(perm)) {
				permsSet.addAll(Arrays.asList(perm.trim().split(",")));
			}
		}
		return permsSet;
	}

	@Override
	public List<Tree<MenuDO>> listMenuTree(Long id) {
		List<Tree<MenuDO>> trees = new ArrayList<Tree<MenuDO>>();
		List<MenuDO> menuDOs = menuMapper.listMenuByUserId(id);
		for (MenuDO sysMenuDO : menuDOs) {
			Tree<MenuDO> tree = new Tree<MenuDO>();
			tree.setId(sysMenuDO.getMenuId().toString());
			tree.setParentId(sysMenuDO.getParentId().toString());
			tree.setText(sysMenuDO.getName());
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("url", sysMenuDO.getUrl());
			attributes.put("icon", sysMenuDO.getIcon());
			tree.setAttributes(attributes);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		List<Tree<MenuDO>> list = BuildTree.buildList(trees,"0");
		return list;
	}

}

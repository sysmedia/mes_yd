package yude.mes.com.mes_yd.system.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yude.mes.com.mes_yd.system.dao.RoleMapper;
import yude.mes.com.mes_yd.system.dao.RoleMenuMapper;
import yude.mes.com.mes_yd.system.dao.UserMapper;
import yude.mes.com.mes_yd.system.dao.UserRoleMapper;
import yude.mes.com.mes_yd.system.domain.RoleDO;
import yude.mes.com.mes_yd.system.domain.RoleMenuDO;
import yude.mes.com.mes_yd.system.service.RoleService;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleMapper roleMapper;
	@Autowired
	RoleMenuMapper roleMenuMapper;
	@Autowired
	UserMapper userMapper;
	@Autowired
	UserRoleMapper userRoleMapper;

	@Override
	public List<RoleDO> list() {
		List<RoleDO> roles = roleMapper.listRole();
		return roles;
	}

	@Override
	public List<RoleDO> list(Long userId) {
		List<Long> rolesIds = userRoleMapper.listRoleId(userId);
		List<RoleDO> roles = roleMapper.listRole();
		for (RoleDO roleDO : roles) {
			roleDO.setRoleSign("false");
			for (Long roleId : rolesIds) {
				if (roleDO.getRoleId() == roleId) {
					roleDO.setRoleSign("true");
					break;
				}
			}
		}
		return roles;
	}
	@Transactional
	@Override
	public int batchremove(List<Long> ids) {
		int count = roleMapper.batchRemove(ids);
		roleMenuMapper.batchRemove(ids);
		return count;
	}

	@Transactional
	@Override
	public int save(RoleDO role) {
		int count = roleMapper.save(role);
		List<Long> menuIds = role.getMenuIds();
		Long roleId = role.getRoleId();
		List<RoleMenuDO> rms = new ArrayList<>();
		for (Long menuId : menuIds) {
			RoleMenuDO rmDo = new RoleMenuDO();
			rmDo.setRoleId(roleId);
			rmDo.setMenuId(menuId);
			rms.add(rmDo);
		}
		roleMenuMapper.removeByRoleId(roleId);
		if (rms.size() > 0) {
			roleMenuMapper.batchSave(rms);
		}
		return count;
	}

	@Transactional
	@Override
	public int remove(Long id) {
		int count = roleMapper.remove(id);
		roleMenuMapper.remove(id);
		return count;
	}

	@Override
	public RoleDO get(Long id) {
		RoleDO roleDO = roleMapper.get(id);
		return roleDO;
	}

	@Override
	public int update(RoleDO role) {
		int r = roleMapper.update(role);
		List<Long> menuIds = role.getMenuIds();
		Long roleId = role.getRoleId();
		roleMenuMapper.removeByRoleId(roleId);
		List<RoleMenuDO> rms = new ArrayList<>();
		for (Long menuId : menuIds) {
			RoleMenuDO rmDo = new RoleMenuDO();
			rmDo.setRoleId(roleId);
			rmDo.setMenuId(menuId);
			rms.add(rmDo);
		}
		roleMenuMapper.removeByRoleId(roleId);
		if (rms.size() > 0) {
			roleMenuMapper.batchSave(rms);
		}
		return r;
	}

}

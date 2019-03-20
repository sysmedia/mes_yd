package yude.mes.com.mes_yd.system.service;


import org.springframework.stereotype.Service;
import yude.mes.com.mes_yd.common.domain.Tree;
import yude.mes.com.mes_yd.system.domain.MenuDO;

import java.util.List;
import java.util.Set;

/**
 * @author wangpw
 * @creat 2018-09-10
 * @description 系统菜单业务代码
 * 
 */
@Service
public interface MenuService {
	Tree<MenuDO> getSysMenuTree(Long id);
	List<Tree<MenuDO>> listMenuTree(Long id);
	Tree<MenuDO> getTree();
	Tree<MenuDO> getTree(Long id);
	List<MenuDO> list();
	int remove(Long id);
	int save(MenuDO menu);
	int update(MenuDO menu);
	MenuDO get(Long id);
	Set<String> listPerms(Long userId);
}

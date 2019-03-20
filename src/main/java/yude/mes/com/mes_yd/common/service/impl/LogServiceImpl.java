package yude.mes.com.mes_yd.common.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yude.mes.com.mes_yd.common.dao.LogMapper;
import yude.mes.com.mes_yd.common.domain.PageDO;
import yude.mes.com.mes_yd.common.domain.SysLogDO;
import yude.mes.com.mes_yd.common.service.LogService;
import yude.mes.com.mes_yd.common.utils.Query;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
	@Autowired
	LogMapper logMapper;

	@Override
	public PageDO<SysLogDO> queryList(Query query) {
		List<SysLogDO> logs = logMapper.list(query);
	int total = logMapper.count();
	PageDO<SysLogDO> page = new PageDO<>();
		page.setTotal(total);
		page.setRows(logs);
		return page;
}

	@Override
	public int remove(Long id) {
		int count = logMapper.remove(id);
		return count;
	}

	@Override
	public int batchRemove(List<Long> ids) {
		int count = logMapper.batchRemove(ids);
		return count;
	}
}

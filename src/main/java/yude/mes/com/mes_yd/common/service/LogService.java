package yude.mes.com.mes_yd.common.service;


import org.springframework.stereotype.Service;
import yude.mes.com.mes_yd.common.domain.PageDO;
import yude.mes.com.mes_yd.common.domain.SysLogDO;
import yude.mes.com.mes_yd.common.utils.Query;

import java.util.List;

@Service
public interface LogService {
	PageDO<SysLogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(List<Long> ids);
}

package yude.mes.com.mes_yd.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yude.mes.com.mes_yd.common.domain.PageDO;
import yude.mes.com.mes_yd.common.domain.SysLogDO;
import yude.mes.com.mes_yd.common.service.LogService;
import yude.mes.com.mes_yd.common.utils.Query;
import yude.mes.com.mes_yd.common.utils.R;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RequestMapping("/common/log")
@Controller
public class LogController {
	@Autowired
	LogService logService;
	String prefix = "common/log";

	@GetMapping()
	String log() {
		return prefix + "/log";
	}

	@ResponseBody
	@GetMapping("/list")
	PageDO<SysLogDO> list(@RequestParam Map<String, Object> params) {
		Query query = new Query(params);
		PageDO<SysLogDO> page = logService.queryList(query);
		return page;
	}
	
	@ResponseBody
	@PostMapping("/remove")
	R remove(Long id) {
		if (logService.remove(id)>0) {
			return R.ok();
		}
		return R.error();
	}

	@ResponseBody
	@PostMapping("/batchRemove")
	R batchRemove(@RequestParam("ids[]") Long[] idsArray) {
		List<Long> ids = Arrays.asList(idsArray);
		int r = logService.batchRemove(ids);
		if (r > 0) {
			return R.ok();
		}
		return R.error();
	}
}

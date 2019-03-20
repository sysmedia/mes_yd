/**
 * 
 */
package yude.mes.com.mes_yd.common.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author wangpw
 * @creat 2018-09-10
 * 
 */
@Service
public interface GeneratorService {
	List<Map<String, Object>> list();

	byte[] generatorCode(String[] tableNames);
}

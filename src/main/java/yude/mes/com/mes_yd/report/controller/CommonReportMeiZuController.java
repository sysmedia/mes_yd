package yude.mes.com.mes_yd.report.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import yude.mes.com.mes_yd.common.utils.PageUtils;
import yude.mes.com.mes_yd.common.utils.Query;
import yude.mes.com.mes_yd.report.dao.CommonReportMeiZu;
import yude.mes.com.mes_yd.report.domain.CommonReportMeiZuVO;
import yude.mes.com.mes_yd.system.domain.MenuDO;
import yude.mes.com.mes_yd.system.domain.SysUserDO;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author wangpw
 * @create 2018-09-2018/9/17 0017-下午 2:26
 */
@RequestMapping("/report/common")
@Controller
public class CommonReportMeiZuController {

   @Autowired
   private CommonReportMeiZu commonReportMeiZu;

    @Resource(name="redisTemplate")
    private ValueOperations<Object,Object> valOps;

    @RequiresPermissions("report:common:common")
    @GetMapping("")
    String user(Model model) {
        return "report/common/commonreportmeizu";
    }

    @GetMapping("/list")
    @ResponseBody
    PageUtils list(@RequestParam Map<String, Object> params) {

        Query query = new Query(params);

        List<CommonReportMeiZuVO> redisCommonReportMeiZuVOList=null;

       // if(!StringUtils.isEmpty(valOps.get(query.get("palletCode")))){

          //   redisCommonReportMeiZuVOList =(List<CommonReportMeiZuVO>) valOps.get(query.get("palletCode"));

      //  }

      //else{
            redisCommonReportMeiZuVOList = commonReportMeiZu.selectByPalletCode(query);

        //    valOps.set(query.get("palletCode"),redisCommonReportMeiZuVOList);
      //  }

        int count=0;



        if(!StringUtils.isEmpty(valOps.get(query.get("palletCode")+"count"))){

            count =(Integer) valOps.get(query.get("palletCode")+"count");

        } else{

           count=commonReportMeiZu.getCommonReportMeiZuVOCount(query);

           valOps.set(query.get("palletCode")+"count",count);
        }

        PageUtils pageUtil = new PageUtils(redisCommonReportMeiZuVOList,count);

        return pageUtil;
    }


}

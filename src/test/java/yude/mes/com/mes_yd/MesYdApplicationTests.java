package yude.mes.com.mes_yd;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import yude.mes.com.mes_yd.ceshi.beans.User;
import yude.mes.com.mes_yd.ceshi.dao.UserMapper1;
import yude.mes.com.mes_yd.report.dao.CommonReportMeiZu;
import yude.mes.com.mes_yd.report.domain.CommonReportMeiZuVO;
import yude.mes.com.mes_yd.system.dao.MenuMapper;
import yude.mes.com.mes_yd.system.domain.MenuDO;
import yude.mes.com.mes_yd.system.domain.SysUserDO;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@RunWith(SpringRunner.class)
@EnableCaching
@ActiveProfiles("dev")
@SpringBootTest
public class MesYdApplicationTests {
//    @Autowired
//    EmployeeMapper employeeMapper;
//
//    @Autowired
//    DepartmentMapper departmentMapper;
//    @Autowired
//    UserMapper userMapper;
    @Autowired
    MenuMapper menuMapper;

    @Qualifier("toolsCacheManager")
    @Autowired
    RedisCacheManager toolsCacheManager;

//    @Autowired
//    private RedisTemplate<Object, Object> redisTemplate;

//    @Resource(name="redisTemplate")
//    private ValueOperations<Object,Object> valOps;
    @Qualifier("toolsRedisTemplate")
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Resource(name="redisTemplate")
    private ValueOperations<Object,Object> valOps;

  //  @Cacheable(cacheNames = "dept",cacheManager = "toolsCacheManager")

    @Test
    public void contextLoads() {



        
        //insert into `sys_user` (`user_id`, `username`, `password`, `email`, `mobile`, `status`, `user_id_create`, `gmt_create`, `gmt_modified`, `name`) values('1','admin','d0af8fa1272ef5a152d9e27763eea293','960196249@qq.com','18146686080','1','1','2018-09-08 12:08:43','2018-09-08 12:08:47','超级管理员');
        //insert into `sys_user` (`user_id`, `username`, `password`, `email`, `mobile`, `status`, `user_id_create`, `gmt_create`, `gmt_modified`, `name`) values('2','wpw','81de42dbf6e6616d07ed44afb8f39b37','960196249@qq.com','18146686080','1','1','2018-09-08 12:04:23','2018-09-08 12:04:27','超级管理员');




//        List<MenuDO> menuDOS = menuMapper.listMenu();
//        valOps.set("menuDOS",menuDOS);
//        Cache dept = toolsCacheManager.getCache("menuDOS");
//        Cache.ValueWrapper valueWrapper = dept.get("menuDOS");

//        //System.out.println("查询部门"+id);
//        Department department = departmentMapper.getDeptById(1);
//        valOps.set("dept",department);
//
//        //Department dept = (Department)valOps.get("dept");
//      //  Employee empById = employeeMapper.getEmpById(1);
//        //获取某个缓存
//        Cache dept = toolsCacheManager.getCache("dept");
//        dept.put("dept:1",department);
//        Employee empById = employeeMapper.getEmpById(1);
//        Cache.ValueWrapper valueWrapper = dept.get("dept:1");

    }
    @Autowired
    UserMapper1 userMapper;
    @Autowired
    CommonReportMeiZu commonReportMeiZu;

    @Cacheable(value = {"emp"} ,cacheManager = "toolsCacheManager"/*,keyGenerator = "myKeyGenerator",condition = "#a0>1",unless = "#a0==2"*/)
    @Test
    @Transactional
    public void getEmp(){
        System.out.println("查询号员工");

       // List<CommonReportMeiZuVO> commonReportMeiZuVOS = commonReportMeiZu.selectByPalletCode("20170215F001");

        User admin = userMapper.selectByPrimaryKey("3379");
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(1, 5);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<MenuDO> menuDOS = menuMapper.listMenu();
        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo page = new PageInfo(menuDOS, 5);

        SysUserDO sysUserDO=new SysUserDO();


        for (int i = 0; i < 10; i++) {
                sysUserDO.setUsername("wangpw"+i);
                sysUserDO.setPassword("password"+i);

                sysUserDO.setEmail("wangpw"+i);
                sysUserDO.setMobile("18146686080");
                sysUserDO.setName("wangpw"+i);
                sysUserDO.setStatus(1);
                sysUserDO.setUserIdCreate(1l);
                Date now = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式


                //String hehe = dateFormat.format( now );
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

                Date time=null;
                try {
                    time= sdf.parse(sdf.format(new Date()));

                } catch (ParseException e) {

                    e.printStackTrace();
                }
                sysUserDO.setGmtModified(time);
                sysUserDO.setGmtCreate(time);
              //  userMapper.save(sysUserDO);
            }


    }

}

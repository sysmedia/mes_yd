package yude.mes.com.mes_yd.ceshi.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import yude.mes.com.mes_yd.ceshi.beans.User;
import yude.mes.com.mes_yd.ceshi.beans.UserExample;

public interface UserMapper1 {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String usercode);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String usercode);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
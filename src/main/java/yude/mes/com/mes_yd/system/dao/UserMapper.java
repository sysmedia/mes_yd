package yude.mes.com.mes_yd.system.dao;


import org.apache.ibatis.annotations.*;
import yude.mes.com.mes_yd.system.domain.SysUserDO;

import java.util.List;
import java.util.Map;

public interface UserMapper {

	@Select("select user_id, username, password, email, mobile, status, user_id_create, gmt_create, gmt_modified, name from sys_user where user_id = #{id}")
	SysUserDO get(Long id);
	
//	@Select("<script>" +
//	"select * from sys_user " +
//			"<where>" +
//		  		  "<if test=\"userId != null and userId != ''\">"+ "and user_id = #{userId} " + "</if>" +
//		  		  "<if test=\"username != null and username != ''\">"+ "and username = #{username} " + "</if>" +
//		  		  "<if test=\"password != null and password != ''\">"+ "and password = #{password} " + "</if>" +
//		  		  "<if test=\"email != null and email != ''\">"+ "and email = #{email} " + "</if>" +
//		  		  "<if test=\"mobile != null and mobile != ''\">"+ "and mobile = #{mobile} " + "</if>" +
//		  		  "<if test=\"status != null and status != ''\">"+ "and status = #{status} " + "</if>" +
//		  		  "<if test=\"userIdCreate != null and userIdCreate != ''\">"+ "and user_id_create = #{userIdCreate} " + "</if>" +
//		  		  "<if test=\"gmtCreate != null and gmtCreate != ''\">"+ "and gmt_create = #{gmtCreate} " + "</if>" +
//		  		  "<if test=\"gmtModified != null and gmtModified != ''\">"+ "and gmt_modified = #{gmtModified} " + "</if>" +
//		  		  "<if test=\"name != null and name != ''\">"+ "and name = #{name} " + "</if>" +
//		  			"</where>"+
//			"<if test=\"offset != null and limit != null\">"+
//			"limit #{offset}, #{limit}" +
//			"</if>"+
//			"</script>")
//	List<SysUserDO> list(Map<String, Object> param);


	@Select("<script>" +
	"SELECT * FROM (SELECT @ROWNUM := ifnull(@ROWNUM,0) + 1 AS rowno, t.*\n" +
				"\t\t\tFROM sys_user t" +
			"<where>" +
		  		  "<if test=\"userId != null and userId != ''\">"+ "and user_id = #{userId} " + "</if>" +
		  		  "<if test=\"username != null and username != ''\">"+ "and username = #{username} " + "</if>" +
		  		  "<if test=\"password != null and password != ''\">"+ "and password = #{password} " + "</if>" +
		  		  "<if test=\"email != null and email != ''\">"+ "and email = #{email} " + "</if>" +
		  		  "<if test=\"mobile != null and mobile != ''\">"+ "and mobile = #{mobile} " + "</if>" +
		  		  "<if test=\"status != null and status != ''\">"+ "and status = #{status} " + "</if>" +
		  		  "<if test=\"userIdCreate != null and userIdCreate != ''\">"+ "and user_id_create = #{userIdCreate} " + "</if>" +
		  		  "<if test=\"gmtCreate != null and gmtCreate != ''\">"+ "and gmt_create = #{gmtCreate} " + "</if>" +
		  		  "<if test=\"gmtModified != null and gmtModified != ''\">"+ "and gmt_modified = #{gmtModified} " + "</if>" +
		  		  "<if test=\"name != null and name != ''\">"+ "and name = #{name} " + "</if>" +
		  			"</where>"+
			"<if test=\"offset == null or limit == null\">"+
			") as m "+
			"</if>"+
			"<if test=\"offset != null and limit != null\">"+
			"<if test=\"username != null and username != ''\">"+ " and ROWNUM &lt;=(#{offset}+#{limit}))" + "</if>" +
			"<if test=\"username == null or username == ''\">"+ " where ROWNUM &lt;=(#{offset}+#{limit}))" + "</if>" +
			"table_alias\n" +
			"\tWHERE table_alias.rowno > #{offset}"+
			"</if>"+
			"</script>")
	List<SysUserDO> list(Map<String, Object> param);





	@Select("<script>" +
	"select count(*) from sys_user " +
			"<where>" +
		  		  "<if test=\"userId != null and userId != ''\">"+ "and user_id = #{userId} " + "</if>" +
		  		  "<if test=\"username != null and username != ''\">"+ "and username = #{username} " + "</if>" +
		  		  "<if test=\"password != null and password != ''\">"+ "and password = #{password} " + "</if>" +
		  		  "<if test=\"email != null and email != ''\">"+ "and email = #{email} " + "</if>" +
		  		  "<if test=\"mobile != null and mobile != ''\">"+ "and mobile = #{mobile} " + "</if>" +
		  		  "<if test=\"status != null and status != ''\">"+ "and status = #{status} " + "</if>" +
		  		  "<if test=\"userIdCreate != null and userIdCreate != ''\">"+ "and user_id_create = #{userIdCreate} " + "</if>" +
		  		  "<if test=\"gmtCreate != null and gmtCreate != ''\">"+ "and gmt_create = #{gmtCreate} " + "</if>" +
		  		  "<if test=\"gmtModified != null and gmtModified != ''\">"+ "and gmt_modified = #{gmtModified} " + "</if>" +
		  		  "<if test=\"name != null and name != ''\">"+ "and name = #{name} " + "</if>" +
		  			"</where>"+
			"</script>")
	int count(Map<String, Object> map);
	
//	@Options(useGeneratedKeys = true, keyProperty = "userId")
//@SelectKey(statement="SELECT sys_sys_user.nextval AS id FROM DUAL", keyProperty="obj.id", before=true, resultType=Integer.class)
	@Insert("insert into sys_user (username, password, email, mobile, status, user_id_create, gmt_create, gmt_modified, name)"
	+ "values (#{username}, #{password}, #{email}, #{mobile}, #{status}, #{userIdCreate}, #{gmtCreate}, #{gmtModified}, #{name})")
	int save(SysUserDO obj);



	
	@Update("<script>"+
			"update sys_user " + 
					"<set>" + 
		            "<if test=\"userId != null\">user_id = #{userId}, </if>" + 
                    "<if test=\"username != null\">username = #{username}, </if>" + 
                    "<if test=\"password != null\">password = #{password}, </if>" + 
                    "<if test=\"email != null\">email = #{email}, </if>" + 
                    "<if test=\"mobile != null\">mobile = #{mobile}, </if>" + 
                    "<if test=\"status != null\">status = #{status}, </if>" + 
                    "<if test=\"userIdCreate != null\">user_id_create = #{userIdCreate}, </if>" + 
                    "<if test=\"gmtCreate != null\">gmt_create = #{gmtCreate}, </if>" + 
                    "<if test=\"gmtModified != null\">gmt_modified = #{gmtModified}, </if>" + 
                    "<if test=\"name != null\">name = #{name}, </if>" + 
          					"</set>" + 
					"where user_id = #{userId}"+
			"</script>")
	int update(SysUserDO obj);
	
	@Delete("delete from sys_user where user_id =#{userId}")
	int remove(Long user_id);
	
	@Delete("<script>"+
			"delete from sys_user where user_id in "+
			"<foreach collection=\"list\" index=\"i\" open=\"(\" separator=\",\" close=\")\" item=\"item\"  >#{item}</foreach>"+
			"</script>")
	int batchRemove(List<Long> list);
}

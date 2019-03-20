package yude.mes.com.mes_yd.common.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface GeneratorMapper {
//	@Select("select table_name tableName, engine, table_comment tableComment, create_time createTime from information_schema.tables"
//			+ " where table_schema = (select database())")
//	List<Map<String, Object>> list();
//
//	@Select("select count(*) from information_schema.tables where table_schema = (select database())")
//	int count(Map<String, Object> map);
//
//	@Select("select table_name tableName, engine, table_comment tableComment, create_time createTime from information_schema.tables \r\n"
//			+ "			where table_schema = (select database()) and table_name = #{tableName}")
//	Map<String, String> get(String tableName);
//
//	@Select("select column_name columnName, data_type dataType, column_comment columnComment, column_key columnKey, extra from information_schema.columns\r\n"
//			+ " 			where table_name = #{tableName} and table_schema = (select database()) order by ordinal_position")
//	List<Map<String, String>> listColumns(String tableName);



	@Select("select a.OWNER owner,a.TABLE_NAME tableName,a.STATUS status,a.LAST_ANALYZED createTime from  all_tables a where  a.OWNER=(select  b.OWNER from  all_tables b where b.TABLE_NAME='SYS_LOG') \n")
	List<Map<String, Object>> list();

	@Select("select count(*) from  all_tables a where  a.OWNER=(select  b.OWNER from  all_tables b where b.TABLE_NAME='SYS_LOG') \n")
	int count(Map<String, Object> map);

	@Select("select *  from  (select a.OWNER owner,a.TABLE_NAME tableName,a.STATUS status,a.LAST_ANALYZED createTime from  all_tables a where  a.OWNER=(select  b.OWNER from  all_tables b where b.TABLE_NAME='SYS_LOG') \n)  where  tableName = #{tableName}")
	Map<String, String> get(String tableName);

	@Select(" select A.TABLE_NAME table_name,A.COLUMN_NAME column_name,A.DATA_TYPE dataType,A.LAST_ANALYZED createTime  \n" +
			"from user_tab_columns  A\n" +
			"where a.Table_Name= #{tableName} \n" +
			"order by a.column_name")
	List<Map<String, String>> listColumns(String tableName);
}

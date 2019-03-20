//package yude.mes.com.mes_yd.AutoMbg;
//
//import com.baomidou.mybatisplus.annotation.DbType;
//
//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.config.*;
//import com.baomidou.mybatisplus.generator.config.converts.OracleTypeConvert;
//
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//
//
//
//public class TestMP {
//
//	/**
//	 * 代码生成    示例代码
//	 */
//	public static void main(String[] args) {
//		testGenerator();
//	}
//
//	public static void  testGenerator() {
//		//1. 全局配置
//		GlobalConfig config = new GlobalConfig();
//		config.setActiveRecord(true) // 是否支持AR模式
//				.setAuthor("wpw") // 作者
//				.setOutputDir("E:\\mes_yd\\src\\main\\java\\") // 生成路径E:\mes_yd\src\main\java\yude\mes\com\mes_yd
//				.setFileOverride(true)  // 文件覆盖
//				.setIdType(IdType.INPUT) // 主键策略
//				.setServiceName("%sService")  // 设置生成的service接口的名字的首字母是否为I
//				// IEmployeeService
//				.setBaseResultMap(true)
//				.setBaseColumnList(true);
//
//		//2. 数据源配置
//		DataSourceConfig  dsConfig  = new DataSourceConfig();
////		dsConfig.setDbType(DbType.MYSQL)  // 设置数据库类型
////				.setDriverName("com.mysql.jdbc.Driver")
////				.setUrl("jdbc:mysql://localhost:3306/mp")
////				.setUsername("root")
////				.setPassword("1234");
//
//		dsConfig.setDbType(DbType.ORACLE)  // 设置数据库类型
//				.setDriverName("oracle.jdbc.OracleDriver")
//                 .setUrl("jdbc:oracle:thin:@127.0.0.1:1521:XE")//10.30.10.216   10.0.10.221
//                // .setUrl("jdbc:oracle:thin:@127.0.0.1:1521:XE")//10.30.10.216   10.0.10.221
//				.setUsername("wangpw")
//				.setPassword("123456");
//
//		//3. 策略配置
//		StrategyConfig stConfig = new StrategyConfig();
//		stConfig.setCapitalMode(true); //全局大写命名
//		stConfig.setNaming(NamingStrategy.underline_to_camel);
//		stConfig.setColumnNaming(NamingStrategy.underline_to_camel);
//		//stConfig.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
//		stConfig.setEntityLombokModel(true);
//		//stConfig.setSuperControllerClass("com.baomidou.ant.common.BaseController");
//		stConfig.setInclude();
//		//stConfig.setSuperEntityColumns("id");
//		stConfig.setControllerMappingHyphenStyle(true);
//		//stConfig.setTablePrefix();
//
//		//4. 包名策略配置  yude.mes.com.mes_yd.system
//		PackageConfig pkConfig = new PackageConfig();
//		pkConfig.setParent("yude.mes.com.mes_yd.ceshi")
//				.setMapper("dao")
//				.setService("service")
//				.setController("controller")
//				.setEntity("domain")
//		.setServiceImpl("service.impl")
//		;
//		//.setXml("mapper");
//
//
//		//5. 整合配置
//		AutoGenerator  ag = new AutoGenerator();
//
//		ag.setGlobalConfig(config)
//				.setDataSource(dsConfig)
//				.setStrategy(stConfig)
//				.setPackageInfo(pkConfig);
//
//		//6. 执行
//		ag.execute();
//	}
//
//
//	public static void generateCode() {
//		String packageName = "yude.mes.com.mes_yd.ceshi";
//		generateByTables( packageName, "tblonwip","tblmenu");
//	}
//
//	private static void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {
//		GlobalConfig config = new GlobalConfig();
//		String dbUrl = "jdbc:oracle:thin:@10.0.10.221:1521:mesdb";
//		DataSourceConfig dataSourceConfig = new DataSourceConfig();
//		dataSourceConfig.setDbType(DbType.ORACLE)
//				.setUrl(dbUrl)
//				.setUsername("mes")
//				.setPassword("oracle")
//				.setTypeConvert(new OracleTypeConvert())//自定义数据库类型转换
//				.setDriverName("oracle.jdbc.driver.OracleDriver");
//		StrategyConfig strategyConfig = new StrategyConfig();
//		strategyConfig
//				.setCapitalMode(true)
//				.setEntityLombokModel(false)
//				//.setDbColumnUnderline(false)
//				.setNaming(NamingStrategy.underline_to_camel)
//				.setRestControllerStyle(true)
//				.entityTableFieldAnnotationEnable(true)//是否生成实体时，生成字段注解
//				.setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
//		config.setActiveRecord(false)
//				.setAuthor("wangpw")
//				.setOutputDir("E:\\mes_yd\\src\\main\\java\\")
//				.setFileOverride(true);
//		new AutoGenerator().setGlobalConfig(config)
//				.setDataSource(dataSourceConfig)
//				.setStrategy(strategyConfig)
//				.setPackageInfo(
//						new PackageConfig()
//						        .setParent(packageName)
//								.setMapper("dao")
//								.setService("service")
//								.setController("controller")
//								.setEntity("domain")
//								.setServiceImpl("service.impl")
//				).execute();
//	}
//
//	private static void generateByTables(String packageName, String... tableNames) {
//		generateByTables(true, packageName, tableNames);
//	}
//}

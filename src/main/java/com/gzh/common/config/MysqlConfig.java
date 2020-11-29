//package com.gzh.common.config;
//
//
//import javax.sql.DataSource;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//
//@Configuration
//@MapperScan(basePackages ="com.jdm.hospital.*.dao",sqlSessionFactoryRef = "mysqlSqlSessionFactory")
//public class MysqlConfig {
//	@Primary
//    @Bean(name = "mysqlDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.mysql")
//    public DataSource dataSource(){
//        return DataSourceBuilder.create().build();
//    }
//    @Primary
//    @Bean(name = "mysqlSqlSessionFactory")
//    public SqlSessionFactory sqlSessionFactory(@Qualifier("mysqlDataSource") DataSource dataSource)throws Exception{
//        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//        factoryBean.setDataSource(dataSource);
//        factoryBean.setTypeAliasesPackage("com.jdm.hospital.*.domain");
//        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/**/*Mapper.xml"));
//        return factoryBean.getObject();
//    }
//    //配置事务管理
//    @Primary
//    @Bean(name = "mysqlTransactionManager")
//    public DataSourceTransactionManager transactionManager(@Qualifier("mysqlDataSource") DataSource dataSource){
//        return new DataSourceTransactionManager(dataSource);
//    }
//    @Bean(name = "mysqlSqlSessionTemplate")
//    @Primary
//    public SqlSessionTemplate testSqlSessionTemplate(
//            @Qualifier("mysqlSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception{
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//	
//}
//
//
//
//
//

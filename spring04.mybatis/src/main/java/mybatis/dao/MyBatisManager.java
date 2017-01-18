package mybatis.dao;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;


public final class MyBatisManager {

    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(MyBatisManager.class);
    
    public static SqlSessionFactory sqlMapper = null;
    
    public static synchronized SqlSessionFactory getInstance() {

        if(sqlMapper == null) {

            Reader is = null;
            ApplicationContext appContext = null;
            
            try {
                
                String location = "classpath:Configuration.xml";

                logger.info("step : 01");
                
                appContext = new ClassPathXmlApplicationContext();                 
                Resource resource = appContext.getResource(location);        

                logger.info("step : 02 >> " + resource.toString());
                

                if(resource.exists()) {
                    logger.info("step : 03 >> " + resource.getDescription());
                    is = new BufferedReader(new InputStreamReader(resource.getInputStream()));

                    logger.info("step : 04");
                } 
                else {
                    logger.info("step : 05");
                    
                    location = "Configuration.xml";
                    // jar 인 경우 사용됨
                    // mybatis환경 설정 파일을 읽어오기 위한 스트림 객체 
                    is = Resources.getResourceAsReader(location);

                    logger.info("step : 06 >> " + resource.getFile().getAbsolutePath() );                    
                }
                
                // SqlSessionFactory 객체 얻어오기
                sqlMapper = new SqlSessionFactoryBuilder().build(is);
                
            }catch(Exception e){
                e.printStackTrace();

                logger.error(e.toString());
            }
            finally {
                
                try {
                    is.close();
                } catch (IOException e) { }
                
            }
        }
        
        return sqlMapper; 
    }
}
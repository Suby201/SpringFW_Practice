package myspring.user;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans-mybatis.xml")
public class UserMyBatisTest {
	protected static final Logger Logger = LogManager.getLogger();
	@Autowired
	DataSource datasource;
	
	@Test
	void connection() {
		try {
			Connection connection = datasource.getConnection();
			DatabaseMetaData metaData = connection.getMetaData();
			Logger.debug("DB URL = "+metaData.getURL());
			Logger.debug("DB Username = "+metaData.getUserName());
			Logger.debug("DB Vender Name = "+metaData.getDatabaseProductName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

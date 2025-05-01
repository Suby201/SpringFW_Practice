package myspring.user;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Consumer;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.sql.DataSource;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans-mybatis.xml")
public class UserMyBatisTest {
//	protected static final Logger Logger = LogManager.getLogger();
	@Autowired
	DataSource datasource;

	@Autowired
	SqlSessionFactory sessionFactory;

	@Autowired
	SqlSession sqlSession;

	@Autowired
	UserService userService;
	
	@Test
	void service() {
		userService.insertUser(new UserVO("boot","명숙", "여", "할렘"));
		UserVO user = userService.getUser("boot");
		System.out.println(user);
	}
	
	
	
	@Test @Disabled
	void sqlSession() {
		System.out.println(sessionFactory.getClass().getName());
		UserVO user = sqlSession.selectOne("userNS.selectUserById", "dooly");
		System.out.println(user);

		// Anonynous inner class
		List<UserVO> userList = sqlSession.selectList("userNS.selectUserList");
		for (UserVO userVO : userList) {
			System.out.println(userVO);
		}
		userList.forEach(new Consumer<UserVO>() {
			@Override
			public void accept(UserVO user) {
				System.out.println(user);
			}
		});

		userList.forEach(user1 -> System.out.println(user1));
		userList.forEach(System.out::println);
	}

	@Test
	@Disabled
	void connection() {
		try {
			Connection connection = datasource.getConnection();
			DatabaseMetaData metaData = connection.getMetaData();
//			Logger.debug("DB URL = " + metaData.getURL());
//			Logger.debug("DB Username = " + metaData.getUserName());
//			Logger.debug("DB Vender Name = " + metaData.getDatabaseProductName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package top.mowang.springboot2_project;

import cn.hutool.Hutool;
import cn.hutool.core.util.StrUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootTest
class SpringBoot2ProjectApplicationTests {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	DataSource dataSource;
	@Test
	void contextLoads() {
		Long count = jdbcTemplate.queryForObject("select count(*) from t_user", Long.class);
		System.out.println("查询出"+count+"条数据");
		System.out.println("dataSource.getClass() = " + dataSource.getClass());
	}

}

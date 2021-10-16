package top.mowang.springboot2_project;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.concurrent.TimeUnit;

/**
 * ● @Test :表示方法是测试方法。但是与JUnit4的@Test不同，他的职责非常单一不能声明任何属性，拓展的测试将会由Jupiter提供额外测试
 * ● @ParameterizedTest :表示方法是参数化测试，下方会有详细介绍
 * ● @RepeatedTest :表示方法可重复执行，下方会有详细介绍
 * ● @DisplayName :为测试类或者测试方法设置展示名称
 * ● @BeforeEach :表示在每个单元测试之前执行
 * ● @AfterEach :表示在每个单元测试之后执行
 * ● @BeforeAll :表示在所有单元测试之前执行
 * ● @AfterAll :表示在所有单元测试之后执行
 * ● @Tag :表示单元测试类别，类似于JUnit4中的@Categories
 * ● @Disabled :表示测试类或测试方法不执行，类似于JUnit4中的@Ignore
 * ● @Timeout :表示测试方法运行如果超过了指定时间将会返回错误
 * ● @ExtendWith :为测试类或测试方法提供扩展类引用
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/16 18:49
 **/
@SpringBootTest
@DisplayName("测试类")
class SpringBoot2ProjectApplicationTests {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	DataSource dataSource;

	@Disabled
	@DisplayName("测试数据源")
	@Test
	void contextLoads() {
		Long count = jdbcTemplate.queryForObject("select count(*) from t_user", Long.class);
		System.out.println("查询出"+count+"条数据");
		System.out.println("dataSource.getClass() = " + dataSource.getClass());
	}

	@Test
	void test2(){
		System.out.println("测试方法2");
	}

	@Test
	void test3(){
		System.out.println("测试方法3");
	}

	@RepeatedTest(5)
	@Test
	void test5(){
		System.out.println("重复测试方法5次");
	}

	@DisplayName("超时方法测试")
	@Timeout(value = 100,unit = TimeUnit.MILLISECONDS)
	@Test
	void timeout() throws InterruptedException {
		System.out.println("超时方法");
		Thread.sleep(200);
	}

	@BeforeEach
	void before(){
		System.out.println("测试之前执行方法，每个方法执行之前都会执行");
	}

	@AfterEach
	void after(){
		System.out.println("测试之后执行方法，每个方法执行之后都会执行");
	}

	@BeforeAll
    static void beforeAll(){
		System.out.println("所有测试之前执行方法，执行一次");
	}

	@AfterAll
	static void afterALL(){
		System.out.println("所有测试之后执行方法，执行一次");
	}

}

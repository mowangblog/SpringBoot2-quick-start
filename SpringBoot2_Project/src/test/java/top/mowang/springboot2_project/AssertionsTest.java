package top.mowang.springboot2_project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

/**
 * SpringBoot2-quick-start
 * 断言测试
 * assertEquals	判断两个对象或两个原始类型是否相等
 * assertNotEquals	判断两个对象或两个原始类型是否不相等
 * assertSame	判断两个对象引用是否指向同一个对象
 * assertNotSame	判断两个对象引用是否指向不同的对象
 * assertTrue	判断给定的布尔值是否为 true
 * assertFalse	判断给定的布尔值是否为 false
 * assertNull	判断给定的对象引用是否为 null
 * assertNotNull	判断给定的对象引用是否不为 null
 * @author : Xuan Li
 * @website : https://mowangblog.top
 * @date : 2021/10/16 18:58
 **/
@SpringBootTest
public class AssertionsTest {

    @Test
    @DisplayName("断言测试方法")
    public void test1(){
        assertEquals(1,2);
    }

    @Test
    @DisplayName("array assertion")
    public void array() {
        assertArrayEquals(new int[]{1, 2}, new int[] {1, 2});
    }

    @Test
    @DisplayName("assert all")
    public void all() {
        assertAll("Math",
                () -> assertEquals(2, 1 + 1),
                () -> assertTrue(1 > 0)
        );
    }

    @Test
    @DisplayName("异常测试")
    public void exceptionTest() {
        ArithmeticException exception = Assertions.assertThrows(
                //扔出断言异常
                ArithmeticException.class, () -> System.out.println(1 % 0));

    }

    @Test
    @DisplayName("超时测试")
    public void timeoutTest() {
        //如果测试方法时间超过1s将会异常
        Assertions.assertTimeout(Duration.ofMillis(1000), () -> Thread.sleep(500));
    }

    @Test
    @DisplayName("fail")
    public void shouldFail() {
        fail("This should fail");
    }


}

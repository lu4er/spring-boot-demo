package com.xkcoding.orm.mybatis.plus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ClassUtils;

import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoOrmMybatisPlusApplicationTests {

	@Test
	public void contextLoads() {
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		String path = Objects.requireNonNull(Objects.requireNonNull(ClassUtils.getDefaultClassLoader()).getResource("")).getPath();
		System.out.println(path);
	}

	public static void main(String[] args) {

	}
}
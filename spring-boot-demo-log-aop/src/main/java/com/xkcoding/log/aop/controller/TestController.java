package com.xkcoding.log.aop.controller;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.StrUtil;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 测试 Controller
 * </p>
 *
 * @package: com.xkcoding.log.aop.controller
 * @description: 测试 Controller
 * @author: yangkai.shen
 * @date: Created in 2018/10/1 10:10 PM
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@RestController
public class TestController {

	/**
	 * 测试方法
	 *
	 * @param who 测试参数
	 * @return {@link Dict}
	 */
	@GetMapping("/test")
	public Dict test(String who) {
		return Dict.create().set("who", StrUtil.isBlank(who) ? "me" : who);
	}

	@PostMapping("/test")
	public Dict test(@RequestBody User user){
		return Dict.parse(user);
	}

	@PostMapping("/test1")
	public Dict test1(User user){
		return Dict.parse(user);
	}

	@PostMapping("/test2")
	public Dict test2(@RequestParam("who")String who){
		return Dict.create().set("who", StrUtil.isBlank(who) ? "me" : who);
	}

}

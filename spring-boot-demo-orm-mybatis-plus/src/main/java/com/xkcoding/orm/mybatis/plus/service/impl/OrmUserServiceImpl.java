package com.xkcoding.orm.mybatis.plus.service.impl;

import com.xkcoding.orm.mybatis.plus.entity.OrmUser;
import com.xkcoding.orm.mybatis.plus.mapper.OrmUserMapper;
import com.xkcoding.orm.mybatis.plus.service.IOrmUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Spring Boot Demo Orm 系列示例表 服务实现类
 * </p>
 *
 * @author zjz
 * @since 2020-01-07
 */
@Service
public class OrmUserServiceImpl extends ServiceImpl<OrmUserMapper, OrmUser> implements IOrmUserService {

}

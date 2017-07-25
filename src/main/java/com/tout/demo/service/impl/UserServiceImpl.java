package com.tout.demo.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tout.demo.entity.User;
import com.tout.demo.mapper.UserMapper;
import com.tout.demo.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Tout-An
 * @since 2017-07-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
	
}

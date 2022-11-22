package com.chen.springboot.mapper;

import com.chen.springboot.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Eveerme
 * @since 2022-11-20
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}

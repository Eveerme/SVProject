package com.chen.springboot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.springboot.entity.User;
import com.chen.springboot.utils.R;
import com.chen.springboot.utils.dto.UserDTO;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Eveerme
 * @since 2022-11-20
 */
public interface IUserService extends IService<User> {
    Boolean saveOrUpdateUser(User user);
    Boolean removeUserById(Integer id);
    IPage<User> getUserByPage(Integer currentPage, Integer pageSize, String username);

    Boolean deleteBatchUserById(List<Integer> ids);

    void importXlsxFile(HttpServletResponse response) throws Exception;

    R login(UserDTO userDTO);
}

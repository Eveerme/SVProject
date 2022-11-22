package com.chen.springboot.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.chen.springboot.utils.Constants;
import com.chen.springboot.utils.R;
import com.chen.springboot.utils.dto.UserDTO;
import io.swagger.annotations.ApiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.chen.springboot.service.IUserService;
import com.chen.springboot.entity.User;
import org.springframework.web.multipart.MultipartFile;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Eveerme
 * @since 2022-11-20
 */
@RestController
@RequestMapping("/user")
@ApiModel(value = "com.chen.springboot.controller.UserController",description = "UserController")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/save")
    public R saveUser(@RequestBody User user) {
        if (userService.saveOrUpdateUser(user)){
            return R.success();
        }
        return R.error();
    }

    @DeleteMapping("/delete/{id}")
    public R deleteUserById(@PathVariable Integer id) {
        if (userService.removeUserById(id)){
            return R.success();
        }
        return R.error();
    }

    //批量根据Id删除用户
    @DeleteMapping("/delete/batch")
    public R deleteBatchUserById(@RequestBody List<Integer> ids){
        if (userService.deleteBatchUserById(ids)){
            return R.success();
        }
        return R.error();
    }

    @GetMapping
    public R findAllUser() {
        return R.success(userService.list());
    }

    @GetMapping("/{id}")
    public R findOneUserById(@PathVariable("id") Integer id) {
        return R.success(userService.getById(id));
    }

    @GetMapping("/page")
    public R findUserByPage(@RequestParam("currentPage") Integer currentPage,
                            @RequestParam("pageSize") Integer pageSize,
                            @RequestParam(value = "username",defaultValue = "") String username) {
        return R.success(userService.getUserByPage(currentPage,pageSize,username));
    }

    /*
    * 导出Excel文件
    * */
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        userService.importXlsxFile(response);
    }
    /*
    * 导入Excel文件
    * */
    @PostMapping("/import")
    public R importExcelFile(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        ExcelReader reader = ExcelUtil.getReader(inputStream);
// 方式1：(推荐) 通过 javabean的方式读取Excel内的对象，但是要求表头必须是英文，跟javabean的属性要对应起来
//      List<User> list = reader.readAll(User.class);

// 方式2：忽略表头的中文，直接读取表的内容
        List<List<Object>> list = reader.read(1);
        List<User> users = CollUtil.newArrayList();
        for (List<Object> row : list) {
            User user = new User();
            user.setUsername(row.get(0).toString());
            user.setPassword(row.get(1).toString());
            user.setNickname(row.get(2).toString());
            user.setEmail(row.get(3).toString());
            user.setPhone(row.get(4).toString());
            user.setAddress(row.get(5).toString());
            user.setAvatarUrl(row.get(6).toString());
            users.add(user);
        }

        if (userService.saveBatch(users)){
            return R.success();
        } else {
            return R.error(Constants.CODE_500,"保存失败");
        }
    }
    @PostMapping("/login")
    public R login(@RequestBody UserDTO userDTO){
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        if (StrUtil.isBlank(username) || StrUtil.isBlank(password)){
            return R.error(Constants.CODE_600,"用户名或者密码为空!");
        }
        return userService.login(userDTO);
    }
}


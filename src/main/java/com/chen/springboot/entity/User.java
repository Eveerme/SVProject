package com.chen.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 *
 * </p>
 *
 * @author Eveerme
 * @since 2022-11-20
 */
@Getter
@Setter
@TableName("user")
@ApiModel(value = "com.chen.springboot.entity.User",description = "新增用户参数")  // 描述类的一些基本信息的
// value => 提供的是类的一个备用名。如果我们不设置，那么默认情况下，将使用的是class类的名字
// description => 提供一个详细的描述信息
@ToString
  public class User implements Serializable {

    private static final long serialVersionUID = 1L;

      /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("昵称")
    private String nickname;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("电话")
    private String phone;
    @ApiModelProperty("地址")
    private String address;

    /**
   * 创建时间
   */
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;
    @ApiModelProperty("头像")
    private String avatarUrl;

}

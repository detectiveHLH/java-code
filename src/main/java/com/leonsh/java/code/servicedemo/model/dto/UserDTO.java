package com.leonsh.java.code.servicedemo.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UserDTO
 *
 * @author leonsh
 * @date 2022-05-24 15:29
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 微信openid
     */
    @JsonProperty(value = "wechat_open_id")
    private String wechatOpenId;

    /**
     * 删除状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 修改时间
     */
    private Long modifyTime;
}

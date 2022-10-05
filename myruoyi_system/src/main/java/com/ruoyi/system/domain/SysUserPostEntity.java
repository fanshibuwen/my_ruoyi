package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户与岗位关联表
 * </p>
 *
 * @author zhaol
 * @since 2022-09-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user_post")
public class SysUserPostEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 岗位ID
     */
    private Long postId;


}

package com.lrs.core.book.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 书库表
 * </p>
 *
 * @author rstyro
 * @since 2020-09-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Books implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 书籍编号
     */
    private String number;

    /**
     * 分类ID
     */
    private Long classifyId;

    /**
     * 书名
     */
    private String bookName;

    /**
     * 简介备注
     */
    private String remark;

    /**
     * 封面图
     */
    private String images;

    /**
     * 库存
     */
    private Integer stockNum;

    /**
     * 书籍来源：公司、个人捐献
     */
    private String source;

    /**
     * 状态：0 -- 不可借，1 -- 可借，2-- 已借出，3 -- 归还超时，4 -- 遗失
     */
    private Integer state;

    /**
     * 是否删除
     */
    private Boolean isDel;

    /**
     * 最后更新人ID
     */
    private Long modifyBy;

    /**
     * 最后更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifyTime;

    /**
     * 创建人ID
     */
    private Long createBy;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;


}

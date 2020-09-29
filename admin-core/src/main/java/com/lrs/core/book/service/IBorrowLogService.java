package com.lrs.core.book.service;

import com.lrs.core.book.entity.BorrowLog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lrs.common.constant.Result;
import com.lrs.common.dto.PageDTO;
import com.lrs.core.admin.entity.User;

/**
 * <p>
 *  借书记录表 服务类
 * </p>
 *
 * @author rstyro
 * @since 2020-9-29
 */
public interface IBorrowLogService extends IService<BorrowLog> {
    public Result getList(PageDTO dto) throws  Exception;
    public Result add(BorrowLog item, User user) throws  Exception;
    public Result edit(BorrowLog item, User user) throws  Exception;
    public Result del(Long id, User user) throws  Exception;
    public Result getDetail(Long id) throws  Exception;
}

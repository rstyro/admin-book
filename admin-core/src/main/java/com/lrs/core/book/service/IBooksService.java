package com.lrs.core.book.service;

import com.lrs.core.book.entity.Books;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lrs.common.constant.Result;
import com.lrs.common.dto.PageDTO;
import com.lrs.core.admin.entity.User;

/**
 * <p>
 *  书库表 服务类
 * </p>
 *
 * @author rstyro
 * @since 2020-9-29
 */
public interface IBooksService extends IService<Books> {
    public Result getList(PageDTO dto) throws  Exception;
    public Result add(Books item, User user) throws  Exception;
    public Result edit(Books item, User user) throws  Exception;
    public Result del(Long id, User user) throws  Exception;
    public Result getDetail(Long id) throws  Exception;
}

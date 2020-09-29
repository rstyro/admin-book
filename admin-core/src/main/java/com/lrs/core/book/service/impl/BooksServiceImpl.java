package com.lrs.core.book.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lrs.common.constant.Result;
import com.lrs.common.dto.PageDTO;
import org.springframework.util.StringUtils;
import com.lrs.core.admin.entity.User;
import java.time.LocalDateTime;

import com.lrs.core.book.entity.Books;
import com.lrs.core.book.mapper.BooksMapper;
import com.lrs.core.book.service.IBooksService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


/**
 * <p>
 * 书库表 服务实现类
 * </p>
 *
 * @author rstyro
 * @since 2020-09-29
 */
@Service
public class BooksServiceImpl extends ServiceImpl<BooksMapper, Books> implements IBooksService{

    @Override
    public Result getList(PageDTO dto) throws Exception {
        IPage<Books> page = new Page<>();
        if(dto.getPageNo() != null){
            page.setCurrent(dto.getPageNo());
        }
        if(dto.getPageSize() != null){
            page.setSize(dto.getPageSize());
        }
        QueryWrapper<Books> queryWrapper = new QueryWrapper();
            if(!StringUtils.isEmpty(dto.getKeyword())){
                queryWrapper.lambda()
                        .like(Books::getBookName,dto.getKeyword());
            }
        IPage<Books> iPage = this.page(page, queryWrapper);
        return Result.ok(iPage);
    }

    @Override
    public Result add(Books item, User adminUser) throws Exception {
        if(item.getCreateTime() == null){
            item.setCreateBy(adminUser.getUserId());
            item.setCreateTime(LocalDateTime.now());
        }
        this.save(item);
        return Result.ok();
    }

    @Override
    public Result edit(Books item, User adminUser) throws Exception {
        item.setModifyBy(adminUser.getUserId());
        item.setModifyTime(LocalDateTime.now());
        this.updateById(item);
       return Result.ok();
    }

    @Override
    public Result del(Long id, User adminUser) throws Exception {
        this.removeById(id);
        return Result.ok();
    }

    @Override
    public Result getDetail(Long id) throws Exception {
    Books item = this.getOne(new QueryWrapper<Books>().lambda().eq(Books::getId,id));
         return Result.ok(item);
    }
}

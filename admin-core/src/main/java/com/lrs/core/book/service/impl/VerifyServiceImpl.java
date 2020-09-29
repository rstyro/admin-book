package com.lrs.core.book.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lrs.common.constant.Result;
import com.lrs.common.dto.PageDTO;
import com.lrs.core.admin.entity.User;
import com.lrs.core.book.entity.Verify;
import com.lrs.core.book.mapper.VerifyMapper;
import com.lrs.core.book.service.IVerifyService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


/**
 * <p>
 * 书籍借出与归还审核 服务实现类
 * </p>
 *
 * @author rstyro
 * @since 2020-09-29
 */
@Service
public class VerifyServiceImpl extends ServiceImpl<VerifyMapper, Verify> implements IVerifyService{

    @Override
    public Result getList(PageDTO dto) throws Exception {
        IPage<Verify> page = new Page<>();
        if(dto.getPageNo() != null){
            page.setCurrent(dto.getPageNo());
        }
        if(dto.getPageSize() != null){
            page.setSize(dto.getPageSize());
        }
        QueryWrapper<Verify> queryWrapper = new QueryWrapper();
        IPage<Verify> iPage = this.page(page, queryWrapper);
        return Result.ok(iPage);
    }

    @Override
    public Result add(Verify item, User adminUser) throws Exception {
        if(item.getCreateTime() == null){
            item.setCreateBy(adminUser.getUserId());
            item.setCreateTime(LocalDateTime.now());
        }
        this.save(item);
        return Result.ok();
    }

    @Override
    public Result edit(Verify item, User adminUser) throws Exception {
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
    Verify item = this.getOne(new QueryWrapper<Verify>().lambda().eq(Verify::getId,id));
         return Result.ok(item);
    }
}

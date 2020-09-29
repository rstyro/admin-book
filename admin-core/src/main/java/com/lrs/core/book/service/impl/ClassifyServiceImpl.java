package com.lrs.core.book.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lrs.common.constant.Result;
import com.lrs.common.dto.PageDTO;
import com.lrs.core.admin.entity.User;
import com.lrs.core.book.entity.Classify;
import com.lrs.core.book.mapper.ClassifyMapper;
import com.lrs.core.book.service.IClassifyService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


/**
 * <p>
 * 书籍分类表 服务实现类
 * </p>
 *
 * @author rstyro
 * @since 2020-09-29
 */
@Service
public class ClassifyServiceImpl extends ServiceImpl<ClassifyMapper, Classify> implements IClassifyService{

    @Override
    public Result getList(PageDTO dto) throws Exception {
        IPage<Classify> page = new Page<>();
        if(dto.getPageNo() != null){
            page.setCurrent(dto.getPageNo());
        }
        if(dto.getPageSize() != null){
            page.setSize(dto.getPageSize());
        }
        QueryWrapper<Classify> queryWrapper = new QueryWrapper();
        IPage<Classify> iPage = this.page(page, queryWrapper);
        return Result.ok(iPage);
    }

    @Override
    public Result add(Classify item, User adminUser) throws Exception {
        if(item.getCreateTime() == null){
            item.setCreateBy(adminUser.getUserId());
            item.setCreateTime(LocalDateTime.now());
        }
        this.save(item);
        return Result.ok();
    }

    @Override
    public Result edit(Classify item, User adminUser) throws Exception {
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
    Classify item = this.getOne(new QueryWrapper<Classify>().lambda().eq(Classify::getId,id));
         return Result.ok(item);
    }
}

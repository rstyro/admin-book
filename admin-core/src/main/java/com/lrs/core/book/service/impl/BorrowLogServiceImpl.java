package com.lrs.core.book.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lrs.common.constant.Result;
import com.lrs.common.dto.PageDTO;
import com.lrs.core.admin.entity.User;
import com.lrs.core.book.entity.BorrowLog;
import com.lrs.core.book.mapper.BorrowLogMapper;
import com.lrs.core.book.service.IBorrowLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


/**
 * <p>
 * 借书记录表 服务实现类
 * </p>
 *
 * @author rstyro
 * @since 2020-09-29
 */
@Service
public class BorrowLogServiceImpl extends ServiceImpl<BorrowLogMapper, BorrowLog> implements IBorrowLogService{

    @Override
    public Result getList(PageDTO dto) throws Exception {
        IPage<BorrowLog> page = new Page<>();
        if(dto.getPageNo() != null){
            page.setCurrent(dto.getPageNo());
        }
        if(dto.getPageSize() != null){
            page.setSize(dto.getPageSize());
        }
        QueryWrapper<BorrowLog> queryWrapper = new QueryWrapper();
        IPage<BorrowLog> iPage = this.page(page, queryWrapper);
        return Result.ok(iPage);
    }

    @Override
    public Result add(BorrowLog item, User adminUser) throws Exception {
        if(item.getCreateTime() == null){
            item.setCreateBy(adminUser.getUserId());
            item.setCreateTime(LocalDateTime.now());
        }
        this.save(item);
        return Result.ok();
    }

    @Override
    public Result edit(BorrowLog item, User adminUser) throws Exception {
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
    BorrowLog item = this.getOne(new QueryWrapper<BorrowLog>().lambda().eq(BorrowLog::getId,id));
         return Result.ok(item);
    }
}

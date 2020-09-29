package com.lrs.core.book.controller;
import com.lrs.common.annotation.Permission;
import com.lrs.common.annotation.PermissionType;
import com.lrs.core.book.entity.BorrowLog;
import com.lrs.core.book.service.IBorrowLogService;
import com.lrs.common.dto.PageDTO;
import com.lrs.core.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * <p>
 *  借书记录表 前端控制器
 * </p>
 *
 * @author rstyro
 * @since 2020-9-29
 */
@Controller
@RequestMapping("/book/borrowLog")
public class BorrowLogController extends BaseController {

    private final static String qxurl = "book/borrowLog/list";

    @Autowired
    private IBorrowLogService borrowLogService;

    @GetMapping("/list")
    public String list(Model model, PageDTO dto) throws Exception {
        System.out.println(dto);
        model.addAttribute("list",borrowLogService.getList(dto));
        return "page/book/borrowLog_list";
    }

    @PostMapping(value="/add")
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.ADD)
    public Object add(BorrowLog item) throws Exception {
        item.setId(null);
        return borrowLogService.add(item,this.getAdminUser());
    }

    @PostMapping(value="/edit")
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.EDIT)
    public Object edit(BorrowLog item) throws Exception {
        return borrowLogService.edit(item,this.getAdminUser());
    }

    @PostMapping(value="/del")
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.DEL)
    public Object del(Long id) throws Exception {
        return borrowLogService.del(id,this.getAdminUser());
    }

    @GetMapping(value="/query")
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.QUERY)
    public Object query(Long id) throws Exception {
        return borrowLogService.getDetail(id);
    }

}

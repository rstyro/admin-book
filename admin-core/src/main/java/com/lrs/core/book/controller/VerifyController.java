package com.lrs.core.book.controller;
import com.lrs.common.annotation.Permission;
import com.lrs.common.annotation.PermissionType;
import com.lrs.core.book.entity.Verify;
import com.lrs.core.book.service.IVerifyService;
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
 *  书籍借出与归还审核 前端控制器
 * </p>
 *
 * @author rstyro
 * @since 2020-9-29
 */
@Controller
@RequestMapping("/book/verify")
public class VerifyController extends BaseController {

    private final static String qxurl = "book/verify/list";

    @Autowired
    private IVerifyService verifyService;

    @GetMapping("/list")
    public String list(Model model, PageDTO dto) throws Exception {
        System.out.println(dto);
        model.addAttribute("list",verifyService.getList(dto));
        return "page/book/verify_list";
    }

    @PostMapping(value="/add")
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.ADD)
    public Object add(Verify item) throws Exception {
        item.setId(null);
        return verifyService.add(item,this.getAdminUser());
    }

    @PostMapping(value="/edit")
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.EDIT)
    public Object edit(Verify item) throws Exception {
        return verifyService.edit(item,this.getAdminUser());
    }

    @PostMapping(value="/del")
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.DEL)
    public Object del(Long id) throws Exception {
        return verifyService.del(id,this.getAdminUser());
    }

    @GetMapping(value="/query")
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.QUERY)
    public Object query(Long id) throws Exception {
        return verifyService.getDetail(id);
    }

}

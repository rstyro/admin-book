package com.lrs.core.book.controller;
import com.lrs.common.annotation.Permission;
import com.lrs.common.annotation.PermissionType;
import com.lrs.core.book.entity.Classify;
import com.lrs.core.book.service.IClassifyService;
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
 *  书籍分类表 前端控制器
 * </p>
 *
 * @author rstyro
 * @since 2020-9-29
 */
@Controller
@RequestMapping("/book/classify")
public class ClassifyController extends BaseController {

    private final static String qxurl = "book/classify/list";

    @Autowired
    private IClassifyService classifyService;

    @GetMapping("/list")
    public String list(Model model, PageDTO dto) throws Exception {
        System.out.println(dto);
        model.addAttribute("list",classifyService.getList(dto));
        return "page/book/classify_list";
    }

    @PostMapping(value="/add")
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.ADD)
    public Object add(Classify item) throws Exception {
        item.setId(null);
        return classifyService.add(item,this.getAdminUser());
    }

    @PostMapping(value="/edit")
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.EDIT)
    public Object edit(Classify item) throws Exception {
        return classifyService.edit(item,this.getAdminUser());
    }

    @PostMapping(value="/del")
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.DEL)
    public Object del(Long id) throws Exception {
        return classifyService.del(id,this.getAdminUser());
    }

    @GetMapping(value="/query")
    @ResponseBody
    @Permission(url = qxurl,type = PermissionType.QUERY)
    public Object query(Long id) throws Exception {
        return classifyService.getDetail(id);
    }

}

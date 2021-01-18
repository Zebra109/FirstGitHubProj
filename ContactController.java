package com.project.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.pojo.Contact;
import com.project.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/util")
public class ContactController {
    @Resource
    private ContactService contactService;

    @GetMapping("/list")
    public String getAll(@RequestParam(value = "pageIndex",defaultValue ="1") Integer pageIndex, Model model){
        PageHelper.startPage(pageIndex,5);
        List<Contact> list=contactService.getAll();
        PageInfo<Contact> pageInfo=new PageInfo<Contact>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "list";
    }
}

package cn.wjx.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sys")
public class SysController {

    @RequestMapping("/toRoleManager")
    public String toRoleManager(){
        System.out.println("===================");
        return "system/role/roleManager";
    }

    /**
     * 跳转菜单管理
     */
    @RequestMapping("/toMenuManager")
    public String toMenuManager(){
        return "system/menu/menuManager";
    }

    /**
     * 跳转菜单管理左边的菜单树页面
     */
    @RequestMapping("toMenuLeft")
    public  String toMenuLeft(){
        return "system/menu/menuLeft";
    }

    /**
     * 跳转菜单管理右边的菜单列表
     * @return
     */
    @RequestMapping("toMenuRight")
    public String toMenuRight(){
        return "system/menu/menuRight";
    }

    /**
     * 跳转用户管理页面
     */
    @RequestMapping("toUserManager")
    public String toUserManager() {
        return "system/user/userManager";
    }

    /**
     * 跳转日志管理页面
     */
    @RequestMapping("toLogInfoManager")
    public String toLogInfoManager() {
        return "system/logInfo/logInfoManager";
    }

    /**
     * 跳转公告管理页面
     */
    @RequestMapping("toNewsManager")
    public String toNewsManager() {
        return "system/news/newsManager";
    }

}

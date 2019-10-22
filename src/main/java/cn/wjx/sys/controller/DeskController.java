package cn.wjx.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 工作台控制器
 */
@Controller
@RequestMapping("/desk")
public class DeskController {
    /*
    跳转到工作台
     */
    @RequestMapping("/toDeskManager")
    public String toDeskManager(){
        return "system/main/deskManager";
    }
}

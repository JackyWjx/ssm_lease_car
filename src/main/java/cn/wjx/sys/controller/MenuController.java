package cn.wjx.sys.controller;

import cn.wjx.sys.constast.SysConstast;
import cn.wjx.sys.domain.Menu;
import cn.wjx.sys.domain.User;
import cn.wjx.sys.service.MenuService;
import cn.wjx.sys.utils.*;
import cn.wjx.sys.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单管理控制器
 */
@RestController
@RequestMapping("menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("loadIndexLeftMenuJson")
    public List<TreeNode> loadIndexLeftMenuJson(MenuVo menuVo){
        //得到当前登陆的用户对象
        User user=(User) WebUtils.getHttpSession().getAttribute("user");
        List<Menu> list=null;
        menuVo.setAvailable(SysConstast.AVAILABLE_TRUE);//只查询可用的
        if(user.getType()==SysConstast.USER_TYPE_SUPER) {
            list=this.menuService.queryAllMenuForList(menuVo);
        }else {
            list=this.menuService.queryMenuByUserIdForList(menuVo, user.getUserid());
        }
        List<TreeNode> nodes= new ArrayList<>();
        //把list里面的数据放到nodes
        for (Menu menu : list) {
            Integer id=menu.getId();
            Integer pid=menu.getPid();
            String title=menu.getTitle();
            String icon=menu.getIcon();
            String href=menu.getHref();
            Boolean spread=menu.getSpread()==SysConstast.SPREAD_TRUE?true:false;
            String target=menu.getTarget();
            nodes.add(new TreeNode(id, pid, title, icon, href, spread, target));
        }
        return TreeNodeBuilder.builder(nodes, 1);
    }


    /**
     * 加载菜单管理左边的菜单树
     */
    @RequestMapping("loadMenuManagerLeftTreeJson")
    public DataGridView loadMenuMangerLeftTreeJson(MenuVo menuVo){
        menuVo.setAvailable(SysConstast.AVAILABLE_TRUE);
        List<Menu> list = this.menuService.queryAllMenuForList(menuVo);
        List<TreeNode> nodes = new ArrayList<>();
        //把list里面的数据放到nodes
        for (Menu menu : list) {
            Integer id= menu.getId();
            Integer pid= menu.getPid();
            String title= menu.getTitle();
            String icon= menu.getIcon();
            String href= menu.getHref();
            Boolean spread= menu.getSpread()==SysConstast.SPREAD_TRUE?true:false;
            String target= menu.getTarget();
            nodes.add(new TreeNode(id,pid,title,icon,href,spread,target));
        }
        return new DataGridView(nodes);
    }
    /**
     * 加载菜单列表返回DataGridView
     */
    @RequestMapping("loadAllMenu")
    public DataGridView loadAllMenu(MenuVo menuVo) {
        return this.menuService.queryAllMenu(menuVo);
    }

    /**
     * 增加菜单
     */
    @RequestMapping("addMenu")
    public ResultObj addMenu(MenuVo menuVo){
        try {
            this.menuService.addMenu(menuVo);
            return ResultObj.ADD_SUCCESS;

        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }


    }
    @RequestMapping("updateMenu")
    public ResultObj updateMenu(MenuVo menuVo){
        try {
            this.menuService.updateMenu(menuVo);
            return ResultObj.UPDATE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }
    @RequestMapping("checkMenuHasChildren")
    public ResultObj checkMenuHasChildren(MenuVo menuVo){

        Integer i =this.menuService.checkMenuHasChildren(menuVo);
        if(i>0){
            return ResultObj.STATUS_TRUE;
        }else {
            return ResultObj.STATUS_FALSE;

        }

    }

    @RequestMapping("deleteMenu")
    public ResultObj deleteMenu(MenuVo menuVo){
        try{
            this.menuService.deleteMenu(menuVo);
            return ResultObj.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

}

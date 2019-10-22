package cn.wjx.sys.service.impl;

import cn.wjx.sys.domain.Menu;
import cn.wjx.sys.mapper.MenuMapper;
import cn.wjx.sys.service.MenuService;
import cn.wjx.sys.utils.DataGridView;
import cn.wjx.sys.vo.MenuVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;
    @Override
    public List<Menu> queryAllMenuForList(MenuVo menuVo) {
        return menuMapper.queryAllMenu(menuVo);
    }

    @Override
    public List<Menu> queryMenuByUserIdForList(MenuVo menuVo, Integer id) {
        return menuMapper.queryMenuByUid(menuVo.getAvailable(),id);
    }

    @Override
    public DataGridView queryAllMenu(MenuVo menuVo) {
        Page<Object> page = PageHelper.startPage(menuVo.getPage(),menuVo.getLimit());
        List<Menu> data = this.menuMapper.queryAllMenu(menuVo);

        return new DataGridView(page.getTotal(),data);
    }

    @Override
    public void addMenu(MenuVo menuVo) {
        this.menuMapper.insertSelective(menuVo);
    }

    @Override
    public void updateMenu(MenuVo menuVo) {
        this.menuMapper.updateByPrimaryKeySelective(menuVo);
    }

    @Override
    public Integer checkMenuHasChildren(MenuVo menuVo) {
        return this.menuMapper.checkMenuHasChildren(menuVo.getId());
    }

    @Override
    public void deleteMenu(MenuVo menuVo) {
        //删除菜单表的数据
        this.menuMapper.deleteByPrimaryKey(menuVo.getId());

        //根据菜单id删除sys_role_menu里面的数据
        this.menuMapper.deleteRoleMenuByMid(menuVo.getId());

    }
}

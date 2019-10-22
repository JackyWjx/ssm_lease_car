package cn.wjx.sys.service;

import cn.wjx.sys.domain.Menu;
import cn.wjx.sys.utils.DataGridView;
import cn.wjx.sys.vo.MenuVo;

import java.util.List;

/**
 * 菜单管理的服务接口
 */
public interface MenuService {
    /**
     * 查询所有菜单返回
     */
    public List<Menu> queryAllMenuForList(MenuVo menuVo);

    /**
     * 根据用户id查询用户的可用菜单
     *
     */
    public List<Menu> queryMenuByUserIdForList(MenuVo menuVo,Integer id);

    /**
     * 查询所有菜单
     * @param menuVo
     * @return
     */
    public DataGridView queryAllMenu(MenuVo menuVo);

    /**
     * 添加菜单
     * @param menuVo
     */
    public void addMenu(MenuVo menuVo);

    public void updateMenu(MenuVo menuVo);

    public Integer checkMenuHasChildren(MenuVo menuVo);

    public  void deleteMenu(MenuVo menuVo);

}

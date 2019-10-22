package cn.wjx.sys.mapper;

import cn.wjx.sys.domain.Menu;
import cn.wjx.sys.vo.MenuVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;



public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
    
    /**
     * 查询所有菜单
     */
    List<Menu> queryAllMenu(Menu menu);

    Integer checkMenuHasChildren(@Param("pid")Integer pid);

    public void deleteMenu(@Param("mid") Integer id);

    public void deleteRoleMenuByMid(@Param("mid")Integer id);

    /**
     * 根据角色ID查询菜单
     * @param available
     * @param rid
     * @return
     */
    List<Menu> queryMenuByRoleId(@Param("available")Integer available, @Param("rid")Integer rid);

    /**
     * 根据用户id查询菜单
     * @param available
     * @param id
     * @return
     */
    List<Menu> queryMenuByUid(@Param("available") Integer available,@Param("uid") Integer id);
}
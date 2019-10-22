package cn.wjx.sys.service;


import cn.wjx.sys.domain.User;
import cn.wjx.sys.utils.DataGridView;
import cn.wjx.sys.vo.UserVo;

/**
 * 用户服务接口
 * @author LJH
 *
 */
public interface UserService {

	User login(UserVo userVo);

	/**
	 * 查询所有用户
	 * @param userVo
	 * @return
	 */
	public DataGridView queryAllUser(UserVo userVo);

	/**
	 * 添加用户
	 * @param userVo
	 */
	public void addUser(UserVo userVo);

	/**
	 * 修改用户
	 * @param userVo
	 */
	public void updateUser(UserVo userVo);

	/**
	 * 根据id删除用户
	 * @param userid
	 */
	public void deleteUser(Integer userid);
	/**
	 * 批量删除用户
	 * @param ids
	 */
	public void deleteBatchUser(Integer [] ids);

	/**
	 * 重置密码
	 * @param userid
	 */
	public void resetUserPwd(Integer userid);

    DataGridView queryUserRole(Integer userid);

	void saveUserRole(UserVo userVo);
}

package cn.wjx.sys.service;


import cn.wjx.sys.utils.DataGridView;
import cn.wjx.sys.vo.LogInfoVo;

/**
 * 日志管理的服务接口
 * @author LJH
 *
 */
public interface LogInfoService {
	/**
	 * 查询所有日志
	 * @param logInfoVo
	 * @return
	 */
	public DataGridView queryAllLogInfo(LogInfoVo logInfoVo);
	/**
	 * 添加日志
	 * @param logInfoVo
	 */
	public void addLogInfo(LogInfoVo logInfoVo);
	/**
	 * 根据id删除日志
	 * @param logInfoid
	 */
	public void deleteLogInfo(Integer logInfoid);
	/**
	 * 批量删除日志
	 * @param
	 */
	public void deleteBatchLogInfo(Integer[] ids);

}

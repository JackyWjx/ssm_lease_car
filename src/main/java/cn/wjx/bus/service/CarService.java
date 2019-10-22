package cn.wjx.bus.service;


import cn.wjx.bus.vo.CarVo;
import cn.wjx.sys.utils.DataGridView;

/**
 * 车辆管理的服务接口
 * @author LJH
 *
 */
public interface CarService {
	/**
	 * 查询所有车辆
	 * @param carVo
	 * @return
	 */
	public DataGridView queryAllCar(CarVo carVo);
	/**
	 * 添加车辆
	 * @param carVo
	 */
	public void addCar(CarVo carVo);
	/**
	 * 修改车辆
	 * @param carVo
	 */
	public void updateCar(CarVo carVo);
	/**
	 * 根据id删除车辆
	 * @param
	 */
	public void deleteCar(String carnumber);
	/**
	 * 批量删除车辆
	 * @param
	 */
	public void deleteBatchCar(String[] carnumbers);

}

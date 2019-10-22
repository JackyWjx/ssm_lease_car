package cn.wjx.bus.controller;

import java.util.Date;

import cn.wjx.bus.service.CarService;
import cn.wjx.bus.vo.CarVo;
import cn.wjx.sys.constast.SysConstast;
import cn.wjx.sys.utils.AppFileUtils;
import cn.wjx.sys.utils.DataGridView;
import cn.wjx.sys.utils.ResultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 车辆管理控制器
 * 
 * @author LJH
 *
 */
@RestController
@RequestMapping("car")
public class CarController {

	@Autowired
	private CarService carService;

	/**
	 * 加载车辆列表返回DataGridView
	 */
	@RequestMapping("loadAllCar")
	public DataGridView loadAllCar(CarVo carVo) {
		return this.carService.queryAllCar(carVo);
	}

	/**
	 * 添加车辆
	 */
	@RequestMapping("addCar")
	public ResultObj addCar(CarVo carVo) {
		try {
			carVo.setCreatetime(new Date());
			//如果不是默认图片就去掉图片的_temp的后缀
			if(!carVo.getCarimg().equals(SysConstast.DEFAULT_CAR_IMG)) {
				String filePath= AppFileUtils.updateFileName(carVo.getCarimg(),SysConstast.FILE_UPLOAD_TEMP);
				carVo.setCarimg(filePath);

			}
			this.carService.addCar(carVo);
			return ResultObj.ADD_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.ADD_ERROR;
		}
	}

	/**
	 * 修改车辆
	 */
	@RequestMapping("updateCar")
	public ResultObj updateCar(CarVo carVo) {
		try {
			this.carService.updateCar(carVo);
			return ResultObj.UPDATE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.UPDATE_ERROR;
		}
	}

	/**
	 * 删除车辆
	 */
	@RequestMapping("deleteCar")
	public ResultObj deleteCar(CarVo carVo) {
		try {
			this.carService.deleteCar(carVo.getCarnumber());
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.DELETE_ERROR;
		}
	}

	/**
	 * 批量删除车辆
	 */
	@RequestMapping("deleteBatchCar")
	public ResultObj deleteBatchCar(CarVo carVo) {
		try {
			this.carService.deleteBatchCar(carVo.getIds());
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.DELETE_ERROR;
		}
	}
}

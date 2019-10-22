package cn.wjx.bus.service.impl;

import java.util.List;

import cn.wjx.bus.domain.Car;
import cn.wjx.bus.mapper.CarMapper;
import cn.wjx.bus.service.CarService;
import cn.wjx.bus.vo.CarVo;
import cn.wjx.sys.utils.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class CarServiceImpl implements CarService {
	
	@Autowired
	private CarMapper carMapper;

	@Override
	public DataGridView queryAllCar(CarVo carVo) {
		Page<Object> page=PageHelper.startPage(carVo.getPage(), carVo.getLimit());
		List<Car> data = this.carMapper.queryAllCar(carVo);
		return new DataGridView(page.getTotal(), data);
	}

	@Override
	public void addCar(CarVo carVo) {
		this.carMapper.insertSelective(carVo);
	}

	@Override
	public void deleteCar(String carnumber) {
		this.carMapper.deleteByPrimaryKey(carnumber);
	}

	@Override
	public void deleteBatchCar(String[] carnumbers) {
		for (String carnumber : carnumbers) {
			this.deleteCar(carnumber);
		}
	}

	@Override
	public void updateCar(CarVo carVo) {
		this.carMapper.updateByPrimaryKeySelective(carVo);
	}


}

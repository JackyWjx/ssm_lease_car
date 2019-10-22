package cn.wjx.stat.service.impl;

import cn.wjx.stat.domain.BaseEntity;
import cn.wjx.stat.mapper.StatMapper;
import cn.wjx.stat.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StatServiceimpl implements StatService {

    @Autowired
    private StatMapper statMapper;

    @Override
    public List<BaseEntity> loadCustomerAreaStatList() {

        return this.statMapper.queryCustomerAreaStat();
    }

    @Override
    public List<BaseEntity> loadOpernameYearGradeStat(String year) {
        return this.statMapper.queryOpernameYearGradeStat(year);
    }

    @Override
    public List<Double> loadCompanyYearGradeStat(String year) {
        return this.statMapper.queryCompanyYearGradeStat(year);
    }
}

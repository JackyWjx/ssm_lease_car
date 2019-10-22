package cn.wjx.stat.mapper;

import cn.wjx.stat.domain.BaseEntity;

import java.util.List;

public interface StatMapper {
    /**
     * 查询客户地区的数据
     * @return
     */
    public List<BaseEntity> queryCustomerAreaStat() ;

    /**
     * 查询业务员年度的数据
     * @return
     */
    List<BaseEntity> queryOpernameYearGradeStat(String year);

    List<Double> queryCompanyYearGradeStat(String year);
}

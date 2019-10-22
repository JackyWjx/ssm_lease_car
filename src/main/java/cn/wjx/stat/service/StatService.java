package cn.wjx.stat.service;

import cn.wjx.stat.domain.BaseEntity;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.List;

@Service
public interface StatService {
    /*
    查询客户地区
     */
    List<BaseEntity> loadCustomerAreaStatList();

    List<BaseEntity> loadOpernameYearGradeStat(String year);

    List<Double> loadCompanyYearGradeStat(String year);
}

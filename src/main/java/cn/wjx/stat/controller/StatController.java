package cn.wjx.stat.controller;

import cn.wjx.stat.domain.BaseEntity;
import cn.wjx.stat.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("stat")
public class StatController {

    @Autowired
    private StatService statService;
    /**
     * 跳转到客户地区统计页面
     */
    @RequestMapping("toCustomerAreaStat")
    public String toCustomerAreaStat(){
        return "stat/customerAreaStat";
    }
    /**
     * 跳转到业务员业务统计页面
     */
    @RequestMapping("toOpernameYearGradeStat")
    public String toOpernameYearGradeStat(){
        return "stat/opernameYearGradeStat";
    }

    /**
     * 加载客户地区数据
     */
    @ResponseBody
    @RequestMapping("loadCustomerAreaStatJson")
    public List<BaseEntity> loadCustomerAreaStatJson(){
        return this.statService.loadCustomerAreaStatList();
    }

    /**
     * 加载客户地区数据
     */
    @ResponseBody
    @RequestMapping("loadOpernameYearGradeStat")
    public Map<String,Object> opernameYearGradeStat(String year){
        List<BaseEntity> baseEntities = this.statService.loadOpernameYearGradeStat(year);
        Map<String,Object> map = new HashMap<>();
        List<String> name = new ArrayList<>();
        List<Double> value = new ArrayList<>();
        for (BaseEntity baseEntity:baseEntities){
            name.add(baseEntity.getName());
            value.add(baseEntity.getValue());
        }
        map.put("name",name);
        map.put("value",value);
        return map;
    }

    /**
     * 跳转到客户地区统计页面
     */
    @RequestMapping("toCompanyYearGradeStat")
    public String toCompanyYearGradeStat(){
        return "stat/componyYearGradeStat";
    }


    /**
     * 加载客户地区数据
     */
    @ResponseBody
    @RequestMapping("loadCompanyYearGradeStat")
    public List<Double> loadCompanyYearGradeStat(String year){
        List<Double> entities = this.statService.loadCompanyYearGradeStat(year);
        for (int i = 0; i < entities.size(); i++) {
            if(null==entities.get(i)){
                entities.set(i,0.0);
            }
        }
        return entities;
    }

}

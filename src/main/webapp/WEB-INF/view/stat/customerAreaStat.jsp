<%--
  Created by IntelliJ IDEA.
  User: 山兮木
  Date: 2019/10/20
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客户地区统计</title>
</head>

<body style="height: 100%; margin: 0">
<div id="container" style="height: 100%"></div>
<script type="text/javascript" src="${ctx}/resources/echarts/js/echarts.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/echarts/js/jquery.js"></script>
<script type="text/javascript">
    $.get("${ctx}/stat/loadCustomerAreaStatJson.action",function (data) {
        var dom = document.getElementById("container");
        var myChart = echarts.init(dom);
        var app = {};
        option = null;
        option = {
            title : {
                text: '汽车出租系统客户地址统计',
                subtext: '真实有效',
                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data:data
            },
            series : [
                {
                    name: '客户数量占比',
                    type: 'pie',
                    radius : '55%',
                    center: ['50%', '60%'],
                    data:data,
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        ;
        if (option && typeof option === "object") {
            myChart.setOption(option, true);
        }
    })

</script>

</body>
</html>

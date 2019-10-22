package cn.wjx.sys.vo;

import cn.wjx.sys.domain.User;

public class UserVo extends User {
    /**
     * 分页参数
     */
    private Integer page;
    private Integer limit;
    private String code;

    //接收多个用户id
    private Integer [] ids;

    public UserVo() {
    }

    public UserVo(Integer page, Integer limit, Integer[] ids) {
        this.page = page;
        this.limit = limit;
        this.ids = ids;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

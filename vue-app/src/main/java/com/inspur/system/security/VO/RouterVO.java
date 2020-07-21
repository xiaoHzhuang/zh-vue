package com.inspur.system.security.VO;

public class RouterVO {
    private String id;

    private String path;

    private String name;

    private String component;

    private String redirect;

    private String iconcls;

    private String meta;

    private String pid;

    private Integer orderid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public String getIconcls() {
        return iconcls;
    }

    public void setIconcls(String iconcls) {
        this.iconcls = iconcls;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    @Override
    public String toString() {
        return "ModuleVO{" +
                "id='" + id + '\'' +
                ", path='" + path + '\'' +
                ", name='" + name + '\'' +
                ", component='" + component + '\'' +
                ", redirect='" + redirect + '\'' +
                ", iconcls='" + iconcls + '\'' +
                ", meta='" + meta + '\'' +
                ", pid='" + pid + '\'' +
                ", orderid=" + orderid +
                '}';
    }
}

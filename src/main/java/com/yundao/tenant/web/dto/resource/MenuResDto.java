package com.yundao.tenant.web.dto.resource;

import com.yundao.core.utils.BooleanUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 权限资源DTO
 *
 * @author jan
 * @create 2017-07-03 PM2:43
 **/
public class MenuResDto implements Serializable{

    private static final long serialVersionUID = -1L;

    /**
     * 资源id
     */
    private Long id;

    /**
     * 父级id
     */
    private Long parentId;

    /**
     * 编码
     */
    private String code;

    /**
     * 地址
     */
    private String path;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 是否选中 1：是；0：否
     */
    private Integer check;

    /**
     * 是否显示 1:是否；0：否
     */
    private Integer display;

    private List<MenuResDto> childs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MenuResDto> getChilds() {
        if (BooleanUtils.isEmpty(this.childs))
            this.childs = new ArrayList<>();
        return this.childs;
    }

    public void setChilds(List<MenuResDto> childs) {
        this.childs = childs;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCheck() {
        return check;
    }

    public void setCheck(Integer check) {
        this.check = check;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }
}

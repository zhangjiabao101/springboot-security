package com.aaa.entity;
/**
 *  权限信息
 * @author 淮南King
 */
public class PermissionDto {
    /**
     * 权限id
     */
    private String id;
    /**
     * 权限代号
     */
    private String code;
    /**
     * 权限描述
     */
    private String description;
    /**
     * 路径
     */
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

package com.xiaojumao.utils;

import com.xiaojumao.bean.Student;

import java.util.List;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-04-16 13:56
 * @Modified By:
 */
public class PageInfo {
    // 存储查询结果
    private List<Student> stuList;
    // 存储模糊查相关
    private String stuName;
    private String stuNo;
    private Integer sex;
    // 存储分页相关
    private Integer pageSize; // 一页条数
    private Integer indexTotal; // 总条数
    private Integer pageTotal; // 总页数
    private Integer pageIndex; // 当前页数

    public List<Student> getStuList() {
        return stuList;
    }

    public void setStuList(List<Student> stuList) {
        this.stuList = stuList;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getIndexTotal() {
        return indexTotal;
    }

    public void setIndexTotal(Integer indexTotal) {
        this.indexTotal = indexTotal;
        setPageTotal();
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal() {
        if(pageSize != 0)
            this.pageTotal = (int)Math.ceil((double) indexTotal / pageSize);
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public PageInfo(){}

    public PageInfo(List<Student> stuList, String stuName, String stuNo, Integer sex,
                    Integer pageSize, Integer indexTotal, Integer pageTotal, Integer pageIndex) {
        this.stuList = stuList;
        this.stuName = stuName;
        this.stuNo = stuNo;
        this.sex = sex;
        this.pageSize = pageSize;
        this.indexTotal = indexTotal;
        this.pageTotal = pageTotal;
        this.pageIndex = pageIndex;
    }
}

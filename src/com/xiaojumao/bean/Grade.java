package com.xiaojumao.bean;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-04-14 8:50
 * @Modified By:
 */
public class Grade {
    private Integer gradeId;
    private String gradeName;

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public Grade(){}

    public Grade(Integer gradeId, String gradeName) {
        this.gradeId = gradeId;
        this.gradeName = gradeName;
    }
}

package com.xiaojumao.service;

import com.xiaojumao.bean.Grade;

import java.util.List;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-04-14 8:52
 * @Modified By:
 */
public interface GradeService {
    /**
     * 查询所有年级信息
     * @return
     */
    public List<Grade> getGrade();
}

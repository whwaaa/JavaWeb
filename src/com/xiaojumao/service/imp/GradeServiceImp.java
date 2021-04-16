package com.xiaojumao.service.imp;

import com.xiaojumao.bean.Grade;
import com.xiaojumao.dao.imp.GradeDaoImp;
import com.xiaojumao.service.GradeService;

import java.util.List;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-04-14 8:52
 * @Modified By:
 */
public class GradeServiceImp implements GradeService {
    @Override
    public List<Grade> getGrade() {
        GradeDaoImp gradeDaoImp = new GradeDaoImp();
        return gradeDaoImp.getGrade();
    }
}

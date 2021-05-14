package com.bjpowernode.service;

import com.bjpowernode.cache.ApplicationCache;
import com.bjpowernode.entity.Tender;
import com.bjpowernode.entity.Users;
import com.bjpowernode.initdata.initSystemDatas;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 */
@Service
public class ProjectPropertiesService {

    @Value("${projectName}")
    private String projectName;
    @Value("${projectVersion}")
    private String projectVersion;
    @Value("${projectAuthor}")
    private String projectAuthor;
    @Value("${isInsertDemoData}")
    private boolean isInsertDemoData;
    @Value("${pdfUploadAddress}")
    private String pdfUploadAddress;

    @Resource
    private HibernateTemplate hibernateTemplate;

    public String getProjectName() {
        return projectName;
    }

    public String getProjectVersion() {
        return projectVersion;
    }

    public String getProjectAuthor() {
        return projectAuthor;
    }

    public void initCacheData() {

        ApplicationCache.pdfUploadAddress = pdfUploadAddress;
    }

    /**
     * 必要初始化数据
     * 插入测试数据
     */
    public void insertDemoData() {

        if (!this.isInsertDemoData) {

            //admin 用户校验
            if (
                    hibernateTemplate.findByCriteria(
                            DetachedCriteria.forClass(Users.class)
                                    .add(Restrictions.eq("userName", "admin"))
                    ).isEmpty()) {
                hibernateTemplate.save(initSystemDatas.ADMIN);
            }

            return;
        }

        try {
            for (Users users : initSystemDatas.getUsers()) {
                hibernateTemplate.save(users);
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        try {
            for (Tender tender : initSystemDatas.getTenders()) {
                hibernateTemplate.save(tender);
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}

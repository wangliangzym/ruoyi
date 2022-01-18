package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysTeacher;

/**
 * 教师信息Service接口
 * 
 * @author ruoyi
 * @date 2021-08-02
 */
public interface ISysTeacherService 
{
    /**
     * 查询教师信息
     * 
     * @param id 教师信息主键
     * @return 教师信息
     */
    public SysTeacher selectSysTeacherById(Long id);

    /**
     * 查询教师信息列表
     * 
     * @param sysTeacher 教师信息
     * @return 教师信息集合
     */
    public List<SysTeacher> selectSysTeacherList(SysTeacher sysTeacher);

    /**
     * 新增教师信息
     * 
     * @param sysTeacher 教师信息
     * @return 结果
     */
    public int insertSysTeacher(SysTeacher sysTeacher);

    /**
     * 修改教师信息
     * 
     * @param sysTeacher 教师信息
     * @return 结果
     */
    public int updateSysTeacher(SysTeacher sysTeacher);

    /**
     * 批量删除教师信息
     * 
     * @param ids 需要删除的教师信息主键集合
     * @return 结果
     */
    public int deleteSysTeacherByIds(Long[] ids);

    /**
     * 删除教师信息信息
     * 
     * @param id 教师信息主键
     * @return 结果
     */
    public int deleteSysTeacherById(Long id);
}

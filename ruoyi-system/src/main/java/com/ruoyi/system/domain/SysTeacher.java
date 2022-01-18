package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 教师信息对象 sys_teacher
 * 
 * @author ruoyi
 * @date 2021-08-02
 */
public class SysTeacher extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String teacherName;

    /** 性别 */
    @Excel(name = "性别")
    private String teacherSex;

    /** 图像 */
    @Excel(name = "图像")
    private String photo;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTeacherName(String teacherName) 
    {
        this.teacherName = teacherName;
    }

    public String getTeacherName() 
    {
        return teacherName;
    }
    public void setTeacherSex(String teacherSex) 
    {
        this.teacherSex = teacherSex;
    }

    public String getTeacherSex() 
    {
        return teacherSex;
    }
    public void setPhoto(String photo) 
    {
        this.photo = photo;
    }

    public String getPhoto() 
    {
        return photo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("teacherName", getTeacherName())
            .append("teacherSex", getTeacherSex())
            .append("photo", getPhoto())
            .toString();
    }
}

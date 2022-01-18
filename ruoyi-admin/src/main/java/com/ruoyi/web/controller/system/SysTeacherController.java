package com.ruoyi.web.controller.system;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysTeacher;
import com.ruoyi.system.service.ISysTeacherService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 教师信息Controller
 * 
 * @author ruoyi
 * @date 2021-08-02
 */
@RestController
@RequestMapping("/system/teacher")
public class SysTeacherController extends BaseController
{
    @Autowired
    private ISysTeacherService sysTeacherService;

    /**
     * 查询教师信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:teacher:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysTeacher sysTeacher)
    {
        startPage();
        List<SysTeacher> list = sysTeacherService.selectSysTeacherList(sysTeacher);
        return getDataTable(list);
    }

    /**
     * 导出教师信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:teacher:export')")
    @Log(title = "教师信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysTeacher sysTeacher)
    {
        List<SysTeacher> list = sysTeacherService.selectSysTeacherList(sysTeacher);
        ExcelUtil<SysTeacher> util = new ExcelUtil<SysTeacher>(SysTeacher.class);
        return util.exportExcel(list, "教师信息数据");
    }

    /**
     * 获取教师信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:teacher:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sysTeacherService.selectSysTeacherById(id));
    }

    /**
     * 新增教师信息
     */
    @PreAuthorize("@ss.hasPermi('system:teacher:add')")
    @Log(title = "教师信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysTeacher sysTeacher)
    {
        return toAjax(sysTeacherService.insertSysTeacher(sysTeacher));
    }

    /**
     * 修改教师信息
     */
    @PreAuthorize("@ss.hasPermi('system:teacher:edit')")
    @Log(title = "教师信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysTeacher sysTeacher)
    {
        return toAjax(sysTeacherService.updateSysTeacher(sysTeacher));
    }

    /**
     * 删除教师信息
     */
    @PreAuthorize("@ss.hasPermi('system:teacher:remove')")
    @Log(title = "教师信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysTeacherService.deleteSysTeacherByIds(ids));
    }
}

package com.liurunqing.lease.web.admin.controller.lease;


import com.liurunqing.lease.common.result.Result;
import com.liurunqing.lease.model.entity.ViewAppointment;
import com.liurunqing.lease.model.enums.AppointmentStatus;
import com.liurunqing.lease.web.admin.service.ViewAppointmentService;
import com.liurunqing.lease.web.admin.vo.appointment.AppointmentQueryVo;
import com.liurunqing.lease.web.admin.vo.appointment.AppointmentVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Tag(name = "预约看房管理")
@RequestMapping("/admin/appointment")
@RestController
public class ViewAppointmentController {

    @Autowired
    private ViewAppointmentService viewAppointmentService;

    @Operation(summary = "分页查询预约信息")
    @GetMapping("page")
    public Result<IPage<AppointmentVo>> page(@RequestParam long current, @RequestParam long size, AppointmentQueryVo queryVo) {
        IPage<AppointmentVo> page = new Page<>(current, size);
        IPage<AppointmentVo> list = viewAppointmentService.pageAppointmentByQuery(page, queryVo);
        return Result.ok(list);
    }

    @Operation(summary = "根据id更新预约状态")
    @PostMapping("updateStatusById")
    public Result updateStatusById(@RequestParam Long id, @RequestParam AppointmentStatus status) {
        viewAppointmentService.lambdaUpdate()
                .eq(ViewAppointment::getId, id).set(ViewAppointment::getAppointmentStatus, status).update();
        return Result.ok();
    }

}

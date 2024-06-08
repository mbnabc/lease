package com.liurunqing.lease.web.app.vo.attr;

import com.liurunqing.lease.model.entity.AttrKey;
import com.liurunqing.lease.model.entity.AttrValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;


@Data
public class AttrKeyVo extends AttrKey {

    @Schema(description = "属性value列表")
    private List<AttrValue> attrValueList;
}

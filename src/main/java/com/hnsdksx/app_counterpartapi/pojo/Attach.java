package com.hnsdksx.app_counterpartapi.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.Accessors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
@TableName("attach")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Attach {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long school_id;
    private Integer year;
    private String type;
    private Integer plans_number;
    private Integer shift_line;
    private Integer sub_one;
    private Integer sub_two;
    private Integer sub_three;
}

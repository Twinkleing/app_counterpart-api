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
@TableName("score_line")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScoreLine {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Integer year;
    private String type;
    private String code;
    private String name;
    private String nature;
    private Integer plans_number;
    private Integer shift_line;
    private Integer sub_one;
    private Integer sub_two;
    private Integer sub_three;
    private String link;

    public ScoreLine(Integer year, String type, String code, String name, String nature, Integer plans_number, Integer shift_line, Integer sub_one, Integer sub_two, Integer sub_three) {
        this.year = year;
        this.type = type;
        this.code = code;
        this.name = name;
        this.nature = nature;
        this.plans_number = plans_number;
        this.shift_line = shift_line;
        this.sub_one = sub_one;
        this.sub_two = sub_two;
        this.sub_three = sub_three;
    }
}

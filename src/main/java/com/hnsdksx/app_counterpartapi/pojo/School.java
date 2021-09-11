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
@TableName("school")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class School {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String code;
    private String name;
    private String nature;
    private String link;
}

package com.ljt.study.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author LiJingTang
 * @date 2023-04-07 09:41
 */
@Data
@Builder
public class User {

    private Integer id;
    private String name;
    private Integer gender;

}

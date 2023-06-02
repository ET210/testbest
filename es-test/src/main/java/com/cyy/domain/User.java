package com.cyy.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author:CYY
 * @create: 2023-05-23 11:59:30
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private String name;
    private int age;
    private Date birthday;
    private String address;
}

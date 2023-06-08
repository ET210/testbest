package com.cyy.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:CYY
 * @create: 2023-06-05 20:10:53
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto{
    private String name;
    private Integer id;
    private String name1;
    private String name2;
}

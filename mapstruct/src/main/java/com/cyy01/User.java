package com.cyy01;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:CYY
 * @create: 2023-06-29 15:20:11
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private Float number;

/*    @JsonCreator
    public User(@JsonProperty("id") String id, @JsonProperty("name") String name, @JsonProperty("number") String number) {
        this.id = Long.parseLong(id);
        this.name = name;
        this.number=Float.parseFloat(number);
    }*/

    // getters and setters
}

package com.cyy01;

import com.alibaba.fastjson.annotation.JSONField;
import com.sun.istack.internal.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AreaDataVo {
    @NotNull
    @JSONField(name = "AREANAME")
    private String AREANAME;
    @JSONField(name = "AREACODE")
    private String AREACODE;
    @JSONField(name = "RECORDDATE")
    private Long RECORDDATE;
    @JSONField(name = "GOOD_PLAY_RATE")
    private Float GOOD_PLAY_RATE=0.0f;
    @JSONField(name = "GOOD_LIVE_RATE")
    private Float GOOD_LIVE_RATE;
    @JSONField(name = "GOOD_SWTIME_RATE")
    private Float GOOD_SWTIME_RATE;
    @JSONField(name = "LIVE_RATE")
    private Float LIVE_RATE;
    @JSONField(name = "RE_RATE")
    private Float RE_RATE;


}

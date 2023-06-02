package com.cyy.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName itv_main_topo
 */
@TableName(value ="itv_main_topo")
@Data
public class ItvMainTopo implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    @TableField(value = "user_id")
    private String user_id;

    /**
     * 
     */
    @TableField(value = "mac")
    private String mac;

    /**
     * 
     */
    @TableField(value = "device_sn")
    private String device_sn;

    /**
     * 
     */
    @TableField(value = "city_name")
    private String city_name;

    /**
     * 
     */
    @TableField(value = "area_name")
    private String area_name;

    /**
     * 
     */
    @TableField(value = "bras")
    private String bras;

    /**
     * 
     */
    @TableField(value = "bras_ip")
    private String bras_ip;

    /**
     * 
     */
    @TableField(value = "olt")
    private String olt;

    /**
     * 
     */
    @TableField(value = "olt_ip")
    private String olt_ip;

    /**
     * 
     */
    @TableField(value = "pon")
    private String pon;

    /**
     * 
     */
    @TableField(value = "obd_id")
    private String obd_id;

    /**
     * 
     */
    @TableField(value = "loid")
    private String loid;

    /**
     * 
     */
    @TableField(value = "platform")
    private String platform;

    /**
     * 
     */
    @TableField(value = "manufacturer")
    private String manufacturer;

    /**
     * 
     */
    @TableField(value = "manufacturer_model")
    private String manufacturer_model;

    /**
     * 
     */
    @TableField(value = "manufacturer_version")
    private String manufacturer_version;

    /**
     * 
     */
    @TableField(value = "light_cat_manufacturer")
    private String light_cat_manufacturer;

    /**
     * 
     */
    @TableField(value = "light_cat_model")
    private String light_cat_model;

    /**
     * 
     */
    @TableField(value = "light_cat_version")
    private String light_cat_version;

    /**
     * 
     */
    @TableField(value = "user_star_rating")
    private String user_star_rating;

    /**
     * 
     */
    @TableField(value = "light_grouping")
    private String light_grouping;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
package com.aokai.parking.po;

import javax.persistence.*;

@Table(name = "garage")
public class Garage {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 车库名称
     */
    @Column(name = "garage_name")
    private String garageName;

    /**
     * 车库位置
     */
    @Column(name = "garage_location")
    private String garageLocation;

    /**
     * 车库描述
     */
    @Column(name = "garage_description")
    private String garageDescription;

    /**
     * 车位总数
     */
    @Column(name = "garage_total")
    private Integer garageTotal;

    /**
     * 车库编号
     */
    @Column(name = "garage_code")
    private String garageCode;

    /**
     * 价格
     */
    @Column(name = "garage_price")
    private Double garagePrice;

    /**
     * 小时
     */
    @Column(name = "garage_pricetime")
    private Double garagePricetime;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取车库名称
     *
     * @return garage_name - 车库名称
     */
    public String getGarageName() {
        return garageName;
    }

    /**
     * 设置车库名称
     *
     * @param garageName 车库名称
     */
    public void setGarageName(String garageName) {
        this.garageName = garageName == null ? null : garageName.trim();
    }

    /**
     * 获取车库位置
     *
     * @return garage_location - 车库位置
     */
    public String getGarageLocation() {
        return garageLocation;
    }

    /**
     * 设置车库位置
     *
     * @param garageLocation 车库位置
     */
    public void setGarageLocation(String garageLocation) {
        this.garageLocation = garageLocation == null ? null : garageLocation.trim();
    }

    /**
     * 获取车库描述
     *
     * @return garage_description - 车库描述
     */
    public String getGarageDescription() {
        return garageDescription;
    }

    /**
     * 设置车库描述
     *
     * @param garageDescription 车库描述
     */
    public void setGarageDescription(String garageDescription) {
        this.garageDescription = garageDescription == null ? null : garageDescription.trim();
    }

    /**
     * 获取车位总数
     *
     * @return garage_total - 车位总数
     */
    public Integer getGarageTotal() {
        return garageTotal;
    }

    /**
     * 设置车位总数
     *
     * @param garageTotal 车位总数
     */
    public void setGarageTotal(Integer garageTotal) {
        this.garageTotal = garageTotal;
    }

    /**
     * 获取车库编号
     *
     * @return garage_code - 车库编号
     */
    public String getGarageCode() {
        return garageCode;
    }

    /**
     * 设置车库编号
     *
     * @param garageCode 车库编号
     */
    public void setGarageCode(String garageCode) {
        this.garageCode = garageCode == null ? null : garageCode.trim();
    }

    /**
     * 获取价格
     *
     * @return garage_price - 价格
     */
    public Double getGaragePrice() {
        return garagePrice;
    }

    /**
     * 设置价格
     *
     * @param garagePrice 价格
     */
    public void setGaragePrice(Double garagePrice) {
        this.garagePrice = garagePrice;
    }

    /**
     * 获取小时
     *
     * @return garage_pricetime - 小时
     */
    public Double getGaragePricetime() {
        return garagePricetime;
    }

    /**
     * 设置小时
     *
     * @param garagePricetime 小时
     */
    public void setGaragePricetime(Double garagePricetime) {
        this.garagePricetime = garagePricetime;
    }
}
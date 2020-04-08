package com.aokai.parking.po;

import javax.persistence.*;

@Table(name = "car")
public class Car {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 车位名称
     */
    @Column(name = "car_name")
    private String carName;

    /**
     * 车位位置
     */
    @Column(name = "car_location")
    private String carLocation;

    /**
     * 车位状态：0占用、1空闲
     */
    @Column(name = "car_status")
    private Integer carStatus;

    /**
     * 车位类型：小型车和大型车
     */
    @Column(name = "car_type")
    private Integer carType;

    /**
     * 价格
     */
    @Column(name = "car_price")
    private Double carPrice;

    /**
     * 小时
     */
    @Column(name = "car_price_time")
    private Double carPriceTime;

    /**
     * 车库ID名称
     */
    @Column(name = "garage_id")
    private Integer garageId;

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
     * 获取车位名称
     *
     * @return car_name - 车位名称
     */
    public String getCarName() {
        return carName;
    }

    /**
     * 设置车位名称
     *
     * @param carName 车位名称
     */
    public void setCarName(String carName) {
        this.carName = carName == null ? null : carName.trim();
    }

    /**
     * 获取车位位置
     *
     * @return car_location - 车位位置
     */
    public String getCarLocation() {
        return carLocation;
    }

    /**
     * 设置车位位置
     *
     * @param carLocation 车位位置
     */
    public void setCarLocation(String carLocation) {
        this.carLocation = carLocation == null ? null : carLocation.trim();
    }

    /**
     * 获取车位状态：0占用、1空闲
     *
     * @return car_status - 车位状态：0占用、1空闲
     */
    public Integer getCarStatus() {
        return carStatus;
    }

    /**
     * 设置车位状态：0占用、1空闲
     *
     * @param carStatus 车位状态：0占用、1空闲
     */
    public void setCarStatus(Integer carStatus) {
        this.carStatus = carStatus;
    }

    /**
     * 获取车位类型：小型车和大型车
     *
     * @return car_type - 车位类型：小型车和大型车
     */
    public Integer getCarType() {
        return carType;
    }

    /**
     * 设置车位类型：小型车和大型车
     *
     * @param carType 车位类型：小型车和大型车
     */
    public void setCarType(Integer carType) {
        this.carType = carType;
    }

    /**
     * 获取价格
     *
     * @return car_price - 价格
     */
    public Double getCarPrice() {
        return carPrice;
    }

    /**
     * 设置价格
     *
     * @param carPrice 价格
     */
    public void setCarPrice(Double carPrice) {
        this.carPrice = carPrice;
    }

    /**
     * 获取小时
     *
     * @return car_price_time - 小时
     */
    public Double getCarPriceTime() {
        return carPriceTime;
    }

    /**
     * 设置小时
     *
     * @param carPriceTime 小时
     */
    public void setCarPriceTime(Double carPriceTime) {
        this.carPriceTime = carPriceTime;
    }

    /**
     * 获取车库ID名称
     *
     * @return garage_id - 车库ID名称
     */
    public Integer getGarageId() {
        return garageId;
    }

    /**
     * 设置车库ID名称
     *
     * @param garageId 车库ID名称
     */
    public void setGarageId(Integer garageId) {
        this.garageId = garageId;
    }
}
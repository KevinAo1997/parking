package com.aokai.parking.po;

import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.*;

@Table(name = "order")
public class Order {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 省份
     */
    private String province;

    /**
     * 车牌号
     */
    @Column(name = "carNumber")
    private String carnumber;

    /**
     * 客户姓名
     */
    @Column(name = "customerName")
    private String customername;

    /**
     * 客户号码
     */
    @Column(name = "customerPhone")
    private String customerphone;

    /**
     * 开始时间
     */
    @Column(name = "startTime")
    private LocalDateTime starttime;

    /**
     * 结束时间
     */
    @Column(name = "endTime")
    private LocalDateTime endtime;

    /**
     * 花费
     */
    private Double cost;

    /**
     * 停用时长
     */
    private Double time;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 车库ID
     */
    @Column(name = "garage_id")
    private Integer garageId;

    /**
     * 车位ID
     */
    @Column(name = "car_id")
    private Integer carId;

    /**
     * 员工ID
     */
    @Column(name = "user_id")
    private Integer userId;

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
     * 获取省份
     *
     * @return province - 省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省份
     *
     * @param province 省份
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * 获取车牌号
     *
     * @return carNumber - 车牌号
     */
    public String getCarnumber() {
        return carnumber;
    }

    /**
     * 设置车牌号
     *
     * @param carnumber 车牌号
     */
    public void setCarnumber(String carnumber) {
        this.carnumber = carnumber == null ? null : carnumber.trim();
    }

    /**
     * 获取客户姓名
     *
     * @return customerName - 客户姓名
     */
    public String getCustomername() {
        return customername;
    }

    /**
     * 设置客户姓名
     *
     * @param customername 客户姓名
     */
    public void setCustomername(String customername) {
        this.customername = customername == null ? null : customername.trim();
    }

    /**
     * 获取客户号码
     *
     * @return customerPhone - 客户号码
     */
    public String getCustomerphone() {
        return customerphone;
    }

    /**
     * 设置客户号码
     *
     * @param customerphone 客户号码
     */
    public void setCustomerphone(String customerphone) {
        this.customerphone = customerphone == null ? null : customerphone.trim();
    }

    /**
     * 获取开始时间
     *
     * @return startTime - 开始时间
     */
    public LocalDateTime getStarttime() {
        return starttime;
    }

    /**
     * 设置开始时间
     *
     * @param starttime 开始时间
     */
    public void setStarttime(LocalDateTime starttime) {
        this.starttime = starttime;
    }

    /**
     * 获取结束时间
     *
     * @return endTime - 结束时间
     */
    public LocalDateTime getEndtime() {
        return endtime;
    }

    /**
     * 设置结束时间
     *
     * @param endtime 结束时间
     */
    public void setEndtime(LocalDateTime endtime) {
        this.endtime = endtime;
    }

    /**
     * 获取花费
     *
     * @return cost - 花费
     */
    public Double getCost() {
        return cost;
    }

    /**
     * 设置花费
     *
     * @param cost 花费
     */
    public void setCost(Double cost) {
        this.cost = cost;
    }

    /**
     * 获取停用时长
     *
     * @return time - 停用时长
     */
    public Double getTime() {
        return time;
    }

    /**
     * 设置停用时长
     *
     * @param time 停用时长
     */
    public void setTime(Double time) {
        this.time = time;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取车库ID
     *
     * @return garage_id - 车库ID
     */
    public Integer getGarageId() {
        return garageId;
    }

    /**
     * 设置车库ID
     *
     * @param garageId 车库ID
     */
    public void setGarageId(Integer garageId) {
        this.garageId = garageId;
    }

    /**
     * 获取车位ID
     *
     * @return car_id - 车位ID
     */
    public Integer getCarId() {
        return carId;
    }

    /**
     * 设置车位ID
     *
     * @param carId 车位ID
     */
    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    /**
     * 获取员工ID
     *
     * @return user_id - 员工ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置员工ID
     *
     * @param userId 员工ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}

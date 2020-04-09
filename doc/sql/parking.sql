
CREATE TABLE `car` (
  `id` int(11) NOT NULL AUTO_INCREMENT comment '主键',
  `car_name` varchar(25) DEFAULT NULL comment '车位名称',
  `car_location` varchar(255) DEFAULT NULL comment '车位位置',
  `car_status` int(11) DEFAULT NULL comment '车位状态：0占用、1空闲',
  `car_type` int(11) DEFAULT NULL comment '车位类型：小型车和大型车',
  `car_price` double(10,2) DEFAULT NULL comment '价格',
  `car_price_time` double(10,2) DEFAULT NULL comment '小时',
  `garage_id` int(11) DEFAULT NULL comment '车库ID名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '停车位配置表';


CREATE TABLE `garage` (
  `id` int(11) NOT NULL AUTO_INCREMENT comment '主键',
  `garage_name` varchar(25) DEFAULT NULL comment '车库名称',
  `garage_location` varchar(255) DEFAULT NULL comment '车库位置',
  `garage_description` varchar(255) DEFAULT NULL comment '车库描述',
  `garage_total` int(11) DEFAULT NULL comment '车位总数',
  `garage_code` varchar(25) NOT NULL comment '车库编号',
  `garage_price` double(10,2) DEFAULT NULL comment '价格',
  `garage_pricetime` double(10,2) DEFAULT NULL comment '小时',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT '车库配置表';


CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT comment'主键',
  `province` varchar(25) NOT NULL comment'省份',
  `carNumber` varchar(25) NOT NULL comment'车牌号',
  `customerName` varchar(25) DEFAULT NULL comment'客户姓名',
  `customerPhone` varchar(25) DEFAULT NULL comment'客户号码',
  `startTime` datetime DEFAULT NULL comment'开始时间',
  `endTime` datetime DEFAULT NULL comment'结束时间',
  `cost` double(10,2) DEFAULT NULL comment'花费',
  `time` double(10,2) DEFAULT NULL comment'停用时长',
  `status` int(11) DEFAULT NULL comment'状态',
  `garage_id` int(11) DEFAULT NULL comment'车库ID',
  `car_id` int(11) DEFAULT NULL comment'车位ID',
  `user_id` int(11) DEFAULT NULL comment'员工ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT '车辆订单表';

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT comment'主键',
  `code` varchar(20) NOT NULL comment'工号',
  `username` varchar(20) NOT NULL comment'账号',
  `password` varchar(50) NOT NULL comment'密码',
  `name` varchar(20) NOT NULL comment'名称',
  `sex` int(11) NOT NULL comment'性别',
  `email` varchar(30) DEFAULT NULL comment'邮箱',
  `phone` varchar(20) NOT NULL comment'电话',
  `headImg` varchar(100) DEFAULT NULL comment'头像',
  `description` varchar(100) DEFAULT NULL comment'签名描述',
  `status` int(11) NOT NULL comment'状态：0禁用、1启用',
  `type` int(11) NOT NULL comment'员工类型：0管理员、1普通员工',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户表';

CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT comment'主键',
  `title` varchar(255) NOT NULL comment'标题',
  `content` text comment'内容',
  `creatTime` datetime DEFAULT NULL comment'创建时间',
  `user_id` int(11) DEFAULT NULL comment'用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '公告配置表';

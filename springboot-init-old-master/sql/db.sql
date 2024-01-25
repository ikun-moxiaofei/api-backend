use api_db;
-- 接口信息
create table if not exists api_db.`interface_info`
(
    `id` bigint not null auto_increment comment '主键' primary key,
    `name` varchar(256) not null comment '名称',
    `description` varchar(256) not null comment '接口描述',
    `url` varchar(512) not null comment '接口地址',
    'requestParams' text not null comment '请求参数',
    `requestHeader` text null comment '请求头',
    `respondHeader` text null comment '响应头',
    `status` int default 0 not null comment '接口状态（0关闭，1开启）',
    `useId` bigint not null comment '创建人',
    `method` varchar(256) not null comment '请求类型',
    `createTime` datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    `updateTime` datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    `isDeleted` tinyint default 0 not null comment '是否删除(0-未删, 1-已删)'
    ) comment '接口信息';

insert into api_db.`interface_info` (`name`, `description`, `url`, `requestHeader`, `respondHeader`, `status`, `useId`, `method`) values ('韦子涵', '邱熠彤', 'www.gilberte-berge.io', '许鑫鹏', '秦钰轩', 0, 41246916, '梁烨伟');
insert into api_db.`interface_info` (`name`, `description`, `url`, `requestHeader`, `respondHeader`, `status`, `useId`, `method`) values ('郝懿轩', '侯哲瀚', 'www.bobbie-hessel.com', '侯伟泽', '田峻熙', 0, 241, '孔伟宸');
insert into api_db.`interface_info` (`name`, `description`, `url`, `requestHeader`, `respondHeader`, `status`, `useId`, `method`) values ('蒋晟睿', '方笑愚', 'www.blythe-kovacek.io', '薛炎彬', '谭浩', 0, 5, '何越泽');
insert into api_db.`interface_info` (`name`, `description`, `url`, `requestHeader`, `respondHeader`, `status`, `useId`, `method`) values ('郭鹏煊', '陆聪健', 'www.margarito-dare.co', '余嘉懿', '史博涛', 0, 831196929, '苏雨泽');
insert into api_db.`interface_info` (`name`, `description`, `url`, `requestHeader`, `respondHeader`, `status`, `useId`, `method`) values ('尹涛', '杨烨霖', 'www.lance-kshlerin.biz', '郭炫明', '刘熠彤', 0, 59328, '潘弘文');
insert into api_db.`interface_info` (`name`, `description`, `url`, `requestHeader`, `respondHeader`, `status`, `useId`, `method`) values ('武鹏', '孟展鹏', 'www.darci-moore.info', '孙烨霖', '徐鸿煊', 0, 195, '萧越彬');
insert into api_db.`interface_info` (`name`, `description`, `url`, `requestHeader`, `respondHeader`, `status`, `useId`, `method`) values ('贺鸿煊', '何思远', 'www.wilburn-heller.biz', '田炫明', '潘峻熙', 0, 90, '薛峻熙');
insert into api_db.`interface_info` (`name`, `description`, `url`, `requestHeader`, `respondHeader`, `status`, `useId`, `method`) values ('傅思远', '余锦程', 'www.richie-kautzer.io', '何昊焱', '龙天宇', 0, 182964, '黄智渊');
insert into api_db.`interface_info` (`name`, `description`, `url`, `requestHeader`, `respondHeader`, `status`, `useId`, `method`) values ('吴浩', '周风华', 'www.alonzo-schuster.biz', '魏炎彬', '石擎宇', 0, 58, '邵正豪');
insert into api_db.`interface_info` (`name`, `description`, `url`, `requestHeader`, `respondHeader`, `status`, `useId`, `method`) values ('白乐驹', '郑智辉', 'www.samatha-kunde.biz', '周风华', '邵炫明', 0, 98, '萧博文');
insert into api_db.`interface_info` (`name`, `description`, `url`, `requestHeader`, `respondHeader`, `status`, `useId`, `method`) values ('于子默', '龙伟泽', 'www.tim-gibson.org', '朱浩', '陈绍齐', 0, 7381085755, '韦烨伟');
insert into api_db.`interface_info` (`name`, `description`, `url`, `requestHeader`, `respondHeader`, `status`, `useId`, `method`) values ('梁嘉懿', '马驰', 'www.dania-jones.io', '曾涛', '孟子轩', 0, 6223186, '蔡君浩');
insert into api_db.`interface_info` (`name`, `description`, `url`, `requestHeader`, `respondHeader`, `status`, `useId`, `method`) values ('苏立轩', '朱雨泽', 'www.alethia-bailey.name', '潘晓博', '王弘文', 0, 646877, '萧语堂');
insert into api_db.`interface_info` (`name`, `description`, `url`, `requestHeader`, `respondHeader`, `status`, `useId`, `method`) values ('侯梓晨', '万梓晨', 'www.my-brekke.org', '钱果', '冯峻熙', 0, 1510, '姜擎苍');
insert into api_db.`interface_info` (`name`, `description`, `url`, `requestHeader`, `respondHeader`, `status`, `useId`, `method`) values ('熊金鑫', '方子轩', 'www.theron-schiller.net', '孟建辉', '傅聪健', 0, 1, '曾思');
insert into api_db.`interface_info` (`name`, `description`, `url`, `requestHeader`, `respondHeader`, `status`, `useId`, `method`) values ('沈鑫磊', '莫立果', 'www.dwayne-skiles.com', '段正豪', '孟志泽', 0, 3674237009, '钟鹏');
insert into api_db.`interface_info` (`name`, `description`, `url`, `requestHeader`, `respondHeader`, `status`, `useId`, `method`) values ('钟峻熙', '薛金鑫', 'www.thanh-macgyver.net', '姚烨霖', '陆君浩', 0, 914, '徐子骞');
insert into api_db.`interface_info` (`name`, `description`, `url`, `requestHeader`, `respondHeader`, `status`, `useId`, `method`) values ('孟博文', '孙鹤轩', 'www.rosalina-vonrueden.io', '汪果', '万煜祺', 0, 394, '邹立果');
insert into api_db.`interface_info` (`name`, `description`, `url`, `requestHeader`, `respondHeader`, `status`, `useId`, `method`) values ('戴伟宸', '金风华', 'www.josh-orn.net', '蔡浩宇', '苏伟泽', 0, 6777511, '金琪');
insert into api_db.`interface_info` (`name`, `description`, `url`, `requestHeader`, `respondHeader`, `status`, `useId`, `method`) values ('夏擎苍', '王峻熙', 'www.thad-champlin.info', '唐致远', '白擎苍', 0, 76647, '崔晓啸');




-- 用户调用接口关系表
create table if not exists api_db.`user_interface_info`
(
    `id` bigint not null auto_increment comment '主键' primary key,
    `userId` bigint not null comment '调用用户 id',
    `interfaceInfoId` bigint not null comment '接口 id',
    `totalNum` int default 0 not null comment '总调用次数',
    `leftNum` int default 0 not null comment '剩余调用次数',
    `status` int default 0 not null comment '0-正常，1-禁用',
    `createTime` datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    `updateTime` datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    `isDelete` tinyint default 0 not null comment '是否删除(0-未删, 1-已删)'
) comment '用户调用接口关系';
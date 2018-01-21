create table secured_resource (
	resource_id varchar(10) not null comment '리소스 ID'
	,resource_name varchar(50) null comment '리소스 이름'
	,resource_pattern varchar(100) null
	,resource_type varchar(10) null comment '리소스 타입(url:URL, method:Method)'
	,sort_order int null comment '순서'
	,PRIMARY KEY (resource_id)
);

create table secured_resource_authority (
	resource_id varchar(10) not null comment '리소스ID'
	,authority varchar(50) null comment '권한 코드'
	,name varchar(30) null comment '회원 이름'
	,constraint `fk_resource_id` FOREIGN KEY (`resource_id`) REFERENCES secured_resource(resource_id)
);
	

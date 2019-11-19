#MySQL执行记录
SHOW VARIABLES LIKE 'general%';
set GLOBAL general_log='ON';

SHOW VARIABLES LIKE 'general_log';
tail -f /var/lib/mysql/bogon.log


# 数据库
drop database if exists netchk;
create database if not exists netchk default character set utf8 collate utf8_general_ci;

# 用户表
drop table if exists netchk.t_user;
create table if not exists netchk.t_user
(
    uuid bigint unsigned not null auto_increment primary key,
    username varchar(256) not null,
    password char(64) not null comment 'Hashed by SHA256'
)engine=innodb default charset=utf8;
create index index_uuid on netchk.t_user(uuid);
describe netchk.t_user;

insert into netchk.t_user (username, password) values ("admin", "8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918");
insert into netchk.t_user (username, password) values ("auditor", "ee79976c9380d5e337fc1c095ece8c8f22f91f306ceeb161fa51fecede2c4ba1");
insert into netchk.t_user (username, password) values ("operator", "ee79976c9380d5e337fc1c095ece8c8f22f91f306ceeb161fa51fecede2c4ba1");
insert into netchk.t_user (username, password) values ("operator1", "ee79976c9380d5e337fc1c095ece8c8f22f91f306ceeb161fa51fecede2c4ba1");
insert into netchk.t_user (username, password) values ("operator2", "ee79976c9380d5e337fc1c095ece8c8f22f91f306ceeb161fa51fecede2c4ba1");

select netchk.t_user.* from netchk.t_user where username = 'admin';
select count(netchk.t_user.uuid) from netchk.t_user where username = 'admin';

select netchk.t_user.* from netchk.t_user where username like 'operator%';
select count(netchk.t_user.uuid) from netchk.t_user where username like 'operator%';

# (10, 15]
select * from t_audit_log limit 10, 5;
select * from t_audit_log limit 5 offset 10;

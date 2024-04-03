create table if not exists `user`
(
    id           char(19)    not null primary key,
    name         char(10)    not null,
    account      varchar(20) not null,
    password     varchar(20) not null,
    role         tinyint     not null comment '角色: 1.教师 2.学生 5.管理员',
    group_number smallint    null,
    student      json        null comment '{"teacherId", "teacherName", "grade", "projectTitle"}',#老师id,老师姓名,年级排名,项目名
    teacher      json        null comment '{"count"}',#所带学生数
    insert_time  datetime    not null default current_timestamp,
    update_time  datetime    not null default current_timestamp on update current_timestamp,

    unique (account),
    index (role, group_number),
    index ((cast(student ->> '$.teacherId' as char(19)) collate utf8mb4_bin))
) comment '用户表';

create table if not exists `process`
(
    id          char(19)    not null primary key,
    name        varchar(20) not null,
    items       json        null comment '[{"number", "name", "point"}]',#子项号,子项名,子项占比
    update_time datetime default current_timestamp on update current_timestamp,
    create_time datetime default current_timestamp
) comment '过程表';

create table if not exists `process_score`
(
    id          char(19) not null primary key,
    student_id  char(19) not null,
    process_id  char(19) not null,
    teacher_id  char(19) not null,
    detail      json     not null comment '{"teacherName", "score", detail: [{"number", "score"}]}',#老师id,总成绩,子项号及成绩
    update_time datetime default current_timestamp on update current_timestamp comment '修改时间',
    create_time datetime default current_timestamp comment '创建时间',

    unique (process_id, student_id, teacher_id)
) comment '过程项表';

INSERT INTO `user` (`name`, `account`, `password`, `role`, `group_number`, `student`)
VALUES ('张三', 'zhangsan123', 'password123', 2, 1, '{
  "teacherId": "1",
  "teacherName": "李老师",
  "grade": "1",
  "projectTitle": "we"
}'),
       ('李四', 'lisi456', 'pass456', 2, 1, '{
         "teacherId": "1",
         "teacherName": "李老师",
         "grade": "10",
         "projectTitle": "awfe"
       }'),
       ('王五', 'wangwu789', 'pwd789', 2, 1, '{
         "teacherId": "1",
         "teacherName": "李老师",
         "grade": "11",
         "projectTitle": "awef"
       }'),
       ('赵六', 'zhaoliu999', 'abc123', 2, 1, '{
         "teacherId": "1",
         "teacherName": "李老师",
         "grade": "20",
         "projectTitle": "fe"
       }'),
       ('小明', 'xiaoming111', 'test123', 2, 1, '{
         "teacherId": "2",
         "teacherName": "王老师",
         "grade": "2",
         "projectTitle": "hr"
       }'),
       ('小红', 'xiaohong222', 'passpass', 2, 2, '{
         "teacherId": "2",
         "teacherName": "王老师",
         "grade": "9",
         "projectTitle": "we"
       }'),
       ('张飞', 'zhangfei333', '123456', 2, 2, '{
         "teacherId": "2",
         "teacherName": "王老师",
         "grade": "12",
         "projectTitle": "qw"
       }'),
       ('关羽', 'guanyu444', 'abcdef', 2, 2, '{
         "teacherId": "2",
         "teacherName": "王老师",
         "grade": "19",
         "projectTitle": "et"
       }'),
       ('刘备', 'liubei555', 'testpass', 2, 2, '{
         "teacherId": "3",
         "teacherName": "赵老师",
         "grade": "3",
         "projectTitle": "wef"
       }'),
       ('孙权', 'sunquan666', 'sun123', 2, 2, '{
         "teacherId": "3",
         "teacherName": "赵老师",
         "grade": "8",
         "projectTitle": "qwd"
       }'),
       ('周瑜', 'zhouyu777', 'pwd456', 2, 3, '{
         "teacherId": "3",
         "teacherName": "赵老师",
         "grade": "13",
         "projectTitle": "fe"
       }'),
       ('黄盖', 'huanggai888', '987654', 2, 3, '{
         "teacherId": "3",
         "teacherName": "赵老师",
         "grade": "18",
         "projectTitle": "qwd"
       }'),
       ('曹操', 'caocao999', 'cc123456', 2, 3, '{
         "teacherId": "4",
         "teacherName": "季老师",
         "grade": "4",
         "projectTitle": "gwe"
       }'),
       ('司马懿', 'simayi111', 'pass789', 2, 3, '{
         "teacherId": "4",
         "teacherName": "季老师",
         "grade": "7",
         "projectTitle": "qwf"
       }'),
       ('诸葛亮', 'zhugeliang222', 'testpwd', 2, 3, '{
         "teacherId": "4",
         "teacherName": "季老师",
         "grade": "14",
         "projectTitle": "qwd"
       }'),
       ('孙尚香', 'sunshangxiang333', 'abcabc', 2, 4, '{
         "teacherId": "4",
         "teacherName": "季老师",
         "grade": "17",
         "projectTitle": "qf"
       }'),
       ('大乔', 'daqiao444', 'pwd123', 2, 4, '{
         "teacherId": "5",
         "teacherName": "崔老师",
         "grade": "5",
         "projectTitle": "qwf"
       }'),
       ('周瑜', 'zhouyu555', 'passpass', 2, 4, '{
         "teacherId": "5",
         "teacherName": "崔老师",
         "grade": "6",
         "projectTitle": "wrg"
       }'),
       ('小乔', 'xiaoqiao666', '123abc', 2, 4, '{
         "teacherId": "5",
         "teacherName": "崔老师",
         "grade": "15",
         "projectTitle": "weg"
       }'),
       ('孙权', 'sunquan777', 'sun123', 2, 4, '{
         "teacherId": "5",
         "teacherName": "崔老师",
         "grade": "16",
         "projectTitle": "qwd"
       }');
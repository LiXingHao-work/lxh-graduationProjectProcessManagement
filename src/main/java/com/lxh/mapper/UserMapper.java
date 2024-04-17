package com.lxh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lxh.pojo.dox.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDateTime;
import java.util.List;


@Mapper

public interface UserMapper extends BaseMapper<User> {

//    @Update("""
//            update user u set u.teacher=json_set(u.teacher, '$.count', cast(u.teacher ->> '$.count' + 1 as unsigned))
//            where id=:tid and (u.teacher ->> '$.total' - u.teacher ->> '$.count' > 0);
//            """)
//    int updateCount(String tid);

    @Select("select u.description from user u where u.role = 10")
    LocalDateTime findStartTime();
}

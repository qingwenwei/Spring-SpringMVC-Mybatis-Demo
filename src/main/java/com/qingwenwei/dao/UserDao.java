package com.qingwenwei.dao;

import com.qingwenwei.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public interface UserDao {

    @Select("SELECT id, userName, firstName, lastName, yearBorn, email, phone, address FROM T_USER")
    List<User> getAll();

    @Select("SELECT id, userName, firstName, lastName, yearBorn, email, phone, address FROM T_USER WHERE id = #{id}")
    User findById(Long id);

    @Select("SELECT id, userName, firstName, lastName, yearBorn, email, phone, address FROM T_USER WHERE userName = #{userName}")
    User findByUserName(String userName);

    @Update("UPDATE T_USER SET firstName = #{firstName}, lastName = #{lastName}, yearBorn = #{yearBorn}, email = #{email}, " +
            "phone = #{phone}, address = #{address} WHERE userName = #{userName}")
    int update(User user);

    @Insert("INSERT INTO T_USER (userName, firstName, lastName, yearBorn, email, phone, address)" +
            "VALUES (#{userName}, #{firstName}, #{lastName}, #{yearBorn}, #{email}, #{phone}, #{address})")
    int create(User user);

    @Delete("DELETE FROM T_USER WHERE userName = #{userName}")
    int delete(User user);
}

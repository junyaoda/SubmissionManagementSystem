package com.example.demo.repository;

import com.example.demo.dto.UserSearchRequest;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
	@Select("SELECT * FROM user WHERE name = #{name} and password = #{password}")
	User search(UserSearchRequest user);
}


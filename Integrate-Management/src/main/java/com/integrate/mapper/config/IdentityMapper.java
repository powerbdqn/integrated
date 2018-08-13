package com.integrate.mapper.config;

import java.util.List;

import com.integrate.pojo.config.Identity;

public interface IdentityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Identity record);

    int insertSelective(Identity record);

    Identity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Identity record);

    int updateByPrimaryKey(Identity record);

	List<Identity> listIdentity();
}
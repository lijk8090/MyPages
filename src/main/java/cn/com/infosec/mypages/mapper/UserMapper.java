package cn.com.infosec.mypages.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.com.infosec.mypages.entity.PageEntity;
import cn.com.infosec.mypages.entity.UserEntity;

@Mapper
public interface UserMapper {

	int selectUserCountByUsername(@Param("username") String username);

	List<UserEntity> selectUserEntityByUsername(@Param("userEntity") UserEntity userEntity,
			@Param("pageEntity") PageEntity<UserEntity> pageEntity);

}

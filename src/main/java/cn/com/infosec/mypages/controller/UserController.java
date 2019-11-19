package cn.com.infosec.mypages.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.infosec.mypages.entity.PageEntity;
import cn.com.infosec.mypages.entity.UserEntity;
import cn.com.infosec.mypages.mapper.UserMapper;

@RestController
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserMapper userMapper;

	@RequestMapping("getUsers.do")
	public PageEntity<UserEntity> getUsersController(@RequestParam(value = "username") String username,
			@RequestParam(value = "pageNumber") int pageNumber, @RequestParam(value = "pageSize") int pageSize,
			ModelMap modelMap) {

		UserEntity userEntity = new UserEntity();
		PageEntity<UserEntity> pageEntity = new PageEntity<UserEntity>();

		int totalNO;
		List<UserEntity> data = new ArrayList<UserEntity>();

		logger.info("username: " + username);
		logger.info("pageNumber: " + pageNumber);
		logger.info("pageSize: " + pageSize);

		userEntity.setUsername(username);
		pageEntity.setPageNO(pageNumber);
		pageEntity.setPageSize(pageSize);

		totalNO = userMapper.selectUserCountByUsername(username);
		data = userMapper.selectUserEntityByUsername(userEntity, pageEntity);

		logger.info("totalNO: " + totalNO);

		pageEntity.setTotalNO(totalNO);
		pageEntity.setData(data);
//		modelMap.addAttribute("pageEntity", pageEntity);

		System.out.println(pageEntity);
		return pageEntity;
	}

}

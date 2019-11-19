package cn.com.infosec.mypages.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuListController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/")
	public String indexController(ModelMap modelMap) {

		logger.info("mypages: /WEB-INF/jsp/mypages.jsp");
		return "mypages";
	}
}

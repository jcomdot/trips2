package com.jcomdot.trips2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class HelloWorldController {
	
	@RequestMapping(value = "/helloworld.html", method = RequestMethod.GET)
	
	public ModelAndView hello() {
		Map<String, Object> model = new HashMap<String, Object>();
		String msgBody = "<p>Hello, Spring-MVC World. 만세!</p>";
		msgBody += "<p>おはよう御座います。(^^)</p>";
		model.put("message", msgBody);
		Logger logger = LoggerFactory.getLogger(this.getClass());
		logger.trace("우트레이스트레이스트레이스트레이스트레이스트레이스");
		logger.debug("우디벅디벅디벅디벅디벅디벅디벅디벅디벅디벅디벅디벅");
		logger.info("우인포인포인포인포인포인포인포인포인포인포인포인포");
		logger.warn("우워닝워닝워닝워닝워닝워닝워닝워닝워닝워닝워닝워닝");
		logger.error("우에러에러에러에러에러에러에러에러에러에러에러에러");
		
		return new ModelAndView("index", model);
	}

}

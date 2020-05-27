package com.qs.tst.swg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller //---> return ModelAndView.
//@ResponseBody --- won't work with the view technology, so cannot return ModelAndView.
public class SwaggerRedirect {
	private static final Logger logger = LoggerFactory.getLogger(SwaggerRedirect.class);
	
	@Autowired
	SwaggerConfig myconfig;

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String sindex() {
		logger.info("test config mykey01: {}", myconfig.getMykey01());
		logger.info("redirect:swagger-ui.html");
		return "redirect:swagger-ui.html";
	}
}

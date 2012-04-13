package br.com.abril.rino.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cygnus")
public class CygnusController {
    //get log4j handler
	private static final Logger logger = Logger.getLogger(CygnusController.class);
	
	@RequestMapping(value="/{name}", method = RequestMethod.GET)
	public String getMovie(@PathVariable String name, ModelMap model) {

		model.addAttribute("name", name);
		
		//log it via log4j
		if(logger.isDebugEnabled()){
			logger.debug(model);
		}
		
		return "list";

	}
	
}
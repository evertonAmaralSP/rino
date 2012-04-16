package br.com.abril.rino.controller;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cygnus")
public class CygnusController {
	
	@Autowired AmqpTemplate amqpTemplate;
	
	//get log4j handler
	private static final Logger logger = Logger.getLogger(CygnusController.class);
	
	@RequestMapping(value="/{name}", method = RequestMethod.GET)
	public String getMovie(@PathVariable String name, ModelMap model) {

		model.addAttribute("name", name);
		 amqpTemplate.convertAndSend("hipo.queue", name);
		//log it via log4j
		if(logger.isDebugEnabled()){
			logger.debug(model);
		}
		
		return "list";

	}
	
	@RequestMapping(value="cosumidor", method = RequestMethod.GET)
	public String getMovie(ModelMap model) {

		model.addAttribute("name", " COSUMIDOR "+ (String)amqpTemplate.receiveAndConvert("hipo.queue"));
		
		return "list";

	}
	
}
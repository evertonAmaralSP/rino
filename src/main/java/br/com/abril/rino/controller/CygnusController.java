package br.com.abril.rino.controller;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.document.mongodb.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.abril.rino.model.Cygnus;
import br.com.abril.rino.model.Message;

import com.google.gson.Gson;

@Controller
@RequestMapping("/cygnus")
public class CygnusController {
	
	@Autowired AmqpTemplate amqpTemplate;
	@Autowired MongoOperations mongoOperation;
	@Autowired Gson gson;
	
	//get log4j handler
	private static final Logger logger = Logger.getLogger(CygnusController.class);
	
	@RequestMapping(value="/{categoria}/{action}/{label}", method = RequestMethod.GET)
	public String getMovie(@ModelAttribute("cygnus") Cygnus cygnus, @PathVariable String categoria,@PathVariable String action,@PathVariable String label, ModelMap model) {
		
		Message obj = new Message(categoria, action, label,cygnus);  
		String json = gson.toJson(obj);
		model.addAttribute("json", json);
        amqpTemplate.convertAndSend("hipo.queue", json);
		//log it via log4j
		if(logger.isDebugEnabled()){
			logger.debug(model);
		}
		
		return "list";

	}
}
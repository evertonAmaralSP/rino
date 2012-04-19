package br.com.abril.rino.controller;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.document.mongodb.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

import br.com.abril.rino.model.Message;

@Controller
@RequestMapping("/cygnus")
public class CygnusController {
	
	@Autowired AmqpTemplate amqpTemplate;
	@Autowired MongoOperations mongoOperation;
	@Autowired Gson gson;
	
	//get log4j handler
	private static final Logger logger = Logger.getLogger(CygnusController.class);
	
	@RequestMapping(value="/{categoria}/{action}/{label}", method = RequestMethod.GET)
	public String getMovie(@PathVariable String categoria,@PathVariable String action,@PathVariable String label, ModelMap model) {

		model.addAttribute("nome", categoria);
		
		Message obj = new Message(categoria, action, label);  
//		String json = categoria;
		String json = gson.toJson(obj);
        amqpTemplate.convertAndSend("hipo.queue", json);
		 
		//log it via log4j
		if(logger.isDebugEnabled()){
			logger.debug(model);
		}
		
		return "list";

	}
	
	@RequestMapping(value="cosumidor", method = RequestMethod.GET)
	public String getMovie(ModelMap model) {

		String receive = (String)amqpTemplate.receiveAndConvert("hipo.queue");
		model.addAttribute("name", " COSUMIDOR "+ receive);
		Message msg = gson.fromJson(receive, Message.class);
        
        //save
        mongoOperation.save("profile",msg);
        
		return "list";

	}
	
}
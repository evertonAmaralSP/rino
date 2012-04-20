package br.com.abril.rino.controller;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.document.mongodb.MongoOperations;
import org.springframework.data.document.mongodb.query.Criteria;
import org.springframework.data.document.mongodb.query.Query;
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

		
		Message obj = new Message(categoria, action, label);  
		String json = gson.toJson(obj);
		model.addAttribute("json", json);
        amqpTemplate.convertAndSend("hipo.queue", json);
		 
		//log it via log4j
		if(logger.isDebugEnabled()){
			logger.debug(model);
		}
		
		return "list";

	}
	
	@RequestMapping(value="consumidor", method = RequestMethod.GET)
	public String getMovie(ModelMap model) {

		String receive = (String)amqpTemplate.receiveAndConvert("hipo.queue");
		Message msg = gson.fromJson(receive, Message.class);
        
        //save
        mongoOperation.save("cliente",msg);
        
        Message msg2 = mongoOperation.findOne("cliente",
        		new Query(Criteria.where("categoria").is("everton")),
        		Message.class);
        model.addAttribute("json", " mongo ="+ msg2);
		return "list";

	}
	
}
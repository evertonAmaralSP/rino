package br.com.abril.rino.job;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.document.mongodb.MongoOperations;
import org.springframework.stereotype.Component;

import br.com.abril.rino.model.Message;

import com.google.gson.Gson;


@Component("consumerWorker")
public class ConsumerWorker implements Worker {

	protected static Logger logger = Logger.getLogger("ConsumerWorker");
	@Autowired AmqpTemplate amqpTemplate;
	@Autowired Queue queue;
	 
	@Autowired MongoOperations mongoOperation;
	@Autowired Gson gson;

	public void work() {
		boolean isConsumer = true;
		while(isConsumer) {
			String receive = (String)amqpTemplate.receiveAndConvert("hipo.queue");
			if (receive!=null) {
				Message msg = gson.fromJson(receive, Message.class);
				mongoOperation.save("cliente",msg);
				logger.debug("Json: "+receive +" - nome da fila: " +queue.getName());
			} else {
				isConsumer = false;
			}
		}
	}
}

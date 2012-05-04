package br.com.abril.rino.job;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulerService {

	protected static Logger logger = Logger.getLogger("SchedulerService");

	@Autowired
	@Qualifier("consumerWorker")
	private ConsumerWorker consumerWorker;

	@Scheduled(cron = "10 * * * * ?")
	public void doSchedule() {
		logger.debug("Start schedule");
		consumerWorker.work();
		logger.debug("End schedule");
	}

}

package com.jdc.upload;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.jdc.upload.entity.Summary;

@Stateless
@LocalBean
public class SummaryService {
	
	@Resource
	private TimerService timerService;
	
	@PersistenceContext
	private EntityManager em;
	
	@Named
	@Produces
	public List<Summary> getSummaryList() {
		return em.createQuery("select s from Summary s", Summary.class).getResultList();
	}

	public void createTimer() {
		timerService.createSingleActionTimer(60 * 1000, new TimerConfig(LocalDateTime.now(), false));
	}
	
	@Timeout
	public void createSummary(Timer timer) {
		LocalDateTime time = (LocalDateTime) timer.getInfo();
		System.out.println("Timer Creation : " + time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
	
		TypedQuery<Summary> query = em.createNamedQuery("Purchase.getSummary", Summary.class);

		List<Summary> list = query.getResultList();
		
		for(Summary s : list) {
			em.merge(s);
		}
	}

}

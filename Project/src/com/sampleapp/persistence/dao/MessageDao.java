package com.sampleapp.persistence.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sampleapp.persistence.entity.Message;

@Repository
public class MessageDao {

	private SessionFactory sessionFactory;
	
	@Autowired
	public MessageDao(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void addMessage(Message message) {
		currentSession().save(message);
	}
	
	public Message getMessageById(long id) {
		return (Message)currentSession().get(Message.class, id);
	}
	public void saveSpitter(Message message) {
		currentSession().update(message);
	}
}

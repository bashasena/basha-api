package com.qurarkssoft.api.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {


	private static List<Topic> topics=Arrays.asList(
			new Topic("java","Java Development","Core Java and Basics"),
			new Topic("javascript","Java Script","Javascript Basics"),
			new Topic("j2ee","Java Enterpirses","Advanced Java")
			);
	
	public List<Topic> getAllTopics(){
		return topics;
	}

	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	
	public List<Topic> addTopic(Topic topic){
		topics.add(topic);
		return topics;
	}

	public List<Topic> updateTopic(String id,Topic topic) {
		for(int i=0;i<topics.size();i++) {
			Topic t=topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				break;
			}
		}
		return topics;
	}

	public void deleteTopic(String id) {
	
		try {
			topics.removeIf(t ->t.getId().equals(id));
		}catch (Exception e) {

			e.printStackTrace();
		}
		//topics.removeIf(t -> t.getId().equals(id));
	}
}

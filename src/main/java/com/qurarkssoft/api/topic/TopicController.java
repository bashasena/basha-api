package com.qurarkssoft.api.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicSerivce;
	
	@RequestMapping("/topics")
	public List<Topic> getTopics(){
		System.out.println("GETALL");
		return topicSerivce.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopics(@PathVariable String id){
		System.out.println("Get One:"+id);

		return topicSerivce.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topics")
	public List<Topic> addTopic(@RequestBody Topic topic){
		System.out.println("Add Topic:"+topic.getId());

		return topicSerivce.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
	public void deleteTopic(@PathVariable String id){
		System.out.println("delete topic:"+id);

		topicSerivce.deleteTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	public List<Topic> updateTopic(@PathVariable String id, @RequestBody Topic topic){
		System.out.println("update One:"+id);

		return topicSerivce.updateTopic(id,topic);
	}
}

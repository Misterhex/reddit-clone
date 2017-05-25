package com.misterhex.redditclone;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class RedditCloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedditCloneApplication.class, args);
	}

	@Bean
	public ITopicRepository TopicRepository() {
		return new TopicRepository();
	}

	@Bean(name="ValidVoteValues")
	public String[] ValidVoteValues(){
		String[] validVoteTypes = new String[]{ "up", "down"};
		return validVoteTypes;
	}

}

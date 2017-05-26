package com.misterhex.redditclone;

import com.misterhex.redditclone.repositories.ITopicRepository;
import com.misterhex.redditclone.repositories.ReadWriteLockTopicRepository;
import com.misterhex.redditclone.repositories.TopicRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RedditCloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedditCloneApplication.class, args);
	}

	@Bean
	public ITopicRepository ReadWriteLockTopicRepository() {
		return new ReadWriteLockTopicRepository(new TopicRepository());
	}

	@Bean(name="ValidVoteValues")
	public String[] ValidVoteValues(){
		String[] validVoteTypes = new String[]{ "up", "down"};
		return validVoteTypes;
	}

}

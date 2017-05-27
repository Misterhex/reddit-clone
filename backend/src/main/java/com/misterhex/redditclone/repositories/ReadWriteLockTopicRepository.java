package com.misterhex.redditclone.repositories;

import com.misterhex.redditclone.Topic;
import com.misterhex.redditclone.Vote;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTopicRepository implements ITopicRepository {

    private final TopicRepository topicRepository;

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private final Lock readLock = readWriteLock.readLock();

    private final Lock writeLock = readWriteLock.writeLock();

    @Autowired
    public ReadWriteLockTopicRepository(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    public Collection<Topic> top20() {
        readLock.lock();
        try {
            return this.topicRepository.top20();
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public Topic add(String headline) {
        writeLock.lock();
        try {
            return this.topicRepository.add(headline);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public boolean remove(UUID topicId) {
        writeLock.lock();
        try {
            return this.topicRepository.remove(topicId);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public boolean isExist(UUID topicId) {
        readLock.lock();
        try {
            return this.topicRepository.isExist(topicId);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public void vote(Vote vote) {
        writeLock.lock();
        try {
            this.topicRepository.vote(vote);
        } finally {
            writeLock.unlock();
        }
    }
}

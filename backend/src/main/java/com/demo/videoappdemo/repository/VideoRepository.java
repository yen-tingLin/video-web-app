package com.demo.videoappdemo.repository;


import com.demo.videoappdemo.model.Video;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends MongoRepository<Video, String> {
}

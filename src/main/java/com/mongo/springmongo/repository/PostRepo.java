package com.mongo.springmongo.repository;

import com.mongo.springmongo.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepo extends MongoRepository<Post,String> {

}

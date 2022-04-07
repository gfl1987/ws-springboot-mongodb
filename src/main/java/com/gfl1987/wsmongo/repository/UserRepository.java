package com.gfl1987.wsmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gfl1987.wsmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}

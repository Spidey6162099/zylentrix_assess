package com.example.zylentrix_assessment.repostiories;

import com.example.zylentrix_assessment.entities.UserInDB;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserInDB,String>{

}

package com.example.zylentrix_assessment.services;

import com.example.zylentrix_assessment.Exceptions.UserCreationException;
import com.example.zylentrix_assessment.Exceptions.UserNotFoundException;
import com.example.zylentrix_assessment.dtos.UserDto;
import com.example.zylentrix_assessment.entities.UserInDB;
import com.example.zylentrix_assessment.repostiories.UserRepository;
import com.mongodb.MongoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String save(UserDto userDto)throws MongoException{
        try {
            UserInDB savedUser=userRepository.save(new UserInDB(userDto.getName(), userDto.getEmail(), userDto.getAge()));

            return savedUser.getId();
        }
        catch(MongoException mongoException){
            throw new UserCreationException("error adding new user",mongoException);
        }
    }

    public List<UserInDB> getAll(){
        return userRepository.findAll();
    }

    public UserInDB getById(String id){

        Optional<UserInDB> op=userRepository.findById(id);

        return op.orElseThrow(()->{
            return new UserNotFoundException("user could not be found");
        });

    }

    public String updateUser(String id,UserDto userDto){
            //first find
            UserInDB userInDB=userRepository.findById(id).orElseThrow(()->new UserNotFoundException("user could not be found"));
            userRepository.save(new UserInDB(id,userDto.getName(),userDto.getEmail(),userDto.getAge()));
            return id;
    }

    public String deleteUser(String id){

            UserInDB userInDB=userRepository.findById(id).orElseThrow(()->new UserNotFoundException("user could not be found"));
            userRepository.deleteById(id);
            return userInDB.getId();


    }


}

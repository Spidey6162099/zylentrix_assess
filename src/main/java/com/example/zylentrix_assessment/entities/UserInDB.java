package com.example.zylentrix_assessment.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserInDB{

    public void setId(String id) {
        this.id = id;
    }

    @Id
    private String id;

    private String name;
    private String email;

    private int age;

    public UserInDB(String name,String email,int age){
        this.name=name;
        this.email=email;
        this.age=age;
    }



}

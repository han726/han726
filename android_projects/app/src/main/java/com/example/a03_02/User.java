package com.example.a03_02;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
public class User {
    public String nickname;
    public Integer age;
    public User() {
        //Default
    }
    public User(String nickname, Integer age){
        this.nickname = nickname;
        this.age = age;
    }
    public String getNickname() {
        return nickname;
    }
    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("nickname", nickname);
        result.put("age", age);
        return result;
    }
}

package com.lp.mongodb_demo.dao;

import com.lp.mongodb_demo.common.DbGlobe;
import com.lp.mongodb_demo.entity.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/8/17 9:02
 * @Version 1.0
 */
@Repository
public class UserDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public User saveOneUser(User user){
        return mongoTemplate.save(user, DbGlobe.dbNameUser);
    }

    public void saveUser(List<User> users){
        for (User user : users) {
            mongoTemplate.save(user, DbGlobe.dbNameUser);
        }
    }

    public List<User> findAll(){
        return mongoTemplate.findAll(User.class);
    }
}

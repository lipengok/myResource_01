package com.lp.filter_demo.serveice;

import com.lp.filter_demo.entity.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lipeng
 * @Date 2022/7/15 14:53
 * @Version 1.0
 */
public class PersonService {
    public List<Person> findAll(){
        // todo 从数据库获取数据
        Person person1  = new Person();
        person1.setId(1L);
        person1.setTeam("tim");
        person1.setNum(90);
        Person person2  = new Person();
        person2.setId(2L);
        person2.setTeam("光子");
        person2.setNum(90);
        Person person3  = new Person();
        person3.setId(3L);
        person3.setTeam("腾讯");
        person3.setNum(90);
        List list = new ArrayList();
        list.add(person1);
        list.add(person2);
        list.add(person3);
        return list;
    }
}

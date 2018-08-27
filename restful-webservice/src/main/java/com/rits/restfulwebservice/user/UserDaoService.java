package com.rits.restfulwebservice.user;

import com.rits.restfulwebservice.user.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author Ritesh Singh
 * @version 1.0
 * @since 08/08/18
 */
@Component
public class UserDaoService {

    private static  List<User> users = new ArrayList<>();
    public static Integer userCount =4;

    static {
        users.add(new User(1,"Sunil",new Date()));
        users.add(new User(2,"Ritesh",new Date()));
        users.add(new User(3,"Jagasan",new Date()));
        users.add(new User(4,"Deepak",new Date()));

    }

    public List<User> findAll(){
        return users;
    }
    public User save(User user){
        if(user.getId()==null){
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }
    public User findOne(int id){
        for (User user:users) {
            if(user.getId()==id) {
                return user;
            }
        }
       return null;
    }
    public User deleteById(int id){
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext())
        {
            User user = iterator.next();
            if(user.getId()==id) {
                 iterator.remove();
                 return user;
            }

        }

        return null;
    }
}

package com.rest.webservices.learning.rest.userdao;

import com.rest.webservices.learning.rest.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class userComponent {

    private static List<User> users=new ArrayList<>();

    private static Integer ucountid=0;

    static{
       // users.add(new User(101,"rekha", LocalDate.now().minusYears(24)));
        users.add(new User(++ucountid,"rekha", LocalDate.now().minusYears(24)));
        users.add(new User(++ucountid,"niha",LocalDate.now().minusYears(26)));
        users.add(new User(++ucountid,"Vinni",LocalDate.now().minusYears(24)));
        users.add(new User(++ucountid,"nayanika",LocalDate.now().minusYears(24)));
    }
    public List<User> findAll() {
        return users;
    }
    public User findByuid(int id){
        Predicate<? super User> predicate = u -> u.getUid().equals(id);
       return users.stream().filter(predicate).findFirst().get();
       // return users.stream().filter(user -> user.getUid().equals(id)).findFirst().orElse(null);

    }
    public User save(User user){
        user.setUid(++ucountid);
        users.add(user);
        return user;
    }

    public void deleteById(int id){
        Predicate<? super User> predicate = u -> u.getUid().equals(id);
        users.removeIf(predicate);
    }
}

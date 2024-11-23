package sg.edu.nus.iss.vttp5a_ssf_day15L.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;


import sg.edu.nus.iss.vttp5a_ssf_day15L.model.Person;
import sg.edu.nus.iss.vttp5a_ssf_day15L.utility.Util;

@Repository
public class RedisListRepo {

    @Autowired
    @Qualifier(Util.template02)
    RedisTemplate<String, Object> template;

    // slide 30 -- adding?
    public void leftPush(String key, String value) {
        template.opsForList().leftPush(key, value);
    }

    public void rightPush(String key, String value) {
        template.opsForList().rightPush(key, value);
    }

    // pop remove from list
    public void leftPop(String key, String value) {
        template.opsForList().leftPop(key, 1);
    }

    public void rightPop(String key, String value) {
        template.opsForList().rightPop(key, 1);
    }

    // slide 32 --  what is this index?? get value at index position
    public String get(String key, Integer index) {
        return template.opsForList().index(key, index).toString();
    }

    // slide 33
    public Long size(String key) {
        return template.opsForList().size(key);
    }

    public List<Object> getList(String key) {

        List<Object> list = template.opsForList().range(key, 0, -1);
        return list;
    }

    public Boolean deleteItem(String key, Person personToDelete) {
        Boolean isDeleted = false;

        String valueToDelete = personToDelete.toString().toLowerCase();
        // System.out.println(valueToDelete);

        // List<Object> personList = template.opsForList().range("persons", 0, -1);
        // System.out.println(personList);
        
        // why use template of List<String, String> instead of List<String,Object> ?
        // Object person = template.opsForList().index("persons", 1);
        // String personString = person.toString();
        // System.out.println(personString);

        Long indexFound = template.opsForList().indexOf(key, valueToDelete);

        if (indexFound >= 0) {
            template.opsForList().remove(key, 1, valueToDelete);
            isDeleted = true;
        }

        return isDeleted;
    }

}

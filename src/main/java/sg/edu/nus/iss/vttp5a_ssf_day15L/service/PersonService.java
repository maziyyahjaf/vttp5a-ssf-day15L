package sg.edu.nus.iss.vttp5a_ssf_day15L.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.vttp5a_ssf_day15L.model.Person;
import sg.edu.nus.iss.vttp5a_ssf_day15L.repository.RedisListRepo;

@Service
public class PersonService {

    @Autowired
    RedisListRepo personRepo;

    List<Person> persons = new ArrayList<>();

    public void addPerson(String redisKey, Person person) {
        personRepo.rightPush(redisKey, person.toString().toLowerCase());

    }

    public List<Person> findAll(String redisKey) {
        
        List<Object> listData = personRepo.getList(redisKey);
        List<Person> persons = new ArrayList<>();

        for (Object data : listData) {
            String[] rawData = data.toString().split(",");
            Person p = new Person(Integer.parseInt(rawData[0].trim()), rawData[1].trim(), rawData[2].trim());
            persons.add(p);
        }

        return persons;
    }

    public Boolean delete(String redisKey, Person person) {
        return personRepo.deleteItem(redisKey, person);
    }
    
}

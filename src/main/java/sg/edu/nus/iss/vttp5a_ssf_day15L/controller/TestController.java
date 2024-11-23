package sg.edu.nus.iss.vttp5a_ssf_day15L.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sg.edu.nus.iss.vttp5a_ssf_day15L.model.Person;
import sg.edu.nus.iss.vttp5a_ssf_day15L.service.PersonService;



@Controller
@RequestMapping("/tests")
public class TestController {

    @Autowired
    PersonService personService;

    @ResponseBody
    @GetMapping("/add")
    public String addPerson() {

        // System.out.println("Adding person 1");
        Person p = new Person(1, "Ash", "ash@email.com");
        personService.addPerson("persons", p);

        // System.out.println("Adding person 2");
        p = new Person(2, "Hazel", "hazel@email.com");
        personService.addPerson("persons", p);

        return "Person successfully added";

        
    }
    


    @ResponseBody
    @GetMapping("/persons")
    public List<Person> personFindAll() {

        return personService.findAll("persons");

    }

    @ResponseBody
    @GetMapping("/delete")
    public Boolean deletePerson() {

        Person person = new Person(2, "Hazel", "hazel@email.com");
        return personService.delete("persons", person);
    }

    
    
}

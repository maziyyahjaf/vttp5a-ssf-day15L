package sg.edu.nus.iss.vttp5a_ssf_day15L.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import sg.edu.nus.iss.vttp5a_ssf_day15L.model.Person;
import sg.edu.nus.iss.vttp5a_ssf_day15L.service.PersonService;
import sg.edu.nus.iss.vttp5a_ssf_day15L.utility.Util;

@Controller
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("") 
    public String displayPersonList(Model model) {
        var personList = personService.findAll(Util.keyPerson);
        model.addAttribute("personList", personList);

        return "personList";
    }

    

    @GetMapping("/add")
    public String addPerson(Model model) {

        Person person = new Person();
        model.addAttribute("person", person);

        return "addPerson";
    }

    @PostMapping("/add")
    public String postAddPerson(@Valid @ModelAttribute("person") Person person,
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addPerson";
        }

        Person p = new Person(person.getId(), person.getFullName(), person.getEmail());
        personService.addPerson(Util.keyPerson, p);

        return "redirect:/persons";
    }

    @GetMapping("/delete/{person-id}")
    public String deletePerson(@PathVariable("person-id") String personId, Model model) {
        // how do i get a person object from path variable?
        // need to get find a match?

        // you already have a List<Person> !!! in PersonService
        List<Person> persons = personService.findAll(Util.keyPerson);
        Person personToDelete = persons.stream().filter(p -> p.getId().equals(Integer.parseInt(personId)))
                                        .findFirst().get();
        personService.delete(Util.keyPerson, personToDelete);

        return "redirect:/persons";
    }


    
    
}

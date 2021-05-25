package br.com.erudio.services;

import br.com.erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service //pro SPRING cuidar da injeção de dependencias qnd necessário, pra não precisar dar new()
public class PersonService {

    private final AtomicLong counter = new AtomicLong();

    public Person create(Person p){
        return p;
    }

    public void delete(String id){
    }

    public Person update(Person p){
        return p;
    }

    public Person findById(String id){
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Pedro");
        person.setLastName("Accorsi");
        person.setAddress("São Leopoldo - RS");
        person.setGender("male");
        return person;
    }

    public List<Person> findAll(){
        List<Person> people = new ArrayList<Person>();

        for(int i=0; i<=2; i++){
            people.add(mockPerson(i));
        }

        return people;
    }

    private Person mockPerson(int i){
        Person p = new Person();

        switch(i) {
            case 0:
                p.setId(counter.incrementAndGet());
                p.setFirstName("Pedro");
                p.setLastName("Accorsi");
                p.setAddress("São Leopoldo - RS");
                p.setGender("male");
                break;

            case 1:
                p.setId(counter.incrementAndGet());
                p.setFirstName("Naruto");
                p.setLastName("Uzumaki");
                p.setAddress("São Leopoldo - RS");
                p.setGender("male");
                break;

            case 2:
                p.setId(counter.incrementAndGet());
                p.setFirstName("Sasuke");
                p.setLastName("Uchiha");
                p.setAddress("São Leopoldo - RS");
                p.setGender("male");
                break;

            default: break;

        }
        return p;
    }
}

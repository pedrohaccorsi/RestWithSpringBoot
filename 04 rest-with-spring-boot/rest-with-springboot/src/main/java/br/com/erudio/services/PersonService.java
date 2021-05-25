package br.com.erudio.services;

import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    public Person findById(Long id){
        return repository
                .findById(id)
                .orElseThrow(
                    ()->new ResourceNotFoundException("No records found for the given ID")
                );
    }

    public Person create(Person p){
        return repository.save(p);
    }

    public Person update(Person p){

        Person entity = repository
                .findById(p.getId())
                .orElseThrow(
                        ()->new ResourceNotFoundException("No records found for the given ID")
                );

        entity.setFirstName(p.getFirstName());
        entity.setLastName(p.getLastName());
        entity.setAddress(p.getAddress());
        entity.setGender(p.getGender());

        repository.save(entity);

        return entity;
    }


    public void delete(Long id){
        Person entity = repository
                .findById(id)
                .orElseThrow(
                        ()->new ResourceNotFoundException("No records found for the given ID")
                );

        repository.delete(entity);
    }


    public List<Person> findAll(){
        return repository.findAll();
    }

}

package com.compass.scholarshipprogram.services;

import com.compass.scholarshipprogram.model.Classes;
import com.compass.scholarshipprogram.repositories.ClassesRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Component
public class ClassesServiceImpl implements ClassesService {

    private final ClassesRepository classesRepository;

    public ClassesServiceImpl(ClassesRepository classesRepository) {
        this.classesRepository = classesRepository;
    }

    @Override
    public Classes save(Classes classes) {
        return classesRepository.save(classes);
    }

    @Override
    public Iterable<Classes> findAll() {
        return classesRepository.findAll();
    }

    @Override
    public Classes findById(long theId) {
        Optional<Classes> result = classesRepository.findById(theId);

        Classes theClasses = null;

        if (result.isPresent()) {
            theClasses = result.get();
            theClasses.setName(result.get().getName());
        } else {

            throw new RuntimeException("Did not find class id - " + theId);
        }

        return theClasses;
    }


    @Override
    public void deleteById(long theId) { classesRepository.deleteById(theId); }
}
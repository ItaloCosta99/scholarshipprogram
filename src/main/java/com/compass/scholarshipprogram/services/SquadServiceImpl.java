package com.compass.scholarshipprogram.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.compass.scholarshipprogram.model.Squad;
import com.compass.scholarshipprogram.repositories.SquadRepository;

@Service
@Component
public class SquadServiceImpl implements SquadService{

    private final SquadRepository squadRepository;

    public SquadServiceImpl(SquadRepository squadRepository) { this.squadRepository = squadRepository; }

    @Override
    public Squad save(Squad squad) {
        return squadRepository.save(squad);
    }

    @Override
    public List<Squad> findAll() {
        return squadRepository.findAll();
    }

    @Override
    public Squad findById(long theId) {
        Optional<Squad> result = squadRepository.findById(theId);

        Squad theSquad = null;

        if (result.isPresent()) {
            theSquad = result.get();
            theSquad.setName(result.get().getName());
        }
        else {

            throw new RuntimeException("Did not find squad id - " + theId);
        }

        return theSquad;
    }

    @Override
    public void deleteById(long theId) { squadRepository.deleteById(theId); }
}

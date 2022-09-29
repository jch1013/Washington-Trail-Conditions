package com.WTC.WashingtonTrailConditions.Services;

import java.util.List;
import com.WTC.WashingtonTrailConditions.Models.Trail;
import com.WTC.WashingtonTrailConditions.Repositories.TrailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TrailService {
    @Autowired
    private TrailRepository repository;

    public List<Trail> getAllTrails(){
        List<Trail> list =  (List<Trail>)repository.findAll();
        return list;
    }

    public List<Trail> getByKeyword(String keyword){
        return repository.findByKeyword(keyword);
    }

    public Trail getByID(Integer value) {
        return repository.getReferenceById(value);
    }
}

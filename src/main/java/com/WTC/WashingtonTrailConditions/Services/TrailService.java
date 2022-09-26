package com.WTC.WashingtonTrailConditions.Services;



import java.util.List;

import com.WTC.WashingtonTrailConditions.Models.Trail;
import com.WTC.WashingtonTrailConditions.Repositories.TrailRepository;
;
import org.hibernate.id.IncrementGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TrailService {
    @Autowired
    private TrailRepository repository;

    /*
     * TODO: Get the List of Shops
     */
    public List<Trail> getAllTrails(){
        List<Trail> list =  (List<Trail>)repository.findAll();
        System.out.println("length of list: " + list.size());
        return list;
    }

    /*
     * TODO: Get Shop By keyword
     */
    public List<Trail> getByKeyword(String keyword){
        System.out.println("Searching by keyword: " + keyword);
        return repository.findByKeyword(keyword);
    }

    public Trail getByID(Integer value) {
        return repository.getReferenceById(value);
    }
}

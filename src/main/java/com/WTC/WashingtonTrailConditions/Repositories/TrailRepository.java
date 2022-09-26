package com.WTC.WashingtonTrailConditions.Repositories;

import com.WTC.WashingtonTrailConditions.Models.Trail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrailRepository extends JpaRepository<Trail, Integer> {

    @Query(value = "select * from trail t where t.name like %:keyword%", nativeQuery = true)
    List<Trail> findByKeyword(@Param("keyword") String keyword);
}

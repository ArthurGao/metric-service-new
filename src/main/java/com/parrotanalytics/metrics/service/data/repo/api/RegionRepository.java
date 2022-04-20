package com.parrotanalytics.metrics.service.data.repo.api;

import com.parrotanalytics.metrics.service.apidb_model.TV360Region;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends CrudRepository<TV360Region, Integer>
{

    @Query(value = "select r from TV360Region r where (r.idUser=:idUser or r.isPreset = 1) and r.active = 1")
    public List<TV360Region> findByIdUser(@Param("idUser") Integer idUser);

    @Query(value = "select r from TV360Region r where r.isPreset=1 and r.active = 1")
    public List<TV360Region> findAllPreset();
    
    @Query(value = "select r from TV360Region r where r.id IN :regionIdList and r.active = 1")
    public List<TV360Region> findByListIds(@Param("regionIdList") List<Integer> regionIdList);

}

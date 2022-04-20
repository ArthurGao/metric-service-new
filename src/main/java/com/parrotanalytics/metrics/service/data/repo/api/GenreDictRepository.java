package com.parrotanalytics.metrics.service.data.repo.api;

import com.parrotanalytics.metrics.service.apidb_model.GenreDict;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(exported = false)
public interface GenreDictRepository extends CrudRepository<GenreDict, Integer>
{

}

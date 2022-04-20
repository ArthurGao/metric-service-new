package com.parrotanalytics.metrics.service.data.repo.api;

import com.parrotanalytics.metrics.service.apidb_model.Language;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Minh Vu
 * @since v1
 */
@Repository
public interface LanguageRepository extends PagingAndSortingRepository<Language, String>
{

    @Query("SELECT l FROM Language l")
    List<Language> findAllLanguages();
}

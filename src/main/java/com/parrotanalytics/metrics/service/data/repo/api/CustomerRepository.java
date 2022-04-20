package com.parrotanalytics.metrics.service.data.repo.api;

import com.parrotanalytics.metrics.service.apidb_model.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * Data repository for user account information.
 * 
 * 
 */
@Repository
@RepositoryRestResource(exported = false)
public interface CustomerRepository extends CrudRepository<Customer, Integer>
{

    @Query("SELECT c FROM Customer c ")
    public List<Customer> loadAllCustomers();

    @Query("SELECT c from Customer c WHERE c.companyName = :companyName")
    public Customer findByCompanyName(@Param("companyName") String companyName);

}

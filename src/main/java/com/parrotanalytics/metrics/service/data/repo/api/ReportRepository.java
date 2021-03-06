package com.parrotanalytics.metrics.service.data.repo.api;

import com.parrotanalytics.metrics.service.apidb_model.Report;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends CrudRepository<Report, Integer>
{

    @Query(value = "select * from `portal`.`report` where idUser=?1 or json_contains(report.users, json_array(?1)) or ((json_contains(report.users, '0') and report.idUser in (select idUser from `subscription`.`user` where idAccount in (select idAccount from `subscription`.`user` WHERE idUser=?1))))", nativeQuery = true)
    List<Report> findReportsByUser(@Param("idUser") Integer idUser);

    @Override
    <S extends Report> S save(S entity);

    @Override
    void deleteById(Integer id);

    @Override
    void delete(Report entity);

}

package com.f1.records.repositorys;

import com.f1.records.pojos.ConstructorStandings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstructorsStandingsRepository extends CrudRepository<ConstructorStandings, Integer> {
}
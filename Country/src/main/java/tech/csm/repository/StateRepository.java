package tech.csm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.csm.model.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}

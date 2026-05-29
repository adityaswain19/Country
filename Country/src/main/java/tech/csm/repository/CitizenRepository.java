package tech.csm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.csm.model.Citizen;

public interface CitizenRepository extends JpaRepository<Citizen, Integer> {

}

package tech.csm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.csm.model.Panchayat;
import tech.csm.model.Village;

public interface VillageRepository extends JpaRepository<Village, Integer> {

	List<Village> findByPanchayat(Panchayat panchayat);
}

package tech.csm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.csm.model.Block;
import tech.csm.model.Panchayat;

public interface PanchayatRepository extends JpaRepository<Panchayat, Integer> {

	List<Panchayat> findByBlock(Block block);
}

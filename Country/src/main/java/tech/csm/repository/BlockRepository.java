package tech.csm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.csm.model.Block;
import tech.csm.model.State;

@Repository
public interface BlockRepository extends JpaRepository<Block, Integer> {

	List<Block> findByState(State state);

}

package tech.csm.service;

import java.util.List;

import tech.csm.model.Block;

public interface BlockService {

	List<Block> getBlockByStateId(Integer stateId);


	Block getBlockById(Integer id);

}

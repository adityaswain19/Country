package tech.csm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.csm.model.Block;
import tech.csm.model.State;
import tech.csm.repository.BlockRepository;

@Service
public class BlockServiceImpl implements BlockService {

	@Autowired
	private BlockRepository blockRepository;
	
	@Autowired
	private StateService stateService;
	
	@Override
	public List<Block> getBlockByStateId(Integer stateId) {
		if(stateId==0){
			return new ArrayList<Block>();
		}
	else{
		return blockRepository.findByState(stateService.getStateById(stateId));
	    }
	
}

	@Override
	public Block getBlockById(Integer id) {
		return blockRepository.findById(id).get();
	}
}
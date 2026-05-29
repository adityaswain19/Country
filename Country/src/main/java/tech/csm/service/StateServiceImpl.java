package tech.csm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.csm.model.State;
import tech.csm.repository.StateRepository;

@Service
public class StateServiceImpl implements StateService {

	@Autowired
	StateRepository stateRepository;
	
	@Override
	public List<State> getAllStates() {
		return stateRepository.findAll();
	}
	
	@Override
	public State getStateById(Integer stateId) {
		return stateRepository.findById(stateId).get();
	}

}

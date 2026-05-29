package tech.csm.service;

import java.util.List;

import org.jspecify.annotations.Nullable;

import tech.csm.model.State;

public interface StateService {

	List<State> getAllStates();

	State getStateById(Integer stateId);

}

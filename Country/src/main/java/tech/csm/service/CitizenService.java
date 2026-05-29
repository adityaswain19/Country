package tech.csm.service;

import java.util.List;

import org.jspecify.annotations.Nullable;

import tech.csm.model.Citizen;

public interface CitizenService {

	Citizen saveCitizen(Citizen citizen);

	List<Citizen> getAllCitizens();

	String deleteCitizenById(Integer citizenId);

	Citizen getCitizenById(Integer citizenId);


}

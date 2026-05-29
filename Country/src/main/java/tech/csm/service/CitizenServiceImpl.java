package tech.csm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.csm.model.Citizen;
import tech.csm.repository.CitizenRepository;

@Service
public class CitizenServiceImpl implements CitizenService {

	@Autowired
	private CitizenRepository citizenRepository; 
	
	@Override
	public Citizen saveCitizen(Citizen citizen) {
		return citizenRepository.save(citizen);
	}

	@Override
	public List<Citizen> getAllCitizens() {
		return citizenRepository.findAll();
	}

	@Override
	public String deleteCitizenById(Integer Id) {
		String msg="";
		try {
			citizenRepository.deleteById(Id);
		msg= "citizen deleted with id "+Id; 
		}catch(Exception e) {
			msg="citizen not deleted";				
		}
		
		return msg;
	}

	@Override
	public Citizen getCitizenById(Integer citizenId) {
		return citizenRepository.getById(citizenId);
	}

}

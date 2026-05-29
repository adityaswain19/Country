package tech.csm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.csm.model.Village;
import tech.csm.repository.VillageRepository;
@Service
public class VillageServiceImpl implements VillageService {

	@Autowired
	private VillageRepository villageRepository;
	
	@Autowired
	private PanchayatService panchayatService; 
	
	@Override
	public List<Village> getVillageByPanchayatId(Integer Id) {
		return villageRepository.findByPanchayat(panchayatService.getPanchayatById(Id));
	}

}

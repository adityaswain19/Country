package tech.csm.service;

import java.util.List;

import tech.csm.model.Village;

public interface VillageService {

	List<Village> getVillageByPanchayatId(Integer Id);

}

package tech.csm.service;

import java.util.List;

import tech.csm.model.Panchayat;

public interface PanchayatService {

	List<Panchayat> getPanchayatByBlockId(Integer block);

	Panchayat getPanchayatById(Integer id);

}

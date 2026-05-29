package tech.csm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.csm.model.Panchayat;
import tech.csm.repository.PanchayatRepository;

@Service
public class PanchayatServiceImpl implements PanchayatService {

	@Autowired
	private PanchayatRepository panchayatRepository;
	
	@Autowired
	private BlockService blockService;
	
	@Override
	public List<Panchayat> getPanchayatByBlockId(Integer id) {
		
		return panchayatRepository.findByBlock(blockService.getBlockById(id));
	}

	@Override
	public Panchayat getPanchayatById(Integer id) {
		return panchayatRepository.findById(id).get();
	}

}

package com.ram.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.model.Placement;
import com.ram.repository.PlacementRepository;
import com.ram.service.PlacementService;

@Service
public class PlacementServiceImpl implements PlacementService
{

	@Autowired
	private PlacementRepository placementRepository;

	@Override
	public Placement createPlacement(Placement placement) {
		
		return placementRepository.save(placement);
	}

	@Override
	public void updatePlacement(Placement placement) {
		
		placementRepository.save(placement);

	}

	@Override
	public Placement getPlacement(int placement_id) {
		Optional<Placement> optional = placementRepository.findById(placement_id);
		Placement placement = optional.get();
		return placement;
	}

	@Override
	public List<Placement> getPlacements() {
		
		return (List<Placement>)placementRepository.findAll();
	}

	@Override
	public void deletePlacement(int placement_id) {
		
		placementRepository.deleteById(placement_id);
	}

	@Override
	public boolean isPlacementExist(int placement_id) {
		
		return placementRepository.existsById(placement_id);
	}
	
	@Override
	public int getCount() {
		return (int) placementRepository.count();
	}
}

package com.ram.service;

import java.util.List;

import com.ram.model.Placement;

public interface PlacementService
{
	public abstract Placement createPlacement(Placement placement);

	public abstract void updatePlacement(Placement placement);
	
	public abstract Placement getPlacement(int placement_id);
	
	public abstract List<Placement> getPlacements();
	
	public abstract void deletePlacement(int placement_id);
	
	public abstract boolean isPlacementExist(int placement_id);
	
	public abstract int getCount();
}

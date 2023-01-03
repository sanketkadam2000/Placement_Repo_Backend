package com.ram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ram.exception.PlacementNotfoundException;
import com.ram.model.Placement;
import com.ram.service.PlacementService;

@RestController
//@CrossOrigin(origins="http://localhost:3001")
@CrossOrigin(origins="*")
public class PlacementServiceController
{
	@Autowired
	private PlacementService placementService;

	@RequestMapping(value = "/placements", method = RequestMethod.POST)
	public ResponseEntity<Object> createPlacement(@RequestBody Placement placement)
	{
		placement = placementService.createPlacement(placement);
		return new ResponseEntity<>("Placement is created successfully with id = " +placement.getPlacement_id(), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/placements/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updatePlacement(@PathVariable("id") int placement_id,
			@RequestBody Placement placement)
	{
		boolean isPlacementExist = placementService.isPlacementExist(placement_id);
		if (isPlacementExist)
		{
			placement.setPlacement_id(placement_id);
			placementService.updatePlacement(placement);
			return new ResponseEntity<>("Placement is updated successsfully", HttpStatus.OK);
		}
		else
		{
			throw new PlacementNotfoundException();
		}

	}

	@RequestMapping(value = "/placements/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getPlacement(@PathVariable("id") int placement_id)
	{
		boolean isPlacementExist = placementService.isPlacementExist(placement_id);
		if (isPlacementExist)
		{
			Placement placement = placementService.getPlacement(placement_id);
			return new ResponseEntity<>(placement, HttpStatus.OK);
		}
		else
		{
			throw new PlacementNotfoundException();
		}

	}

	@RequestMapping(value = "/placements", method = RequestMethod.GET)
	public ResponseEntity<Object> getPlacements()
	{
		List<Placement> placementList = placementService.getPlacements();
		return new ResponseEntity<>(placementList, HttpStatus.OK);
	}

	@RequestMapping(value = "/placements/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deletePlacement(@PathVariable("id") int placement_id)
	{
		boolean isPlacementExist = placementService.isPlacementExist(placement_id);
		if (isPlacementExist)
		{
			placementService.deletePlacement(placement_id);
			return new ResponseEntity<>("Placement is deleted successsfully", HttpStatus.OK);
		}
		else
		{
			throw new PlacementNotfoundException();
		}

	}

}

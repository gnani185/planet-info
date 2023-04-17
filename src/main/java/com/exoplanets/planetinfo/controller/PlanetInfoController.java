package com.exoplanets.planetinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exoplanets.planetinfo.model.PlanetInformations;
import com.exoplanets.planetinfo.service.PlanetInfoDetails;

@RestController
@RequestMapping("/planet-info")
public class PlanetInfoController {

	@Autowired
	private PlanetInfoDetails planetInfoDetails;

	@GetMapping
	public PlanetInformations getPlanetInfo() {
		return planetInfoDetails.getPlanetInformations();
	}

}

package com.exoplanets.planetinfo.service;

import java.util.List;

import com.exoplanets.planetinfo.model.Planet;

public interface PlanetInfoProvider {

	public List<Planet> getPlanetInfo();

}
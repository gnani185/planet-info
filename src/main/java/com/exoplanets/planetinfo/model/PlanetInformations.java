package com.exoplanets.planetinfo.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class PlanetInformations {
	private long orphanCount;
	private String hottestPlanet;
	@JsonIgnore
	private Map<Integer, Map<String, Long>> planetTimelineMap;
	private List<String> planetTimelineText;

}

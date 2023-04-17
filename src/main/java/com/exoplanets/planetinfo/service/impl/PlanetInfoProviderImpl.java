package com.exoplanets.planetinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.exoplanets.planetinfo.model.Planet;
import com.exoplanets.planetinfo.service.PlanetInfoProvider;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PlanetInfoProviderImpl implements PlanetInfoProvider {

	@Value("${url.exoplanet.data}")
	private String urlExoplanetData;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ObjectMapper mapper;

	@Override
	public List<Planet> getPlanetInfo() {
		List<Planet> planets = null;
		try {
			String response = restTemplate.getForObject(urlExoplanetData, String.class);
			if (null != response) {
				planets = mapper.readerForListOf(Planet.class).readValue(response);
			}
		} catch (Exception e) {
			throw new RuntimeException("Unknown Exception occurred.", e);
		}
		return planets;
	}
}
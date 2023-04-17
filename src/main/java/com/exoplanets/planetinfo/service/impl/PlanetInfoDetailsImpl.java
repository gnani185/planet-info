package com.exoplanets.planetinfo.service.impl;

import static com.exoplanets.planetinfo.config.Constants.LARGE;
import static com.exoplanets.planetinfo.config.Constants.MEDIUM;
import static com.exoplanets.planetinfo.config.Constants.ORPHAN_FLAG;
import static com.exoplanets.planetinfo.config.Constants.SMALL;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exoplanets.planetinfo.model.Planet;
import com.exoplanets.planetinfo.model.PlanetInformations;
import com.exoplanets.planetinfo.model.PlanetWithRadiusSize;
import com.exoplanets.planetinfo.service.PlanetInfoDetails;
import com.exoplanets.planetinfo.service.PlanetInfoProvider;

@Service
public class PlanetInfoDetailsImpl implements PlanetInfoDetails {

	@Autowired
	private PlanetInfoProvider planetInfoService;

	@Override
	public PlanetInformations getPlanetInformations() {
		PlanetInformations planetInformations = new PlanetInformations();
		List<Planet> planets = planetInfoService.getPlanetInfo();
		planetInformations.setOrphanCount(findOrphanCount(planets));
		planetInformations.setHottestPlanet(findHosttestStar(planets));
		planetInformations.setPlanetTimelineMap(findPlanetDiscoveryTimeline(planets));
		planetInformations.setPlanetTimelineText(getTimelineTextFromMap(planetInformations));
		return planetInformations;
	}

	private long findOrphanCount(List<Planet> planets) {
		long orphansCount = 0;
		orphansCount = planets.stream().filter(planet -> planet.getTypeFlag() == ORPHAN_FLAG).count();
		return orphansCount;
	}

	private String findHosttestStar(List<Planet> planets) {
		String hottestPlanet = null;
		Optional<Planet> planet = planets.stream().max(Comparator.comparing(Planet::getSurfaceTempK));
		if (planet.isPresent()) {
			hottestPlanet = planet.get().getPlanetIdentifier();
		}
		return hottestPlanet;
	}

	private Map<Integer, Map<String, Long>> findPlanetDiscoveryTimeline(List<Planet> planets) {
		return planets.stream().filter(planet -> planet.getDiscoveryYear() != 0).map(mapToCustomInfo)
				.collect(Collectors.groupingBy(PlanetWithRadiusSize::getDiscoveryYear,
						Collectors.groupingBy(PlanetWithRadiusSize::getRadiusJpt, Collectors.counting())));
	}

	private List<String> getTimelineTextFromMap(PlanetInformations planetInformations) {
		List<String> timelineText = new ArrayList<>();
		for (Integer year : planetInformations.getPlanetTimelineMap().keySet()) {
			Map<String, Long> yearData = planetInformations.getPlanetTimelineMap().get(year);
			StringBuilder sb = new StringBuilder("In ").append(year).append(" we discovered ")
					.append(yearData.get(SMALL) != null ? yearData.get(SMALL) : 0).append(" small planets, ")
					.append(yearData.get(MEDIUM) != null ? yearData.get(MEDIUM) : 0).append(" medium planets, ")
					.append(yearData.get(LARGE) != null ? yearData.get(LARGE) : 0).append(" large planets.");
			timelineText.add(sb.toString());
		}
		return timelineText;
	}

	private Function<Planet, PlanetWithRadiusSize> mapToCustomInfo = new Function<Planet, PlanetWithRadiusSize>() {
		@Override
		public PlanetWithRadiusSize apply(Planet t) {
			PlanetWithRadiusSize customPlanet = new PlanetWithRadiusSize();
			customPlanet.setDiscoveryYear(t.getDiscoveryYear());
			customPlanet.setPlanetIdentifier(t.getPlanetIdentifier());
			String size = null;
			if (t.getRadiusJpt() >= 0 && t.getRadiusJpt() <= 1) {
				size = SMALL;
			} else if (t.getRadiusJpt() > 1 && t.getRadiusJpt() <= 2) {
				size = MEDIUM;
			} else if (t.getRadiusJpt() > 2) {
				size = LARGE;
			} else {
				size = "";
			}
			customPlanet.setRadiusJpt(size);

			return customPlanet;
		}
	};

}

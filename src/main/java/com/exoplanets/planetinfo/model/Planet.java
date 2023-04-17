package com.exoplanets.planetinfo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Planet {

	@JsonProperty("PlanetIdentifier")
	private String planetIdentifier;
	@JsonProperty("TypeFlag")
	private int typeFlag;
	@JsonProperty("PlanetaryMassJpt")
	private String planetaryMassJpt;
	@JsonProperty("RadiusJpt")
	private double radiusJpt;
	@JsonProperty("PeriodDays")
	private double periodDays;
	@JsonProperty("SemiMajorAxisAU")
	private double semiMajorAxisAU;
	@JsonProperty("Eccentricity")
	private String eccentricity;
	@JsonProperty("PeriastronDeg")
	private String periastronDeg;
	@JsonProperty("LongitudeDeg")
	private String longitudeDeg;
	@JsonProperty("AscendingNodeDeg")
	private String ascendingNodeDeg;
	@JsonProperty("InclinationDeg")
	private double inclinationDeg;
	@JsonProperty("SurfaceTempK")
	private double surfaceTempK;
	@JsonProperty("AgeGyr")
	private String ageGyr;
	@JsonProperty("DiscoveryMethod")
	private String discoveryMethod;
	@JsonProperty("DiscoveryYear")
	private int discoveryYear;
	@JsonProperty("LastUpdated")
	private String lastUpdated;
	@JsonProperty("RightAscension")
	private String rightAscension;
	@JsonProperty("Declination")
	private String declination;
	@JsonProperty("DistFromSunParsec")
	private String distFromSunParsec;
	@JsonProperty("HostStarMassSlrMass")
	private double hostStarMassSlrMass;
	@JsonProperty("HostStarRadiusSlrRad")
	private double hostStarRadiusSlrRad;
	@JsonProperty("HostStarMetallicity")
	private int hostStarMetallicity;
	@JsonProperty("HostStarTempK")
	private int hostStarTempK;
	@JsonProperty("HostStarAgeGyr")
	private String hostStarAgeGyr;

}
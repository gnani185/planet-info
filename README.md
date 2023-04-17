# planet-info

Spring Boot application for downloading a catalog of exoplanet data and displays the following information:

1. The number of orphan planets (no star).
2. The name (planet identifier) of the planet orbiting the hottest star.
3. A timeline of the number of planets discovered per year grouped by size. Use the following groups: “small” is less than 1 Jupiter radii, “medium” is less than 2 Jupiter radii, and anything bigger is considered “large”. For example, in 2004 we discovered 2 small planets, 5 medium planets, and 0 large planets.
 
The dataset can be found in JSON format here: https://gist.githubusercontent.com/joelbirchler/66cf8045fcbb6515557347c05d789b4a/raw/9a196385b44d4288431eef74896c0512bad3defe/exoplanets
 
And is documented here: https://www.kaggle.com/mrisdal/open-exoplanet-catalogue

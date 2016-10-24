package grails.plugin.zipcitystate

/**
 * Defines interface for city state lookup service.
 *
 * @author Alexander.Kramer
 */
interface CityStateLookup {

    /**
     * Looks up for the given zip code and returns {@link ZipCityState} if found.
     * @param code the zip code
     * @return the ZipCityState if found
     */
    ZipCityState lookupByZip(String code)
}
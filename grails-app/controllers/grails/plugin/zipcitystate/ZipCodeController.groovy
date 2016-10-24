package grails.plugin.zipcitystate

import grails.converters.JSON

/**
 * Controller for ZipCode lookup.
 */
class ZipCodeController {

    /**
     * Looks up for the given zip code using the service bean defined by the
     * property: zipcitystate.cityStateLookupService.beanName
     *
     * The service bean must implement {@link CityStateLookup} interface and provide
     *
     * @param code
     * @return
     */
    def lookup(String code) {
        String serviceName = grailsApplication.config.zipcitystate.cityStateLookupService.beanName
        def zipCityState = grailsApplication.mainContext.getBean(serviceName).lookupByZip(code) ?: []
        render zipCityState as JSON
    }
}

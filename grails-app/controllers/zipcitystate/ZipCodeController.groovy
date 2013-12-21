package zipcitystate

import grails.converters.JSON

class ZipCodeController {

    def lookup(String code) {
        String serviceName = grailsApplication.config.zipcitystate.cityStateLookupService.beanName
        def zipCityState = grailsApplication.mainContext.getBean(serviceName).lookupByZip(code) ?: []
        render zipCityState as JSON
    }
}

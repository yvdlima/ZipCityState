package grails.plugin.zipcitystate

class ZipCodeService implements CityStateLookup {

    static transactional = false

    ZipCityState lookupByZip(String code) {
        def zipCode = ZipCode.findByCode(code)
        zipCode ? [code:zipCode.code,city:zipCode.city,state:zipCode.state] as ZipCityState : null
    }
}

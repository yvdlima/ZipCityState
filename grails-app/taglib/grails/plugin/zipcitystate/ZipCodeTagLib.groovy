package grails.plugin.zipcitystate

import grails.plugins.GrailsPluginManager
import org.springframework.beans.factory.annotation.Autowired

class ZipCodeTagLib {

    @Autowired
    GrailsPluginManager pluginManager

    static namespace = 'zipCode'

    /**
     * Tag requires that jQuery is installed via plugin
     */
    def resources = { attrs ->

        if (pluginManager.hasGrailsPlugin('asset-pipeline')) {
            out << g.include(view: 'zipCode/_zipLookupUrl.gsp')
            out << asset.javascript(src: 'zip-city-state.js')
            return
        }

        if (pluginManager.hasGrailsPlugin('resources')) {
            g.include(view: 'zipCode/_zipLookupUrl.gsp')
            r.require(module: 'zipcitystate')
            return
        }

        out << g.javascript(library: 'jquery', plugin: 'jquery')
        out << g.include(view: 'zipCode/_zipLookupUrl.gsp')
        out << g.javascript(src: 'assets/jquery.zipcitystate.js', plugin: 'zipcitystate')
    }
}
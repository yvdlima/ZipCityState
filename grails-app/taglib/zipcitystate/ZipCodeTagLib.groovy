package zipcitystate

import org.codehaus.groovy.grails.plugins.PluginManagerHolder

class ZipCodeTagLib {

    static namespace = 'zipCode'

    /**
     * Tag requires that jQuery is installed via plugin
     */
    def resources = { attrs ->
        boolean hasResourcesPlugin = PluginManagerHolder.pluginManager.hasGrailsPlugin('resources')

        if (hasResourcesPlugin) {
            g.include(view: 'zipCode/_zipLookupUrl.gsp')
            r.require(module: 'zipcitystate')
        }
        else {
            out << g.javascript(library: 'jquery', plugin: 'jquery')
            out << g.include(view: 'zipCode/_zipLookupUrl.gsp')
            out << g.javascript(src: 'jquery.zipcitystate.js', plugin: 'zipcitystate')
        }
    }

}

import org.codehaus.groovy.grails.plugins.PluginManagerHolder

boolean hasJQueryPlugin = PluginManagerHolder.pluginManager.hasGrailsPlugin('jquery')

modules = {
    'zipcitystate' {
        if(hasJQueryPlugin) dependsOn 'jquery'
        resource url: [dir: 'js', file: 'jquery.zipcitystate.js', plugin: 'zipcitystate']
    }
}
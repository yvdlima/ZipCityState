import grails.util.Holders

boolean hasJQueryPlugin = Holders.pluginManager.hasGrailsPlugin('jquery')

modules = {
    'zipcitystate' {
        if(hasJQueryPlugin) {
            dependsOn 'jquery'
        }
        resource url: [dir: 'js', file: 'jquery.zipcitystate.js', plugin: 'zipcitystate']
    }
}
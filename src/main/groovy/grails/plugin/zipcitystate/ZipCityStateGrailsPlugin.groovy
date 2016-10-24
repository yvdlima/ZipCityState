package grails.plugin.zipcitystate

import grails.plugins.Plugin

/**
 * Plugin descriptor
 *
 * @author Alexander.Kramer
 */
class ZipCityStateGrailsPlugin extends Plugin {
    def grailsVersion = '3.0.0 > *'
    def pluginExcludes = [
            'grails-app/domain/**',
            'grails-app/services/**',
            "grails-app/views/error.gsp",
            "grails-app/views/index.gsp"
    ]

    def title = 'Zip City State Plugin' //Headline display name of the plugin
    def author = 'Alex Kramer'
    def authorEmail = 'ackramer19@gmail.com'

    def description = '''Provides utilities to populate the US City and State from the provided 5 digit Zip code.'''

    def license = "APACHE"
    def organization = [ name: 'Good Start Genetics', url: 'http://www.goodstartgenetics.com/' ]
    def issueManagement = [ system: 'github', url: 'https://github.com/alexkramer/ZipCityState/issues' ]
    def scm = [ url: "https://github.com/alexkramer/ZipCityState" ]
    def documentation = "https://github.com/alexkramer/ZipCityState"
    def profiles = ['web']

    def developers = [
        [ name: 'Alex Kramer', email: 'ackramer19@gmail.com' ],
        [ name: 'Giri Pottepalem', email: 'gpottepalem@gmail.com' ]
    ]
}
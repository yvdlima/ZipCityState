package zipcitystate

import grails.plugins.*

class ZipCityStateGrailsPlugin extends Plugin {

    def grailsVersion = "4.0.10 > *"
    def pluginExcludes = [
        // "grails-app/views/error.gsp"
    ]

    def title = "Zip City State Plugin"
    def author = "Alex Kramer"
    def authorEmail = "ackramer19@gmail.com"
    def description = '''Provides utilities to populate the US City and State from the provided 5 digit Zip code.'''

    // URL to the plugin's documentation
    def documentation = "https://github.com/yvdlima/ZipCityState"
    def issueManagement = [ system: "github", url: "https://github.com/yvdlima/ZipCityState/issues" ]
    def scm = [ url: "https://github.com/yvdlima/ZipCityState" ]
    def license = "APACHE"
    def developers = [
        [ name: 'Alex Kramer', email: 'ackramer19@gmail.com' ],
        [ name: 'Giri Pottepalem', email: 'gpottepalem@gmail.com' ],
        [ name: 'Yuri Lima', email: 'yuri.vdl@gmail.com' ]
    ]

}

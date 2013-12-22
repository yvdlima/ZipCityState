class ZipCityStateGrailsPlugin {
    def version = "1.0"
    def grailsVersion = "2.0 > *"
    def pluginExcludes = [
            'grails-app/domain/**',
            'grails-app/services/**',
            "grails-app/views/error.gsp",
            "grails-app/views/index.gsp"
    ]

    def title = "Zip City State Plugin"
    def description = 'Provides utilities to populate the US City and State from the provided 5 digit zip code.'
    def documentation = "https://github.com/alexkramer/ZipCityState"

    def license = "APACHE"
    def organization = [ name: "Good Start Genetics", url: "http://www.goodstartgenetics.com/" ]
    def developers = [ [ name: "Alex Kramer", email: "ackramer19@gmail.com" ]]
    def issueManagement = [ system: "GITHUB", url: "https://github.com/alexkramer/ZipCityState/issues" ]
    def scm = [ url: "https://github.com/alexkramer/ZipCityState" ]
}

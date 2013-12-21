class ZipCityStateGrailsPlugin {
    // the plugin version
    def version = "1.0"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.0 > *"
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            'grails-app/domain/**',
            'grails-app/services/**',
            "grails-app/views/error.gsp",
            "grails-app/views/index.gsp"
    ]

    // TODO Fill in these fields
    def title = "Zip City State Plugin" // Headline display name of the plugin
    def author = "Alex Kramer"
    def authorEmail = "ackramer19@gmail.com"
    def description = 'Provides utilities to populate the US City and State from the provided 5 digit zip code.'

    // URL to the plugin's documentation
    def documentation = "https://github.com/alexkramer/ZipCityState"

    // Extra (optional) plugin metadata

    // License: one of 'APACHE', 'GPL2', 'GPL3'
    def license = "APACHE"

    // Details of company behind the plugin (if there is one)
    def organization = [ name: "Good Start Genetics", url: "http://www.goodstartgenetics.com/" ]

    // Any additional developers beyond the author specified above.
    def developers = [ [ name: "Alex Kramer", email: "ackramer19@gmail.com" ]]

    // Location of the plugin's issue tracker.
    def issueManagement = [ system: "GITHUB", url: "https://github.com/alexkramer/ZipCityState/issues" ]

    // Online location of the plugin's browseable source code.
    def scm = [ url: "https://github.com/alexkramer/ZipCityState" ]

}

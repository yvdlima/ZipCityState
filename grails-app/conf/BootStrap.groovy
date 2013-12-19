import zipcitystate.ZipCode

class BootStrap {

    def init = { servletContext ->
        createSomeZipCodes()
    }
    def destroy = {
    }

    def createSomeZipCodes = {
        def nescacZips = [
                ['01267','Williamstown','MA'],
                ['01002','Amherst','MA'],
                ['04240','Lewiston','MA'],
                ['04011','Brunswick','MA'],
                ['04901','Waterville','MA'],
                ['06320','New London','CT'],
                ['13323','Clinton','NY'],
                ['05753','Middlebury','VT'],
                ['06106','Hartford','CT'],
                ['02155','Medford','MA'],
                ['06459','Middleton','CT']
        ]
        nescacZips.each {
            new ZipCode(code: it[0],city: it[1],state: it[2]).save()
        }
    }
}

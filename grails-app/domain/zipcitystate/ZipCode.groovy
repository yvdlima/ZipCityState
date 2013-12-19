package zipcitystate

class ZipCode {

    String code
    String city
    String state

    static constraints = {
        code(blank: false)
        city(blank: false)
        state(blank: false)
    }

    static mapping = {
        version false
    }

}

package zipcitystate

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import grails.util.Holders
import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(ZipCodeController)
@Mock([ZipCode,ZipCodeService])
@TestMixin(GrailsUnitTestMixin)
class ZipCodeControllerTests {


    void testLookup() {
        Holders.grailsApplication.mainContext.registerMockBean("zipCodeService", new ZipCodeService())
        ZipCode brighton = new ZipCode(code: '02135',city: 'Brighton',state:'MA').save()
        controller.lookup('02135')
        assert response.json.code == brighton.code
        assert response.json.state == brighton.state
        assert response.json.city == brighton.city
    }
}

package com.instantor.dap.springbootbackend.service


import com.instantor.dap.springbootbackend.client.SwapiClient
import com.instantor.dap.springbootbackend.dto.SwapiFullResponse
import spock.lang.Specification

class StarWarsCharacterServiceSpec extends Specification {

    def client = Mock(SwapiClient)
    def service = new StarWarsCharacterService(client)

    def "should call client and mapper once"() {
        given:
        def apiResponse = new SwapiFullResponse()

        when:
        service.getCharacterById(1)

        then:
        1 * client.getCharacterById(1) >> apiResponse
    }
}

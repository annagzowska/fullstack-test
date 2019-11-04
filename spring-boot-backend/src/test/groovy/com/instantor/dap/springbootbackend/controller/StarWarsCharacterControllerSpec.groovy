package com.instantor.dap.springbootbackend.controller


import com.instantor.dap.springbootbackend.dto.StarWarsCharacterResponse
import com.instantor.dap.springbootbackend.service.StarWarsCharacterService
import spock.lang.Specification
import spock.lang.Unroll

import static org.springframework.http.HttpStatus.BAD_REQUEST
import static org.springframework.http.HttpStatus.OK

class StarWarsCharacterControllerSpec extends Specification {

    def service = Mock(StarWarsCharacterService)
    def controller = new StarWarsCharacterController(service)

    def "should return OK and call service once if parameters are valid"() {
        given:
        def character = createStarWarsCharacterResponse()

        when:
        def response = controller.getCharacter("1")

        then:
        1 * service.getCharacterById("1") >> character
        response.statusCode == OK
    }

    @Unroll
    def "should return errorCode and not call service if parameter is #parameterState"() {
        when:
        def response = controller.getCharacter(id)

        then:
        0 * service.getCharacterById(_)
        response.statusCode == BAD_REQUEST

        where:
        id      | parameterState
        null    | "null"
        ""      | "empty string"
    }

    def createStarWarsCharacterResponse() {
        StarWarsCharacterResponse.builder()
                .name("Luke")
                .height("123")
                .birthYear("1999")
                .build()
    }

}

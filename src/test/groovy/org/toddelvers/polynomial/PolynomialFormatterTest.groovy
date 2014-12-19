package org.toddelvers.polynomial

import spock.lang.Specification
import spock.lang.Unroll

class PolynomialFormatterTest extends Specification {

    @Unroll
    def "correctly formats '#polynomial' into '#formattedPolynomial'"() {
        when:
            def result = PolynomialFormatter.format(polynomial)

        then:
            result == formattedPolynomial

        where:
            polynomial                         | formattedPolynomial
            [-1]                               | '-1'
            [0]                                | '0'
            [3, 1]                             | '3 + 1x'
            [0, 2]                             | '2x'
            [1, 0, 4]                          | '1 + 4x^2'
            [1, 0, 0, 4]                       | '1 + 4x^3'
            [1, 2, 3, 4]                       | '1 + 2x + 3x^2 + 4x^3'
            [1, -2]                            | '1 - 2x'
            [1, 2, 3, 4, 1, 2, 3, 4, 1, -2, 4] | '1 + 2x + 3x^2 + 4x^3 + 1x^4 + 2x^5 + 3x^6 + 4x^7 + 1x^8 - 2x^9 + 4x^10'
    }

}

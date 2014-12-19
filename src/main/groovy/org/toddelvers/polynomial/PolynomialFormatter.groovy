package org.toddelvers.polynomial

import groovy.transform.CompileStatic

@CompileStatic
class PolynomialFormatter {

    /**
     * <p>
     *      Formats a given polynomial into a human-readable polynomial.
     * </p>
     *
     * <p>
     *      For example, here are polynomials and their human-readable format:
     *      <pre>
     *          [-1]          --> -1
     *          [0]           --> 0
     *          [3, 1]        --> 3 + 1x
     *          [0, 2]        --> 2x
     *          [1, 0, 4]     --> 1 + 4x^2
     *          [1, 0, 0, 4]  --> 1 + 4x^3
     *          [1, -2, 0, 4] --> 1 - 2x + 4x^3
     *          [1, 2, 3, 4]  --> 1 + 2x + 3x^2 + 4x^3
     *      </pre>
     * </p>
     *
     * @param polynomial the polynomial (as a list of integers) to convert to a human-readable format
     */
    static String format(List<Integer> polynomial){
        List<String> terms = []

        polynomial.eachWithIndex { value, index ->
            if (index == 0) {
                if (polynomial.size() == 1 || value != 0) {
                    terms << (value as String)
                }
            } else {
                if (value) {
                    String exponent = (index == 1) ? 'x' : "x^${index}"
                    terms << "${value}${exponent}".toString()
                }
            }
        }

        return terms.join(' + ').replace(' + -', ' - ')
    }

}

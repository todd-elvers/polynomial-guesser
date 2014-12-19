package org.toddelvers.polynomial

class PolynomialGuesser {

    /**
     * Given some polynomial with positive coefficients, this method will attempt to guess the
     * coefficients for that polynomial.  To guess the coefficients, this method requires the
     * the result of your polynomial for P(1) and P(P(1) + 1).
     *
     * <p>
     *     For example, consider the polynomial 2 + 3x + 5x^2 + 4x^3:   <br/>
     *     <pre>
         *     P(1)             = 14
         *     P(15)            = 14672
         *     guess(14, 14672) = [2, 3, 5, 4]
         *     [2, 3, 5, 4]     = 2 + 3x + 5x^2 + 4x^3
     *     </pre>
     * </p>
     *
     *
     * @param resultOfP_1 the result of your polynomial when x = 1
     * @param resultOfP_P1Plus1 the result of your polynomial when x = p(1)+1
     * @return the coefficients of your polynomial
     */
    static List<Integer> guess(BigInteger resultOfP_1, BigInteger resultOfP_P1Plus1){
        BigInteger n = resultOfP_1 + 1
        BigInteger yi = resultOfP_P1Plus1
        BigInteger ai

        List<Integer> coefficients = []
        while (yi > 0) {
            ai = yi.mod(n)
            coefficients << ai.intValue()
            yi = (yi - ai) / n
        }

        return coefficients
    }

    /**
     * Convenience method for <code>guess(BigInteger, BigInteger)</code> to allow for integers as input.
     *
     * @param pOne the result of your polynomial when x = 1
     * @param pOnePlusOne the result of your polynomial when x = p(1)+1
     * @return the coefficients of your polynomial
     */
    static List<Integer> guess(Integer p1, Integer p15){
        return guess(new BigInteger(p1), new BigInteger(p15))
    }

}

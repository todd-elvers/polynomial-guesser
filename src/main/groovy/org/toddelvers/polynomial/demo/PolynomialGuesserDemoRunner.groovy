package org.toddelvers.polynomial.demo

import org.toddelvers.polynomial.PolynomialGuesser
import org.toddelvers.polynomial.PolynomialFormatter

class PolynomialGuesserDemoRunner {

    //TODO: Correct project name
    //TODO: Publish to github
    static void main(String[] args) {
        BigInteger resultOfP_1
        BigInteger resultOfP_P1Plus1

        System.in.withReader {
            print("p(1): ")
            resultOfP_1 = new BigInteger(it.readLine())  //p(1)+1

            print "p(${resultOfP_1 + 1}): "
            resultOfP_P1Plus1 = new BigInteger(it.readLine()) //p(N)
        }

        List<Integer> coefficients = PolynomialGuesser.guess(resultOfP_1, resultOfP_P1Plus1)
        String polynomial = PolynomialFormatter.format(coefficients)
        println polynomial
    }

}

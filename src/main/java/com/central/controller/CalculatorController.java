package com.central.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.central.calculator.Calculator;
import com.central.calculator.operation.Division;
import com.central.calculator.operation.Multiplication;
import com.central.calculator.operation.Subtraction;

@RestController
public class CalculatorController {


    @RequestMapping(value = "/addition/{param1}/{param2}", method = RequestMethod.GET)
    public String getAddition(@PathVariable String param1, @PathVariable String param2) {

        System.out.println("param1: " + param1);
        System.out.println("param2: " + param2);
        try {

            double paramd1 = Double.parseDouble(param1);
            double paramd2 = Double.parseDouble(param2);


            double result = Calculator.getInstance().makeCalculation(paramd1, paramd2, ((double a, double b) -> a + b));
            return String.valueOf(result);

        } catch (Exception e) {
            System.out.println(e);
            return "invalid input";
        }
    }

    @RequestMapping(value = "/subtraction/{param1}/{param2}", method = RequestMethod.GET)
    public String getSubtraction(@PathVariable String param1, @PathVariable String param2) {

        System.out.println("param1: " + param1);
        System.out.println("param2: " + param2);
        try {


            double paramd1 = Double.parseDouble(param1);
            double paramd2 = Double.parseDouble(param2);

            double result = Calculator.getInstance().makeCalculation(paramd1, paramd2, new Subtraction());
            return String.valueOf(result);

        } catch (Exception e) {
            System.out.println(e);
            return "invalid input";
        }
    }

    @RequestMapping(value = "/multlipication/{param1}/{param2}", method = RequestMethod.GET)
    public String getMultiplication(@PathVariable String param1, @PathVariable String param2) {

        System.out.println("param1: " + param1);
        System.out.println("param2: " + param2);
        try {


            double paramd1 = Double.parseDouble(param1);
            double paramd2 = Double.parseDouble(param2);

            double result = Calculator.getInstance().makeCalculation(paramd1, paramd2, new Multiplication());
            return String.valueOf(result);

        } catch (Exception e) {
            System.out.println(e);
            return "invalid input";
        }
    }

    @RequestMapping(value = "/division/{param1}/{param2}", method = RequestMethod.GET)
    public String getDivision(@PathVariable String param1, @PathVariable String param2) {

        System.out.println("param1: " + param1);
        System.out.println("param2: " + param2);
        try {


            double paramd1 = Double.parseDouble(param1);
            double paramd2 = Double.parseDouble(param2);

            double result = Calculator.getInstance().makeCalculation(paramd1, paramd2, new Division());
            return String.valueOf(result);

        } catch (Exception e) {
            System.out.println(e);
            return "invalid input";
        }
    }
}

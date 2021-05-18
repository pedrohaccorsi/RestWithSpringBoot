package br.com.erudio.math;

import br.com.erudio.exception.UnsuportedMathOperationException;

public class Calculator {
    
    public static enum Operation{
        SUM,
        SUB,
        DIV,
        MUL
    }

    public static Double calculate(String number1, String number2, Operation operation) throws UnsuportedMathOperationException{

        if(!isNumeric(number1) || !isNumeric(number2)){
            throw new UnsuportedMathOperationException("Please use a numeric value");
        }

        switch(operation){
            case SUM:  return convertToDouble(number1) + convertToDouble(number2);
            case SUB:  return convertToDouble(number1) - convertToDouble(number2);
            case DIV:  return convertToDouble(number1) / convertToDouble(number2);
            case MUL: return convertToDouble(number1) * convertToDouble(number2);
            default: throw new UnsuportedMathOperationException("Please use a supported operation");
        }
    }

    private static boolean isNumeric(String number){
        if(number == null)
            return false;
        return number.replaceAll(",", ".").matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    private static Double convertToDouble(String number){
        return Double.parseDouble(number);
    }

}

package edu.epam.figure.validator;

import edu.epam.figure.action.Calculator;
import edu.epam.figure.entity.Point;
import edu.epam.figure.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TetraValidator {
    public static final String TETRA_REGEX = "((-|\\+)?[0-9]+(\\.[0-9])?(\\s)?){12}";
    private static Logger logger = LogManager.getLogger();

    public boolean checkData(String input) throws CustomException{
        if(input == null || input.isEmpty()){
            throw new CustomException("Input string is null or empty");
        }
        if (input.matches(TETRA_REGEX)){
            return true;
        }
        else {
            throw new CustomException("Incorrect string");
        }
    }

    public boolean correctPoints(Point a, Point b, Point c, Point d){
        Calculator calculator = new Calculator();
        return !calculator.isOnePlane(a,b,c,d);
    }


}

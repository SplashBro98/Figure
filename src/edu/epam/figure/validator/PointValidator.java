package edu.epam.figure.validator;

import edu.epam.figure.exception.CustomException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PointValidator {
    public static final String TETRA_REGEX = "((-|\\+)?[\\d]+(\\.[\\d])?(\\s)?){12}";
    private static Logger logger = LogManager.getLogger();

    public boolean checkData(String input){
        if(input == null || input.isEmpty()){
            logger.log(Level.ERROR,"Input string is null or empty");
            return false;
        }
        if (input.matches(TETRA_REGEX)){
            return true;
        }
        else {
            logger.log(Level.ERROR,"String: " + input + " is incorrect");
            return false;
        }
    }
}

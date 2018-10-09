package edu.epam.figure.validator;

import edu.epam.figure.action.Calculator;
import edu.epam.figure.entity.Point;
import edu.epam.figure.exception.CustomException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TetraValidator {

    private static Logger logger = LogManager.getLogger();

    public boolean isCorrectPoints(Point a, Point b, Point c, Point d){
        Calculator calculator = new Calculator();
        if(calculator.isOnePlane(a,b,c,d)){
            return false;
        }
        Point[][] array = {{a,b},{a,c},{a,d},{b,c},{b,d},{c,d}};
        int i = 0;
        while(i < array.length){
            if(isNotEqualPoints(array[i][0],array[i][1])){
                return false;
            }
            i++;
        }
        return true;
    }

    private boolean isNotEqualPoints(Point a, Point b){
        return a.equalsIgnoreId(b);
    }


}

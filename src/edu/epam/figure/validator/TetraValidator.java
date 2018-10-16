package edu.epam.figure.validator;

import edu.epam.figure.action.Calculator;
import edu.epam.figure.entity.Point;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TetraValidator {

    private static Logger logger = LogManager.getLogger();

    public boolean isCorrectPoints(Point a, Point b, Point c, Point d){
        Calculator calculator = new Calculator();
        if(calculator.isOnePlane(a,b,c,d)){
            logger.log(Level.INFO, "These points create one plane, that`s why we can`t create a tetrahedron");
            return false;
        }
        Point[][] array = {{a,b},{a,c},{a,d},{b,c},{b,d},{c,d}};
        int i = 0;
        while(i < array.length){
            if(isNotEqualPoints(array[i][0],array[i][1])){
                logger.log(Level.INFO, "There are two or more equal points");
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

package edu.epam.figure.action;

import edu.epam.figure.entity.Point;
import edu.epam.figure.entity.Tetrahedron;
import edu.epam.figure.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.lang.Math.pow;

public class ActionTest {
    private static final String PATH = "input\\test.txt";
    private Calculator calculator;

    @BeforeClass
    public void setUp(){
        calculator = new Calculator();
    }

    @Test
    public void checkSquarePositive(){
        Point A = new Point(0,0,0);
        Point B = new Point(0,1,0);
        Point C = new Point(1,0,0);
        Point D = new Point(0,0,1);
        try {
            Tetrahedron tetrahedron = new Tetrahedron(A,B,C,D);
            double actual = calculator.calculateSquare(tetrahedron);
            double expected = (3 + pow(3,0.5))/2;
            Assert.assertEquals(actual,expected);
        }catch (CustomException e){
            throw new RuntimeException(e);
        }
    }

    @Test
    public void checkVolumePositive(){
        Point A = new Point(0,0,0);
        Point B = new Point(0,1,0);
        Point C = new Point(1,0,0);
        Point D = new Point(0,0,1);
        try{
            Tetrahedron tetrahedron = new Tetrahedron(A,B,C,D);
            double actual = calculator.calculateVolume(tetrahedron);
            double expected = 1/6.0;
            Assert.assertEquals(actual,expected);
        }catch (CustomException e){
            throw new RuntimeException(e);
        }
    }


}

package edu.epam.figure.validation;

import edu.epam.figure.entity.Point;
import edu.epam.figure.entity.Tetrahedron;
import edu.epam.figure.validator.PointValidator;
import edu.epam.figure.validator.TetraValidator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class ValidTest {
    private TetraValidator tetraValidator;
    private PointValidator pointValidator;

    @BeforeClass
    public void setUp(){
        pointValidator = new PointValidator();
        tetraValidator = new TetraValidator();
    }

    @DataProvider(name = "forCheckStringPos")
    public Object[][] forCheckStringPos(){
        return new Object[][]{
                {"2 3 4 5 6 7 8 9 10 11 12 13",true},
                {"0 0 0 0 0 0 0 0 0 0 0 0", true},
                {"0 0 0 0 1 0 1 0 0 0 0 1.0", true},
                {"1.0 1.0 1.0 2.0 2.0 2.0 3.0 3.0 3.0 4.0 4.0 4.0", true},
        };
    }

    @Test(dataProvider = "forCheckStringPos")
    public void checkStringPositive(String input, boolean expected){
        boolean actual = pointValidator.checkData(input);
        Assert.assertEquals(actual,expected);
    }

    @DataProvider(name = "checkStringNeg")
    public Object[][] checkStringNeg(){
        return new Object[][]{
                {"", false},
                {null, false},
                {"tutkuku", false},
                {"0 0 0 0 0 0", false},
                {"0 0 0 0 1s 0 1 0 0.. 0 a", false},
                {"1.0 1.0 1.f0 2.0 2.0 2.0 3.0 3.0 3.0 4.0 4.0 4.0", false},
                {"1.0 1.0 1.f0 2.0 2.0 2.0 3.0 3.0 3.0 4.0 4.0 4.0 5.0", false},
        };
    }
    @Test(dataProvider = "checkStringNeg")
    public void checkStringNegative(String input, boolean expected){
        boolean actual = pointValidator.checkData(input);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void correctPointsTest(){
        Point a = new Point(1.0,1.0,1.0);
        Point b = new Point(3.0,3.0,3.0);
        Point c = new Point(-2.0,-2.0,-2.0);
        Point d = new Point(4.0,4.0,4.0);
        boolean actual = tetraValidator.isCorrectPoints(a,b,c,d);
        boolean expected = false;
        Assert.assertEquals(actual, expected);
    }

    @Test(timeOut = 100)
    public void validTimeTest(){
        Point a = new Point(1.0,1.0,1.0);
        Point b = new Point(1.0,1.0,1.0);
        Point c = new Point(-2.0,-2.0,-2.0);
        Point d = new Point(4.0,4.0,4.0);
        Tetrahedron tetr = new Tetrahedron(a,b,c,d);
    }
}

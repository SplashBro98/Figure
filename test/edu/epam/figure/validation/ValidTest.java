package edu.epam.figure.validation;

import edu.epam.figure.exception.CustomException;
import edu.epam.figure.validator.TetraValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValidTest {
    private TetraValidator validator;

    @BeforeClass
    public void setUp(){
        validator = new TetraValidator();
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
    public void checkStringPositive(String input, boolean expected) throws CustomException {
        boolean actual = validator.checkData(input);
        Assert.assertEquals(actual,expected);
    }

    @DataProvider(name = "forCheckStringNeg")
    public Object[][] forCheckStringNeg(){
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
    @Test(dataProvider = "forCheckStringNeg")
    public void checkStringNegative(String input, boolean expected) throws CustomException{
        boolean actual = validator.checkData(input);
        Assert.assertEquals(actual,expected);
    }
}

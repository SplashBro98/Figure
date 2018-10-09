package edu.epam.figure.pattern;

import edu.epam.figure.action.Calculator;
import edu.epam.figure.entity.Point;
import edu.epam.figure.entity.Tetrahedron;
import edu.epam.figure.exception.CustomException;
import edu.epam.figure.validator.TetraValidator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ObserverTest {
    private Calculator calculator;
    private TetraValidator tetraValidator;

    @BeforeClass
    public void setUp(){
        calculator = new Calculator();
        tetraValidator = new TetraValidator();
    }

}

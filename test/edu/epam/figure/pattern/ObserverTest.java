package edu.epam.figure.pattern;

import edu.epam.figure.action.Calculator;
import edu.epam.figure.entity.Point;
import edu.epam.figure.entity.TetraKeeper;
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

    @Test
    public void TetraObserveTestPositive() throws CustomException {
        Point[] array = {new Point(0,0,0), new Point(1,0,0), new Point(0,1,0), new Point(0,0,1)};
        Point[] array1 = {new Point(0,0,0), new Point(1,0,0), new Point(0,1,0), new Point(0,0,3)};
        Point[] array2 = {new Point(0,0,0), new Point(1,0,0), new Point(0,1,0), new Point(0,0,4)};
        Tetrahedron tetr = new Tetrahedron(array[0],array[1],array[2],array[3]);
        Tetrahedron tetr1 = new Tetrahedron(array1[0],array1[1],array1[2],array1[3]);
        Tetrahedron tetr2 = new Tetrahedron(array2[0],array2[1],array2[2],array2[3]);
        TetraKeeper tetraKeeper = new TetraKeeper(new ArrayList<>());
        tetraKeeper.addTetrahedron(tetr);
        tetraKeeper.addTetrahedron(tetr2);
        tetraKeeper.addTetrahedron(tetr1);


        tetr.addObserver(calculator);
        tetr.addObserver(tetraKeeper);
        tetr.setD(new Point(0,0,9));
        double actual = tetr.getVolume();
        double expected = 1.5;

        System.out.println("Now: ");
        Assert.assertEquals(actual,expected);
    }
}

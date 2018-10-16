package edu.epam.figure.action;

import edu.epam.figure.entity.Point;
import edu.epam.figure.entity.Tetrahedron;
import edu.epam.figure.exception.CustomException;
import edu.epam.figure.reader.TetraReader;
import edu.epam.figure.repository.TetraRepository;
import edu.epam.figure.transformer.PointTransformer;
import edu.epam.figure.validator.PointValidator;
import edu.epam.figure.validator.TetraValidator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class PlaneCheckerTest {
    private PlaneChecker checker;

    @BeforeClass
    public void setUp() {
        checker = new PlaneChecker();
    }

    @Test
    public void testIsOnPlaneX(){
        Point a = new Point(1.0,1.0,1.0);
        Point b = new Point(3.0,3.0,5.0);
        Point c = new Point(-2.0,-6.0,-2.0);
        Point d = new Point(4.0,4.0,4.0);
        Tetrahedron tetr = new Tetrahedron(a,b,c,d);
        boolean actual = checker.isOnPlaneX(tetr);
        boolean expected = false;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testIsOnPlaneY(){
        Point a = new Point(1.0,0.0,1.0);
        Point b = new Point(3.0,0.0,3.0);
        Point c = new Point(6.0,0.0,-2.0);
        Point d = new Point(4.0,8.0,4.0);
        Tetrahedron tetr = new Tetrahedron(a,b,c,d);
        boolean actual = checker.isOnPlaneY(tetr);
        boolean expected = true;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testIsOnPlaneZ(){
        Point a = new Point(1.0,2.0,0.0);
        Point b = new Point(3.0,3.0,0.0);
        Point c = new Point(6.0,4.0,0.0);
        Point d = new Point(0.0,8.0,4.0);
        Tetrahedron tetr = new Tetrahedron(a,b,c,d);
        boolean actual = checker.isOnPlaneZ(tetr);
        boolean expected = true;
        Assert.assertEquals(actual, expected);
    }
}
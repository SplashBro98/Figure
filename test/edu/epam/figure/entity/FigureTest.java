package edu.epam.figure.entity;

import edu.epam.figure.exception.CustomException;
import edu.epam.figure.factory.Figure3D;
import edu.epam.figure.factory.Figure3DMaker;
import edu.epam.figure.factory.TetraMaker;
import edu.epam.figure.reader.TetraReader;
import edu.epam.figure.transformer.PointTransformer;
import edu.epam.figure.validator.PointValidator;
import edu.epam.figure.validator.TetraValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class FigureTest {
    private static final String PATH = "input\\test.txt";
    private PointValidator validator;
    private TetraValidator tetraValidator;
    private Figure3DMaker maker;
    private TetraReader reader;
    private PointTransformer transformer;

    @BeforeClass
    public void setUp() {
        validator = new PointValidator();
        maker = new TetraMaker();
        reader = new TetraReader();
        transformer = new PointTransformer();
        tetraValidator = new TetraValidator();
    }

    @Test
    public void maintest() {
        List<String> list = reader.readInfo(PATH);
        ArrayList<Figure3D> array = new ArrayList<>();
        for (String input : list) {
            if (validator.checkData(input)) {
                Point[] points = transformer.createPoints(input);
                if (tetraValidator.isCorrectPoints(points[0], points[1], points[2], points[3])) {
                    array.add(maker.createFigure(points));
                }
            }
        }
        for (Figure3D figure : array) {
            System.out.println(figure.toString());
        }
        int actual = array.size();
        int expected = 4;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void equalTestPositive() {
        Tetrahedron tetr1 = new Tetrahedron(new Point(1, 0, 1), new Point(2, 2, 10), new Point(3, 5, 3), new Point(4, 4, 4));
        Tetrahedron tetr2 = tetr1;
        boolean actual = tetr1.equals(tetr2);
        Assert.assertTrue(actual);
    }

    @Test
    public void equalTestNegative() {
        Tetrahedron tetr1 = new Tetrahedron(new Point(1, 0, 1), new Point(2, 2, 10), new Point(3, 5, 3), new Point(4, 4, 4));
        Tetrahedron tetr2 = new Tetrahedron(new Point(1, 0, 1), new Point(2, 2, 10), new Point(3, 5, 3), new Point(4, 4, 4));
        Assert.assertNotEquals(tetr1, tetr2);
    }

    @Test
    public void equalIgnoreId() {
        Tetrahedron tetr1 = new Tetrahedron(new Point(1, 0, 1), new Point(2, 2, 10), new Point(3, 5, 3), new Point(4, 4, 4));
        Tetrahedron tetr2 = new Tetrahedron(new Point(1, 0, 1), new Point(2, 2, 10), new Point(3, 5, 3), new Point(4, 4, 4));
        boolean actual = tetr1.equalsIgnoreId(tetr2);
        boolean expected = true;
        Assert.assertEquals(actual, expected);
    }


}

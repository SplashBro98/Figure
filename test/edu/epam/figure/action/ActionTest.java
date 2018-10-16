package edu.epam.figure.action;

import edu.epam.figure.entity.Point;
import edu.epam.figure.entity.Tetrahedron;
import edu.epam.figure.exception.CustomException;

import static edu.epam.figure.pattern.SpecificationTest.*;

import edu.epam.figure.reader.TetraReader;
import edu.epam.figure.repository.TetraRepository;
import edu.epam.figure.transformer.PointTransformer;
import edu.epam.figure.validator.PointValidator;
import edu.epam.figure.validator.TetraValidator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

public class ActionTest {
    private static final String PATH = "input\\test.txt";
    private Calculator calculator;
    private List<String> stringList;
    private static List<Tetrahedron> tetrahedrons = new ArrayList<>();

    public static List<Tetrahedron> getTetrahedrons() {
        return tetrahedrons;
    }

    @BeforeSuite
    public void fillRepository(){
        PointValidator pointValidator = new PointValidator();
        calculator = new Calculator();
        TetraReader reader = new TetraReader();
        PointTransformer transformer = new PointTransformer();
        TetraValidator tetraValidator = new TetraValidator();
        stringList = reader.readInfo(PATH);
        for (String input : stringList) {
            if (pointValidator.checkData(input)) {
                Point[] points = transformer.createPoints(input);
                if (tetraValidator.isCorrectPoints(points[0], points[1], points[2], points[3])) {
                    Tetrahedron tetr = new Tetrahedron(points[0], points[1], points[2], points[3]);
                    TetraRepository.INSTANCE.add(tetr);
                    tetrahedrons.add(tetr);
                }
            }
        }
    }


    @Test
    public void checkSquarePositive() {
        Point A = new Point(0, 0, 0);
        Point B = new Point(0, 1, 0);
        Point C = new Point(1, 0, 0);
        Point D = new Point(0, 0, 1);
        Tetrahedron tetrahedron = new Tetrahedron(A, B, C, D);
        double actual = calculator.calculateSquare(tetrahedron);
        double expected = (3 + pow(3, 0.5)) / 2;
        Assert.assertEquals(actual, expected);

    }

    @Test
    public void checkVolumePositive() {
        Point A = new Point(0, 0, 0);
        Point B = new Point(0, 1, 0);
        Point C = new Point(1, 0, 0);
        Point D = new Point(0, 0, -1);
        Tetrahedron tetrahedron = new Tetrahedron(A, B, C, D);
        double actual = calculator.calculateVolume(tetrahedron);
        double expected = 1 / 6.0;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void checkPerimetrPositive() {
        Point A = new Point(0, 0, 0);
        Point B = new Point(0, 1, 0);
        Point C = new Point(1, 0, 0);
        Point D = new Point(0, 0, 1);
        Tetrahedron tetrahedron = new Tetrahedron(A, B, C, D);
        double actual = calculator.calculatePerimetr(tetrahedron);
        double expected = 3 * (1 + pow(2, 0.5));
        Assert.assertEquals(actual, expected);
    }


}

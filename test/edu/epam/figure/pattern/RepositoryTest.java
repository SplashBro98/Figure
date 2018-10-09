package edu.epam.figure.pattern;

import edu.epam.figure.entity.Point;
import edu.epam.figure.entity.Tetrahedron;
import edu.epam.figure.factory.Figure3D;
import edu.epam.figure.factory.Figure3DMaker;
import edu.epam.figure.factory.TetraMaker;
import edu.epam.figure.reader.TetraReader;
import edu.epam.figure.register.TetraRegister;
import edu.epam.figure.repository.TetraRepository;
import edu.epam.figure.transformer.PointTransformer;
import edu.epam.figure.validator.PointValidator;
import edu.epam.figure.validator.TetraValidator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RepositoryTest {
    private static final String PATH = "input\\test.txt";
    private PointValidator validator;
    private TetraValidator tetraValidator;
    private Figure3DMaker maker;
    private TetraReader reader;
    private PointTransformer transformer;
    private TetraRepository tetraRepository;
    private TetraRegister register;
    private List<String> stringList;

    @BeforeClass
    public void setUp() {
        validator = new PointValidator();
        maker = new TetraMaker();
        reader = new TetraReader();
        transformer = new PointTransformer();
        tetraValidator = new TetraValidator();
        tetraRepository = TetraRepository.INSTANCE;
        register = TetraRegister.getInstance();
        stringList = reader.readInfo(PATH);
        for (String input : stringList) {
            if (validator.checkData(input)){
                Point[] points = transformer.createPoints(input);
                if (tetraValidator.isCorrectPoints(points[0], points[1], points[2], points[3])) {
                    tetraRepository.add(new Tetrahedron(points[0],points[1],points[2],points[3]));
                }
            }
        }
    }

    @Test
    public void linkRepositoryAndRegister(){
        int actual = register.getParametrs().size();
        int expected = tetraRepository.getAmount();
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void sortTest(){
        System.out.println(tetraRepository.toString());
        System.out.println(register.toString());
        tetraRepository.sort(new Comparator<Tetrahedron>() {
            @Override
            public int compare(Tetrahedron o1, Tetrahedron o2) {
                double volume1 = register.getParametrs().get(o1.getTetraId()).getVolume();
                double volume2 = register.getParametrs().get(o2.getTetraId()).getVolume();
                return Double.compare(volume1,volume2);
            }
        });
        System.out.println(tetraRepository.toString());

    }
}

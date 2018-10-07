package edu.epam.figure.entity;

import edu.epam.figure.exception.CustomException;
import edu.epam.figure.factory.Figure3D;
import edu.epam.figure.factory.Figure3DMaker;
import edu.epam.figure.factory.TetraMaker;
import edu.epam.figure.reader.TetraReader;
import edu.epam.figure.transformer.PointTransformer;
import edu.epam.figure.validator.PointValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class FigureTest {
    private static final String PATH = "input\\test.txt";
    private static Logger logger = LogManager.getLogger();
    private PointValidator validator;
    private Figure3DMaker maker;
    private TetraReader reader;
    private PointTransformer transformer;

    @BeforeClass
    public void setUp(){
        validator = new PointValidator();
        maker = new TetraMaker();
        reader = new TetraReader();
        transformer = new PointTransformer();
    }

    @Test
    public void maintest(){
        List<String> list = reader.readInfo(PATH);
        ArrayList<Figure3D> array = new ArrayList<>();
        for(String input : list){
           try{
               array.add(maker.createFigure(transformer.createPoints(input)));
           }catch (CustomException e){

           }
        }
        for(Figure3D figure : array){
            System.out.println(figure.toString());
        }
        int actual = array.size();
        int expected = 4;
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void equalTestPositive(){
        try{
            Tetrahedron tetr1 = new Tetrahedron(new Point(1,0,1),new Point(2,2,10),new Point(3,5,3),new Point(4,4,4));
            Tetrahedron tetr2 = tetr1;
            Assert.assertEquals(tetr1,tetr2);
        }catch (CustomException e){
            throw new RuntimeException(e);
        }
    }

    @Test
    public void equalTestNegative(){
        try{
            Tetrahedron tetr1 = new Tetrahedron(new Point(1,0,1),new Point(2,2,10),new Point(3,5,3),new Point(4,4,4));
            Tetrahedron tetr2 = new Tetrahedron(new Point(1,0,1),new Point(2,2,10),new Point(3,5,3),new Point(4,4,4));
            Assert.assertNotEquals(tetr1,tetr2);
        }catch (CustomException e){
            throw new RuntimeException(e);
        }
    }

    @Test
    public void equalIgnoreId(){
        try{
            Tetrahedron tetr1 = new Tetrahedron(new Point(1,0,1),new Point(2,2,10),new Point(3,5,3),new Point(4,4,4));
            Tetrahedron tetr2 = new Tetrahedron(new Point(1,0,1),new Point(2,2,10),new Point(3,5,3),new Point(4,4,4));
            boolean actual = tetr1.equalsIgnoreId(tetr2);
            boolean expected = true;
            Assert.assertEquals(actual, expected);
        }catch (CustomException e){
            throw new RuntimeException(e);
        }
    }


}

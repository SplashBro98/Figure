package edu.epam.figure.entity;

import edu.epam.figure.factory.Figure3D;
import edu.epam.figure.repository.TetraRepository;
import edu.epam.figure.specification.EveryFigureSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FigureTest {



    @Test
    public void maintest() {
        List<Tetrahedron> tetrahedronList = TetraRepository.INSTANCE.query(new EveryFigureSpecification());
        for (Figure3D figure : tetrahedronList) {
            System.out.println(figure.toString());
        }
        int actual = tetrahedronList.size();
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

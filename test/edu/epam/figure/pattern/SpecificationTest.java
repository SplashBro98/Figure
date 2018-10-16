package edu.epam.figure.pattern;

import edu.epam.figure.action.ActionTest;
import edu.epam.figure.entity.Tetrahedron;
import edu.epam.figure.repository.TetraRepository;
import edu.epam.figure.specification.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SpecificationTest {


    @Test
    public void allSpecificationTest(){
        Assert.assertEquals(ActionTest.getTetrahedrons(), TetraRepository.INSTANCE.query(new EveryFigureSpecification()));
    }

    @Test
    public void volumeBetweenSpecification(){
        List<Tetrahedron> expected = new ArrayList<>();
        expected.add(ActionTest.getTetrahedrons().get(1));
        expected.add(ActionTest.getTetrahedrons().get(2));
        Specification specification = new VolumeBetweenSpecification(4.0,7.0);
        List<Tetrahedron> actual = TetraRepository.INSTANCE.query(specification);
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void findByIdSpecification(){
        List<Tetrahedron> expected = new ArrayList<>();
        expected.add(ActionTest.getTetrahedrons().get(0));
        Specification specification = new FindByIdSpecification(1);
        List<Tetrahedron> actual = TetraRepository.INSTANCE.query(specification);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void higherPlaneSpecification(){
        List<Tetrahedron> expected = new ArrayList<>();
        expected.add(ActionTest.getTetrahedrons().get(0));
        expected.add(ActionTest.getTetrahedrons().get(1));
        expected.add(ActionTest.getTetrahedrons().get(2));
        Specification specification = new HigherPlaneSpecification();
        List<Tetrahedron> actual = TetraRepository.INSTANCE.query(specification);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void squareBetweenSpecification(){
        List<Tetrahedron> expected = new ArrayList<>();
        expected.add(ActionTest.getTetrahedrons().get(1));
        expected.add(ActionTest.getTetrahedrons().get(2));
        Specification specification = new SquareBetweenSpecification(8.0,10.0);
        List<Tetrahedron> actual = TetraRepository.INSTANCE.query(specification);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void volumeLargerSpecification(){
        List<Tetrahedron> expected = new ArrayList<>();
        expected.add(ActionTest.getTetrahedrons().get(0));
        expected.add(ActionTest.getTetrahedrons().get(1));
        Specification specification = new VolumeLargerSpecification(5.0);
        List<Tetrahedron> actual = TetraRepository.INSTANCE.query(specification);
        Assert.assertEquals(actual, expected);
    }



}

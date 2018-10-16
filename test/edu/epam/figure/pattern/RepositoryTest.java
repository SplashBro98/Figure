package edu.epam.figure.pattern;

import edu.epam.figure.action.ActionTest;
import edu.epam.figure.action.Calculator;
import edu.epam.figure.entity.Point;
import edu.epam.figure.entity.Tetrahedron;
import edu.epam.figure.reader.TetraReader;
import edu.epam.figure.observer.TetraObserverImpl;
import edu.epam.figure.repository.TetraRepository;
import edu.epam.figure.specification.EveryFigureSpecification;
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






    @Test
    public void linkRepositoryAndRegister(){
        int actual = TetraObserverImpl.getInstance().getParametrs().size();
        int expected = TetraRepository.INSTANCE.getAmount();
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void sortTest(){
        TetraRepository.INSTANCE.sort(new Comparator<Tetrahedron>() {
            @Override
            public int compare(Tetrahedron o1, Tetrahedron o2) {
                double volume1 = TetraObserverImpl.getInstance().getParametrs().get(o1.getTetraId()).getVolume();
                double volume2 = TetraObserverImpl.getInstance().getParametrs().get(o2.getTetraId()).getVolume();
                return Double.compare(volume1,volume2);
            }
        });
        List<Tetrahedron> actual = TetraRepository.INSTANCE.query(new EveryFigureSpecification());
        List<Tetrahedron> expected = new ArrayList<>();
        expected.add(ActionTest.getTetrahedrons().get(3));
        expected.add(ActionTest.getTetrahedrons().get(2));
        expected.add(ActionTest.getTetrahedrons().get(1));
        expected.add(ActionTest.getTetrahedrons().get(0));
        Assert.assertEquals(actual, expected);

    }
}

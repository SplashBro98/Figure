package edu.epam.figure.pattern;


import edu.epam.figure.entity.Point;
import edu.epam.figure.entity.Tetrahedron;
import edu.epam.figure.observer.TetraObserverImpl;
import edu.epam.figure.repository.TetraRepository;
import org.testng.Assert;
import org.testng.annotations.Test;



public class ObserverTest {


    @Test
    public void observeTest(){
        Tetrahedron tetr1 = new Tetrahedron(new Point(0, 0, 0), new Point(1, 0, 0), new Point(0, 1, 0), new Point(0, 0, 1));
        tetr1.addObserver(TetraObserverImpl.getInstance());
        TetraRepository.INSTANCE.add(tetr1);
        long id = tetr1.getTetraId();
        System.out.println(TetraObserverImpl.getInstance().getParametrs().get(id).getVolume());
        tetr1.setD(new Point(0,0,6));
        double actual = TetraObserverImpl.getInstance().getParametrs().get(id).getVolume();
        double expected = 1.0;
        Assert.assertEquals(actual, expected);
    }

}

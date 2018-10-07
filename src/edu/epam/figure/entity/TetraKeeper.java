package edu.epam.figure.entity;

import edu.epam.figure.comparator.TetraPerimetrComparator;
import edu.epam.figure.comparator.TetraSquareComparator;
import edu.epam.figure.comparator.TetraVolumeComparator;
import edu.epam.figure.observer.Observer;

import java.util.List;

public class TetraKeeper implements Observer{
    List<Tetrahedron> tetrahedrons;
    TetraSquareComparator squareComparator = new TetraSquareComparator();
    TetraVolumeComparator volumeComparator = new TetraVolumeComparator();
    TetraPerimetrComparator perimetrComparator = new TetraPerimetrComparator();

    public TetraKeeper(List<Tetrahedron> tetrahedrons) {
        this.tetrahedrons = tetrahedrons;
        this.tetrahedrons.sort(volumeComparator.thenComparing(squareComparator));
    }

    public void addTetrahedron(Tetrahedron tetr){
        tetrahedrons.add(tetr);
        tetrahedrons.sort(volumeComparator.thenComparing(squareComparator));
    }
    public void removeTetrahedron(Tetrahedron tetr){
        tetrahedrons.remove(tetr);
    }

    public List<Tetrahedron> getTetrahedrons() {
        return tetrahedrons;
    }

    @Override
    public void handleEvent(Tetrahedron tetrahedron) {
        tetrahedrons.sort(volumeComparator.thenComparing(squareComparator));
    }
}

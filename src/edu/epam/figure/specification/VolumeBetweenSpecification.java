package edu.epam.figure.specification;

import edu.epam.figure.entity.Tetrahedron;
import edu.epam.figure.observer.TetraObserverImpl;

public class VolumeBetweenSpecification implements Specification<Tetrahedron> {
    private double minVolume;
    private double maxVolume;

    public VolumeBetweenSpecification(double minVolume, double maxVolume) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    public double getMinVolume() {
        return minVolume;
    }

    public void setMinVolume(double minVolume) {
        this.minVolume = minVolume;
    }

    public double getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume(double maxVolume) {
        this.maxVolume = maxVolume;
    }

    @Override
    public boolean specify(Tetrahedron tetrahedron) {
        double volume = TetraObserverImpl.getInstance().getParametrs().get(tetrahedron.getTetraId()).getVolume();
        return (volume > minVolume && volume < maxVolume);
    }
}

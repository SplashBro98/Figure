package edu.epam.figure.specification;

import edu.epam.figure.entity.Tetrahedron;
import edu.epam.figure.register.TetraRegister;

public class VolumeLargerSpecification implements Specification<Tetrahedron> {
    private double currentVolume;

    public VolumeLargerSpecification(double currentVolume) {
        this.currentVolume = currentVolume;
    }

    public double getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(double currentVolume) {
        this.currentVolume = currentVolume;
    }

    @Override
    public boolean specify(Tetrahedron tetrahedron) {
        double volume = TetraRegister.getInstance().getParametrs().get(tetrahedron.getTetraId()).getVolume();
        return (volume > currentVolume);
    }
}

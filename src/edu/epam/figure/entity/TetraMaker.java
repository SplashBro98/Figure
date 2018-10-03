package edu.epam.figure.entity;

import edu.epam.figure.exception.CustomException;

public class TetraMaker implements Figure3DMaker {
    private static final int COUNT_COORD_FOR_TETR = 12;
    @Override
    public Figure3D createFigure(String input) throws CustomException {
        String[] array = input.split(" ");
        double[] coords = new double[COUNT_COORD_FOR_TETR];
        for (int i = 0; i < array.length; i++) {
            coords[i] = Double.parseDouble(array[i]);
        }
        return new Tetrahedron( new Point(coords[0],coords[1],coords[2]),
                                new Point(coords[3],coords[4],coords[5]),
                                new Point(coords[6],coords[7],coords[8]),
                                new Point(coords[9],coords[10],coords[11]));
    }
}

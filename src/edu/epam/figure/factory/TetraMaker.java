package edu.epam.figure.factory;

import edu.epam.figure.entity.Point;
import edu.epam.figure.entity.Tetrahedron;
import edu.epam.figure.exception.CustomException;

public class TetraMaker implements Figure3DMaker {

    @Override
    public Figure3D createFigure(Point[] inputArray) throws CustomException {
        return new Tetrahedron(inputArray[0],inputArray[1],inputArray[2],inputArray[3]);
    }
}

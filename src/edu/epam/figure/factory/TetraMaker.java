package edu.epam.figure.factory;

import edu.epam.figure.entity.Point;
import edu.epam.figure.entity.Tetrahedron;

public class TetraMaker implements Figure3DMaker {

    @Override
    public Figure3D createFigure(Point[] inputArray){
        return new Tetrahedron(inputArray[0],inputArray[1],inputArray[2],inputArray[3]);
    }
}

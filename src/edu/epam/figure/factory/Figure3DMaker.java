package edu.epam.figure.factory;

import edu.epam.figure.entity.Point;
import edu.epam.figure.exception.CustomException;

public interface Figure3DMaker {
    Figure3D createFigure(Point[] inputArray);
}

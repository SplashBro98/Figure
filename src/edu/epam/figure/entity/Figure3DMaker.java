package edu.epam.figure.entity;

import edu.epam.figure.exception.CustomException;

public interface Figure3DMaker {
    Figure3D createFigure(String input) throws CustomException;
}

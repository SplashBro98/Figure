package edu.epam.figure.observer;

import edu.epam.figure.entity.Tetrahedron;

public interface Observer {
    void handleEvent(Tetrahedron tetrahedron);
}

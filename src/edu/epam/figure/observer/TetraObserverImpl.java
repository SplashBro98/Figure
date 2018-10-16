package edu.epam.figure.observer;

import edu.epam.figure.action.Calculator;
import edu.epam.figure.entity.Tetrahedron;
import edu.epam.figure.register.Parametr;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class TetraObserverImpl implements Observer<Tetrahedron> {
    private static Logger logger = LogManager.getLogger();
    private static TetraObserverImpl instance;
    private Map<Long,Parametr> parametrs;

    private TetraObserverImpl() {
       parametrs = new TreeMap<>();
    }

    public static TetraObserverImpl getInstance(){
        if(instance == null){
            instance = new TetraObserverImpl();
        }
        return instance;
    }
    public boolean addTetrahedron(Tetrahedron tetr){
        if(parametrs.containsKey(tetr.getTetraId())){
            logger.log(Level.INFO,"This tetrahedron is already in warehouse");
            return false;
        }
        Calculator calculator = new Calculator();
        double volume = calculator.calculateVolume(tetr);
        double square = calculator.calculateSquare(tetr);
        double perimetr = calculator.calculatePerimetr(tetr);
        Parametr parametr = new Parametr(volume,square,perimetr);
        parametrs.put(tetr.getTetraId(),parametr);
        return true;
    }
    public void removeTetrahedron(long tetraId){
        parametrs.remove(tetraId);
    }

    public Map<Long, Parametr> getParametrs() {
        return Collections.unmodifiableMap(parametrs);
    }

    @Override
    public void handleEvent(Tetrahedron tetrahedron) {
        Calculator calculator = new Calculator();
        double volume = calculator.calculateVolume(tetrahedron);
        double square = calculator.calculateSquare(tetrahedron);
        double perimetr = calculator.calculatePerimetr(tetrahedron);
        Parametr parametr = new Parametr(volume,square,perimetr);
        parametrs.replace(tetrahedron.getTetraId(),parametr);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("TetraObserverImpl: \n");
        parametrs.forEach((Long aLong, Parametr parametr) ->  builder.append("Id: " + aLong +
                    ", volume: " + parametr.getVolume() +
                    ", square: " + parametr.getSquare() +
                    ", perimetr: " + parametr.getPerimetr() + "\n"));
        return builder.toString();
    }
}

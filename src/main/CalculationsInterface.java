package main;

import javafx.util.Pair;

import java.util.List;

public interface CalculationsInterface {

    Double getResult(Pair<List<Double>, List<String>> operations);
}

package net.mims.minnlakes.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Objects;

public class Point {

    @JsonProperty("epsg:26915")
    public ArrayList<Integer> epsg26915;
    @JsonProperty("epsg:4326")
    public ArrayList<Double> epsg4326;

    public ArrayList<Integer> getEpsg26915() {
        return epsg26915;
    }

    public void setEpsg26915(ArrayList<Integer> epsg26915) {
        this.epsg26915 = epsg26915;
    }

    public ArrayList<Double> getEpsg4326() {
        return epsg4326;
    }

    public void setEpsg4326(ArrayList<Double> epsg4326) {
        this.epsg4326 = epsg4326;
    }

    @Override
    public String toString() {
        return "Point{" +
                "epsg26915=" + epsg26915 +
                ", epsg4326=" + epsg4326 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return getEpsg26915().equals(point.getEpsg26915()) && getEpsg4326().equals(point.getEpsg4326());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEpsg26915(), getEpsg4326());
    }
}

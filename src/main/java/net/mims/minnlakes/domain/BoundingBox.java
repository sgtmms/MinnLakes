package net.mims.minnlakes.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Objects;

public class BoundingBox implements Comparable<BoundingBox> {


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
        return "BoundingBox{" +
                "epsg26915=" + epsg26915 +
                ", epsg4326=" + epsg4326 +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoundingBox that = (BoundingBox) o;
        return getEpsg26915().equals(that.getEpsg26915()) && getEpsg4326().equals(that.getEpsg4326());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEpsg26915(), getEpsg4326());
    }

    @Override
    public int compareTo(BoundingBox o) {
        return Double.compare(epsg4326.get(0), o.epsg4326.get(0));
    }
}

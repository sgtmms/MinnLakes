package net.mims.minnlakes.domain;

import java.util.Objects;

public class Morphology implements Comparable<Morphology>{

    public int littoralArea;
    public int shoreLength;
    public int maxDepth;
    public int area;
    public int meanDepth;

    public int getMeanDepth() {
        return meanDepth;
    }

    public void setMeanDepth(int meanDepth) {
        this.meanDepth = meanDepth;
    }

    public int getLittoralArea() {
        return littoralArea;
    }

    public void setLittoralArea(int littoralArea) {
        this.littoralArea = littoralArea;
    }

    public int getShoreLength() {
        return shoreLength;
    }

    public void setShoreLength(int shoreLength) {
        this.shoreLength = shoreLength;
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    public void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Morphology{" +
                "littoralArea=" + littoralArea +
                ", shoreLength=" + shoreLength +
                ", maxDepth=" + maxDepth +
                ", area=" + area +
                ", meanDepth=" + meanDepth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Morphology that = (Morphology) o;
        return getLittoralArea() == that.getLittoralArea() && getShoreLength() == that.getShoreLength() && getMaxDepth() == that.getMaxDepth() && getArea() == that.getArea() && getMeanDepth() == that.getMeanDepth();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLittoralArea(), getShoreLength(), getMaxDepth(), getArea(), getMeanDepth());
    }

    @Override
    public int compareTo(Morphology o) {
        return 0;
    }
}
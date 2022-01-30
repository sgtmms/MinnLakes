package net.mims.minnlakes.domain;

import java.util.ArrayList;
import java.util.Objects;

public class MinnesotaWaterbody {
    private ArrayList<Object> specialFishingRegs;
    private String countyName;
    private ArrayList<Object> fishSpecies;
    private int countyId;
    private String lakeId;
    private Morphology morphology;
    private ArrayList<Object> invasiveSpecies;
    private String name;
    private Point point;
    private ArrayList<Object> aprIds;
    private ArrayList<Object> mapId;
    private Resources resources;
    private BoundingBox boundingBox;
    private String notes;
    private String border;
    private String nearestTown;


    public ArrayList<Object> getSpecialFishingRegs() {
        return specialFishingRegs;
    }

    public void setSpecialFishingRegs(ArrayList<Object> specialFishingRegs) {
        this.specialFishingRegs = specialFishingRegs;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public ArrayList<Object> getFishSpecies() {
        return fishSpecies;
    }

    public void setFishSpecies(ArrayList<Object> fishSpecies) {
        this.fishSpecies = fishSpecies;
    }

    public int getCountyId() {
        return countyId;
    }

    public void setCountyId(int countyId) {
        this.countyId = countyId;
    }

    public String getLakeId() {
        return lakeId;
    }

    public void setLakeId(String lakeId) {
        this.lakeId = lakeId;
    }

    public Morphology getMorphology() {
        return morphology;
    }

    public void setMorphology(Morphology morphology) {
        this.morphology = morphology;
    }

    public ArrayList<Object> getInvasiveSpecies() {
        return invasiveSpecies;
    }

    public void setInvasiveSpecies(ArrayList<Object> invasiveSpecies) {
        this.invasiveSpecies = invasiveSpecies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public ArrayList<Object> getAprIds() {
        return aprIds;
    }

    public void setAprIds(ArrayList<Object> aprIds) {
        this.aprIds = aprIds;
    }

    public ArrayList<Object> getMapId() {
        return mapId;
    }

    public void setMapId(ArrayList<Object> mapId) {
        this.mapId = mapId;
    }

    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox(BoundingBox boundingBox) {
        this.boundingBox = boundingBox;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getBorder() {
        return border;
    }

    public void setBorder(String border) {
        this.border = border;
    }

    public String getNearestTown() {
        return nearestTown;
    }

    public void setNearestTown(String nearestTown) {
        this.nearestTown = nearestTown;
    }

    @Override
    public String toString() {
        return "MinnesotaWaterbody{" +
                "specialFishingRegs=" + specialFishingRegs +
                ", countyName='" + countyName + '\'' +
                ", fishSpecies=" + fishSpecies +
                ", countyId=" + countyId +
                ", lakeId='" + lakeId + '\'' +
                ", morphology=" + morphology +
                ", invasiveSpecies=" + invasiveSpecies +
                ", name='" + name + '\'' +
                ", point=" + point +
                ", aprIds=" + aprIds +
                ", mapId=" + mapId +
                ", resources=" + resources +
                ", boundingBox=" + boundingBox +
                ", notes='" + notes + '\'' +
                ", border='" + border + '\'' +
                ", nearestTown='" + nearestTown + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MinnesotaWaterbody)) return false;
        MinnesotaWaterbody that = (MinnesotaWaterbody) o;
        return getCountyId() == that.getCountyId() && getCountyName().equals(that.getCountyName()) && getLakeId().equals(that.getLakeId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCountyName(), getCountyId(), getLakeId());
    }
}


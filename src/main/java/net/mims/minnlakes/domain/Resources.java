package net.mims.minnlakes.domain;

import java.util.Objects;

public class Resources{
    public int specialFishingRegs;
    public int fca;
    public int fishStocking;
    public int iceIn;
    public int waterAccess;
    public int sentinelLake;
    public int lakeSurvey;
    public int waterQuality;
    public int waterLevels;
    public int lakeMap;
    public int iceOut;

    public int getSpecialFishingRegs() {
        return specialFishingRegs;
    }

    public void setSpecialFishingRegs(int specialFishingRegs) {
        this.specialFishingRegs = specialFishingRegs;
    }

    public int getFca() {
        return fca;
    }

    public void setFca(int fca) {
        this.fca = fca;
    }

    public int getFishStocking() {
        return fishStocking;
    }

    public void setFishStocking(int fishStocking) {
        this.fishStocking = fishStocking;
    }

    public int getIceIn() {
        return iceIn;
    }

    public void setIceIn(int iceIn) {
        this.iceIn = iceIn;
    }

    public int getWaterAccess() {
        return waterAccess;
    }

    public void setWaterAccess(int waterAccess) {
        this.waterAccess = waterAccess;
    }

    public int getSentinelLake() {
        return sentinelLake;
    }

    public void setSentinelLake(int sentinelLake) {
        this.sentinelLake = sentinelLake;
    }

    public int getLakeSurvey() {
        return lakeSurvey;
    }

    public void setLakeSurvey(int lakeSurvey) {
        this.lakeSurvey = lakeSurvey;
    }

    public int getWaterQuality() {
        return waterQuality;
    }

    public void setWaterQuality(int waterQuality) {
        this.waterQuality = waterQuality;
    }

    public int getWaterLevels() {
        return waterLevels;
    }

    public void setWaterLevels(int waterLevels) {
        this.waterLevels = waterLevels;
    }

    public int getLakeMap() {
        return lakeMap;
    }

    public void setLakeMap(int lakeMap) {
        this.lakeMap = lakeMap;
    }

    public int getIceOut() {
        return iceOut;
    }

    public void setIceOut(int iceOut) {
        this.iceOut = iceOut;
    }

    @Override
    public String toString() {
        return "Resources{" +
                "specialFishingRegs=" + specialFishingRegs +
                ", fca=" + fca +
                ", fishStocking=" + fishStocking +
                ", iceIn=" + iceIn +
                ", waterAccess=" + waterAccess +
                ", sentinelLake=" + sentinelLake +
                ", lakeSurvey=" + lakeSurvey +
                ", waterQuality=" + waterQuality +
                ", waterLevels=" + waterLevels +
                ", lakeMap=" + lakeMap +
                ", iceOut=" + iceOut +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resources resources = (Resources) o;
        return getSpecialFishingRegs() == resources.getSpecialFishingRegs() && getFca() == resources.getFca() && getFishStocking() == resources.getFishStocking() && getIceIn() == resources.getIceIn() && getWaterAccess() == resources.getWaterAccess() && getSentinelLake() == resources.getSentinelLake() && getLakeSurvey() == resources.getLakeSurvey() && getWaterQuality() == resources.getWaterQuality() && getWaterLevels() == resources.getWaterLevels() && getLakeMap() == resources.getLakeMap() && getIceOut() == resources.getIceOut();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSpecialFishingRegs(), getFca(), getFishStocking(), getIceIn(), getWaterAccess(), getSentinelLake(), getLakeSurvey(), getWaterQuality(), getWaterLevels(), getLakeMap(), getIceOut());
    }
}

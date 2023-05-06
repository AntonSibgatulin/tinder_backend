package ru.antonsibgatulin.tinder_backend.dto;

public class ExploreDTO extends DTO implements IDTO{

    private Double lat;
    private Double lon;

    private Long radius; //in metters

    public ExploreDTO() {
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Long getRadius() {
        return radius;
    }

    public void setRadius(Long radius) {
        this.radius = radius;
    }
}

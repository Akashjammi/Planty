package com.planty.app;
public class MyListData{
    private String description,plant_details;
    private int imgId;
    public MyListData(String description, int imgId) {
        this.description = description;
        this.imgId = imgId;
    }
    public String getDescription() {
        return description;
    }

    public String getPlant_details() {
        return plant_details;
    }

    public void setPlant_details(String plant_details) {
        this.plant_details = plant_details;
    }

    public MyListData(String description, String plant_details, int imgId) {
        this.description = description;
        this.plant_details = plant_details;
        this.imgId = imgId;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public int getImgId() {
        return imgId;
    }
    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
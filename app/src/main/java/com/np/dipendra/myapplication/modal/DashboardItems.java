package com.np.dipendra.myapplication.modal;

public class DashboardItems {
    private String item;
    int image;

    public DashboardItems() {
    }

    public DashboardItems(String item, int image) {
        this.item = item;
        this.image = image;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

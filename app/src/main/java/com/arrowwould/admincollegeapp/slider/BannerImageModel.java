package com.arrowwould.admincollegeapp.slider;

public class BannerImageModel {

    String imageOne, imageTow, imageThree, imageFour;

    public BannerImageModel(String imageOne, String imageTow, String imageThree, String imageFour) {
        this.imageOne = imageOne;
        this.imageTow = imageTow;
        this.imageThree = imageThree;
        this.imageFour = imageFour;
    }

    public BannerImageModel() {

    }

    public String getImageOne() {
        return imageOne;
    }

    public void setImageOne(String imageOne) {
        this.imageOne = imageOne;
    }

    public String getImageTow() {
        return imageTow;
    }

    public void setImageTow(String imageTow) {
        this.imageTow = imageTow;
    }

    public String getImageThree() {
        return imageThree;
    }

    public void setImageThree(String imageThree) {
        this.imageThree = imageThree;
    }

    public String getImageFour() {
        return imageFour;
    }

    public void setImageFour(String imageFour) {
        this.imageFour = imageFour;
    }
}

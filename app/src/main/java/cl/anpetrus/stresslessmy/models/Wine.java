package cl.anpetrus.stresslessmy.models;

import com.orm.SugarRecord;

/**
 * Created by Petrus on 11-08-2017.
 */

public class Wine extends SugarRecord {
    private String brand;
    private int year;
    private String strain;

    public Wine(){}

    public Wine(String brand, int year, String strain) {
        this.brand = brand;
        this.year = year;
        this.strain = strain;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getStrain() {
        return strain;
    }

    public void setStrain(String strain) {
        this.strain = strain;
    }
}

package cl.anpetrus.stresslessmy.models;

import com.orm.SugarRecord;

/**
 * Created by Petrus on 10-08-2017.
 */

public class Pending extends SugarRecord {
    public Pending() {
    }

    private String name;
    private String description;
    private boolean donde;

    public Pending(String name, String description, boolean donde) {
        this.name = name;
        this.description = description;
        this.donde = donde;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDonde() {
        return donde;
    }

    public void setDonde(boolean donde) {
        this.donde = donde;
    }
}

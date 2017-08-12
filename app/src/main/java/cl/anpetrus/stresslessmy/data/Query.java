package cl.anpetrus.stresslessmy.data;

import java.util.ArrayList;
import java.util.List;

import cl.anpetrus.stresslessmy.models.Pending;
import cl.anpetrus.stresslessmy.models.Wine;

/**
 * Created by USUARIO on 11-08-2017.
 */

public class Query {

    public List<Pending> pendings() {
        List<Pending> pendings = new ArrayList<>();
        List<Pending> pendingList = Pending.listAll(Pending.class);
        if (pendingList != null && pendingList.size() > 0) {
            pendings.addAll(pendingList);
        }
        return pendings;
    }

    public List<Pending> notDone() {
        List<Pending> pendings = new ArrayList<>();
        List<Pending> pendingList = Pending.find(Pending.class, "done = 0");
        if (pendingList != null && pendingList.size() > 0) {
            pendings.addAll(pendingList);
        }
        return pendings;
    }

    public List<Pending> done() {
        List<Pending> pendings = new ArrayList<>();
        List<Pending> pendingList = Pending.find(Pending.class, "done = 1");
        if (pendingList != null && pendingList.size() > 0) {
            pendings.addAll(pendingList);
        }
        return pendings;
    }

    public List<String> names() {
        List<String> names = new ArrayList<>();
        List<Pending> pendings = notDone();
        for (int i = 0; i < pendings.size(); i++) {
            names.add(pendings.get(i).getName());
        }

        return names;
    }

    public List<Pending> byName(String name) {
        List<Pending> pendings = new ArrayList<>();
        String query = "done = 0 AND name LIKE '%" + name + "%'";
        List<Pending> pendingList = Pending.find(Pending.class, query);
        if (pendingList != null && pendingList.size() > 0) {
            pendings.addAll(pendingList);
        }
        return pendings;
    }

    public List<Wine> wines() {
        List<Wine> wines = new ArrayList<>();
        List<Wine> winesList = Wine.listAll(Wine.class);
        if (winesList != null && winesList.size() > 0) {
            wines.addAll(winesList);
        }
        return wines;
    }
}

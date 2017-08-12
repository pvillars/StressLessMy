package cl.anpetrus.stresslessmy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.anpetrus.stresslessmy.adapters.WineAdapter;
import cl.anpetrus.stresslessmy.models.Wine;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.pendingRv);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

       /* Pending pending;
        for (int i = 0; i < 20; i++) {
            pending = new Pending("PName" + i, "desc" + 1, true);
            pending.save();
        }

        PendingAdapter wineAdapter = new PendingAdapter();
        recyclerView.setAdapter(wineAdapter);*/

        Wine wine;
        wine = new Wine("Santa Helena" , 8,"Sauvignon");
        wine.save();
        wine = new Wine("Rio Loco" , 0,"Cartoner");
        wine.save();
        wine = new Wine("Toro de Piedra" , 4,"Merlot");
        wine.save();
        wine = new Wine("Lomas de Nirivilo" , 1,"Terremotier");
        wine.save();
        wine = new Wine("Korta" , 5,"shiraz");
        wine.save();

        WineAdapter wineAdapter = new WineAdapter();
        recyclerView.setAdapter(wineAdapter);
    }
}

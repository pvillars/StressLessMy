package cl.anpetrus.stresslessmy.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cl.anpetrus.stresslessmy.R;
import cl.anpetrus.stresslessmy.data.Query;
import cl.anpetrus.stresslessmy.models.Wine;

/**
 * Created by USUARIO on 11-08-2017.
 */

public class WineAdapter extends RecyclerView.Adapter<WineAdapter.ViewHolder> {

    private List<Wine> wines = new Query().wines();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_wine, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Wine wine = wines.get(position);
        holder.brandTv.setText(wine.getBrand());
        holder.yearTv.setText(String.valueOf(wine.getYear()));
        holder.strainTv.setText(wine.getStrain());
    }

    @Override
    public int getItemCount() {
        return wines.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView brandTv;
        private TextView yearTv;
        private TextView strainTv;

        public ViewHolder(View itemView) {
            super(itemView);

            brandTv = itemView.findViewById(R.id.brandTv);
            yearTv = itemView.findViewById(R.id.yearsTv);
            strainTv = itemView.findViewById(R.id.strainTv);
        }
    }
}

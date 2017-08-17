package cl.anpetrus.stresslessmy.adapters;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

import cl.anpetrus.stresslessmy.PendingClickListener;
import cl.anpetrus.stresslessmy.R;
import cl.anpetrus.stresslessmy.data.Query;
import cl.anpetrus.stresslessmy.models.Pending;

/**
 * Created by USUARIO on 11-08-2017.
 */

public class PendingAdapter extends RecyclerView.Adapter<PendingAdapter.ViewHolder> {

    private List<Pending> pendings = new Query().notDone();

    private PendingClickListener listener;

    public PendingAdapter(PendingClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_pending, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Pending pending = pendings.get(position);
        holder.textView.setText(pending.getName());
        holder.checkBox.setChecked(pending.isDone());

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            int position = holder.getAdapterPosition();
                            Pending auxPending = pendings.get(position);
                            auxPending.setDone(true);
                            auxPending.save();
                            pendings.remove(position);
                            notifyDataSetChanged();
                        }
                    }, 400);
                }
            }
        });

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Pending auxPending = pendings.get(holder.getAdapterPosition());
                listener.clickedID(auxPending.getId());
            }
        });
    }

    public void update(Pending pending) {
        pendings.add(pending);
        pending.save();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return pendings.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private CheckBox checkBox;
        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

            checkBox = itemView.findViewById(R.id.pendingCb);
            textView = itemView.findViewById(R.id.pendingTv);
        }
    }
}

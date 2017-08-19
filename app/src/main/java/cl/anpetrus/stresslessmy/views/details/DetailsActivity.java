package cl.anpetrus.stresslessmy.views.details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;

import cl.anpetrus.stresslessmy.R;
import cl.anpetrus.stresslessmy.models.Pending;
import cl.anpetrus.stresslessmy.views.main.PendingFragment;

public class DetailsActivity extends AppCompatActivity {

    private Pending pending;
    private EditText descriptionEt;

    @Override
    protected void onResume() {
        super.onResume();
        if(pending.getDescription()!=null){
            descriptionEt.setText(pending.getDescription());
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        pending.setDescription(descriptionEt.getText().toString());
        pending.save();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        descriptionEt = (EditText) findViewById(R.id.descriptionEt);

        long idPending = getIntent().getLongExtra(PendingFragment.PENDING_ID,0L);
        Log.d("LOGID",String.valueOf(idPending));
        pending = Pending.findById(Pending.class,idPending);
        getSupportActionBar().setTitle(pending.getName());
    }
}

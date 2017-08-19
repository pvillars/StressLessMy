package cl.anpetrus.stresslessmy.views.main;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;

import cl.anpetrus.stresslessmy.R;
import cl.anpetrus.stresslessmy.models.Pending;

public class MainActivity extends AppCompatActivity {


    private PendingFragment mainActivityFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mainActivityFragment = (PendingFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_pending);
                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                dialog.show();

                ImageButton imageButton = dialog.findViewById(R.id.saveBtn);
                imageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EditText nameTv = dialog.findViewById(R.id.nameEt);
                        String name = nameTv.getText().toString().trim();

                        if (name.length() > 0) {
                            Pending pending = new Pending();
                            pending.setName(name);
                            pending.setDone(false);
                            mainActivityFragment.updateList(pending);
                        }
                        dialog.dismiss();
                    }
                });
            }
        });
    }
}





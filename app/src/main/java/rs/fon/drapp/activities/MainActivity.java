package rs.fon.drapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import rs.fon.drapp.R;
import rs.fon.drapp.domain.Routine;
import rs.fon.drapp.domain.RoutinesCollection;
import rs.fon.drapp.loaders.RoutinesManager;
import rs.fon.drapp.util.RoutinesListAdapter;

public class MainActivity extends AppCompatActivity {

    private ListView mRoutinesList;
    private RoutinesCollection mRC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRC = RoutinesManager.getInstance().loadRoutines(this, "routines.json");
        mRoutinesList = (ListView) findViewById(R.id.dailyRoutines);
        RoutinesListAdapter adapter = new RoutinesListAdapter(this, mRC.getRoutines());
        mRoutinesList.setAdapter(adapter);

        mRoutinesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Routine r = mRC.getRoutines().get(i);
                Intent intent = new Intent(MainActivity.this, RoutineActivity.class);
                intent.putExtra("routine", r);
                startActivity(intent);
            }
        });

    }

}

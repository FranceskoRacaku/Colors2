package temple.edu.colors2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class PaletteActivity extends AppCompatActivity {

    public static final String INTENT_COLOR_KEY = "color";
    private boolean firstSelection = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        final ConstraintLayout c = findViewById(R.id.layout);

        Spinner s;
        s = findViewById(R.id.spinner);

        String colors[] = {
                "Blue",
                "Red",
                "White",
                "Yellow",
                "Green",
                "Aqua",
                "Olive",
                "Lime",
                "Cyan",
                "Silver"
        };

        ColorAdapter a = new ColorAdapter(this, colors);
        s.setAdapter(a);

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(!firstSelection) {   //Prevent onItemSelected() from running this code automatically (i.e. before the user chooses anything)
                    Intent launchIntent = new Intent(PaletteActivity.this, CanvasActivity.class);
                    launchIntent.putExtra(INTENT_COLOR_KEY, parent.getItemAtPosition(position).toString());
                    startActivity(launchIntent);
                } else {
                    firstSelection = false;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
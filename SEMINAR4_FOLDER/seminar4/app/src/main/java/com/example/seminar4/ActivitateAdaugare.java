package com.example.seminar4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivitateAdaugare extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activitate_adaugare2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText etInaltime = findViewById(R.id.etInaltime);
        EditText etPret = findViewById(R.id.etPret);
        CheckBox cbAdult = findViewById(R.id.cbAdult);
        Switch swSuport = findViewById(R.id.swSuport);
        Spinner spTip = findViewById(R.id.spTip);
        RadioButton rbArtificial = findViewById(R.id.rbArtificial);
        RatingBar rbRating = findViewById(R.id.rbRating);
        Button btnSalveaza = findViewById(R.id.btnSalveaza);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.tipuri_brad, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTip.setAdapter(adapter);

        btnSalveaza.setOnClickListener(v -> {
            String sInaltime = etInaltime.getText().toString().trim();
            String sPret = etPret.getText().toString().trim();
            if (sInaltime.isEmpty() || sPret.isEmpty()) {
                Toast.makeText(this, "Completează înălțimea și prețul!", Toast.LENGTH_SHORT).show();
                return;
            }

            Brad brad = new Brad(
                    Double.parseDouble(sInaltime),
                    Double.parseDouble(sPret),
                    cbAdult.isChecked(),
                    swSuport.isChecked(),
                    spTip.getSelectedItem().toString(),
                    rbArtificial.isChecked(),
                    rbRating.getRating());

            Intent intent = new Intent();
            intent.putExtra("brad", brad);
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}
package com.example.seminar4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView tvRezultat;
    private final ArrayList<Brad> listaBrazi = new ArrayList<>();


    private final ActivityResultLauncher<Intent> launcherAdaugare =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Brad brad = (Brad) result.getData().getSerializableExtra("brad");
                    if (brad != null) {
                        listaBrazi.add(brad);
                        tvRezultat.setText("Ultimul brad: " + brad
                                + "\n\nTotal brazi: " + listaBrazi.size());
                        Toast.makeText(this, brad.toString(), Toast.LENGTH_LONG).show();
                    }
                }
            });


    @SuppressWarnings("unchecked")
    private final ActivityResultLauncher<Intent> launcherLista =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    ArrayList<Brad> actualizata =
                            (ArrayList<Brad>) result.getData().getSerializableExtra("lista");
                    if (actualizata != null) {
                        listaBrazi.clear();
                        listaBrazi.addAll(actualizata);
                        tvRezultat.setText("Total brazi: " + listaBrazi.size());
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvRezultat = findViewById(R.id.tvRezultat);
        Button btnAdauga = findViewById(R.id.btnAdauga);
        Button btnAdaugaAI = findViewById(R.id.btnAdaugaAI);
        Button btnLista = findViewById(R.id.btnLista);

        btnAdauga.setOnClickListener(v ->
                launcherAdaugare.launch(new Intent(MainActivity.this, ActivitateBrad.class)));

        btnAdaugaAI.setOnClickListener(v ->
                launcherAdaugare.launch(new Intent(MainActivity.this, ActivitateAdaugare.class)));

        btnLista.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ListaBrazi.class);
            intent.putExtra("lista", listaBrazi);
            launcherLista.launch(intent);
        });
    }
}
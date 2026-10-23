package com.example.continueare_seminar2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
    //cerinta 8 s2
    //daca avem 2 activitati si transmitem informatii din activ 1 catre activ 2
    // o putem face doar prin intermediul unui bundle

    public void deschideActivitate(View view){
        Intent it =new Intent(this, ActivitateRezultat.class);
        Bundle bundle = new Bundle();
        bundle.putString("mesaj", "mesaj din ACTIVITATE NOUA");
        bundle.putInt("numar1", 5);
        bundle.putInt("numar2", 7);
        it.putExtras(bundle);

        startActivityForResult(it, 83); // la request code pote fi orice numar


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 83){
            if(resultCode == RESULT_OK){
                String  mesajIntent = data.getStringExtra("mesaj");
                int suma = data.getIntExtra("suma",0); // am obtinut cele 2 valori transmise
                // cu aceste 2 valori le afisam in toast
                Toast.makeText(this,mesajIntent+ " " + suma, Toast.LENGTH_LONG).show();
            }
        }
    }
}
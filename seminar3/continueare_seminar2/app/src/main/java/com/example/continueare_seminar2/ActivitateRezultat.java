package com.example.continueare_seminar2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivitateRezultat extends AppCompatActivity {
    private int nr1, nr2;
    //cerinta 8
    //preluam informatiile de la activ 1 la activ 2 aici
    //pe metoda onCreate putem afla ce intent a fost folosit pt a crea aceasta activitate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activitate_rezultat);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent it =getIntent();
        //din acest intent putem crea bundle ul


        //se preiau informatiile din bundle ul creat in MainActivity:
        Bundle bundle =it.getExtras(); // va returna toate acele extras, adica bundle ul creat in MainActivity
        String mesaj = bundle.getString("mesaj", "");
         nr1= bundle.getInt("numar1", 0);
         nr2= bundle.getInt("numar2", 0);

        //se afiseaza informatiile intr un Toast:
        // mesaj de tip toast- mesaj care interactioneaza cu utilizatorul, dureaza o secunda sau 2, nu ramane ca notificare

        Toast.makeText(this, mesaj,Toast.LENGTH_LONG).show(); //show punem ca sa poate sa afiseze

    }
public void intoarceInActivitate(View view){
        int suma =this.nr1 + this.nr2;

        //cerinta 9
        String mesajnou= "Noul mesaj";
        Intent it = new Intent();
        //in intent se adauga un bundle automat, arata mai dif ca ala din main
        it.putExtra("mesaj", mesajnou);
        it.putExtra("suma", suma);

        setResult(RESULT_OK, it);
        finish(); // ca sa oprim activitatea, o inchidem
}

}
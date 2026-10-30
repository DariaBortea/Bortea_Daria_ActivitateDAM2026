package com.example.seminar4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListaBrazi extends AppCompatActivity {
    private ArrayList<Brad> lista;
    private ArrayAdapter<Brad> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_brazi);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListView lvBrazi= findViewById(R.id.lvBrazi);
        lista = (ArrayList<Brad>) getIntent().getSerializableExtra("lista");
        if (lista == null) {
            lista = new ArrayList<>();
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
            lvBrazi.setAdapter(adapter);

            lvBrazi.setOnItemClickListener((parent, view, position, id) ->
                    Toast.makeText(this, lista.get(position).toString(), Toast.LENGTH_LONG).show());
            lvBrazi.setOnItemLongClickListener((parent, view, position, id) -> {
                lista.remove(position);
                adapter.notifyDataSetChanged();
                trimiteRezultat();
                Toast.makeText(this, "Brad șters", Toast.LENGTH_SHORT).show();
                return true;
            });

        }


    }
    private void trimiteRezultat() {
        Intent intent = new Intent();
        intent.putExtra("lista", lista);
        setResult(RESULT_OK, intent);
    }


}
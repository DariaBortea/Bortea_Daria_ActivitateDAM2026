
package com.example.seminar2pentru_mine_primul;

import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.seminar2pentru_mine_primul.R;

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
        Log.i("seminar", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Seminar", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("Seminar","onResume");
    }



    @Override
    protected void onPause() {
        super.onPause();
        Log.w("seminar", "onPause()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("seminar", "onDestroy");
    }
}

package com.example.ap4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Recherche extends AppCompatActivity {

    private Button btnCherche;
    private EditText edtCherche;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche);

        btnCherche = findViewById(R.id.btnRecherche);
        edtCherche = findViewById(R.id.edtRecherche);

        btnCherche.setOnClickListener(new Button.OnClickListener()
        {
           @Override
            public void onClick(View view) {
//               Toast toast = Toast.makeText(getApplicationContext(), edtCherche.getText(), Toast.LENGTH_SHORT);
//               toast.show();

               Intent intent = new Intent (Recherche.this, Policier.class);
               intent.putExtra("titre", edtCherche.getText().toString());
               startActivity(intent);
           }
        });


    } // fin onCreate
}
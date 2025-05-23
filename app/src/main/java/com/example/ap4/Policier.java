package com.example.ap4;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Policier extends AppCompatActivity {

    public String filmPoliciers[] = {
            "Kill-bill-Vol1",
            "Kill-bill-Vol2",
            "Otage",
            "Da Vinci Code",
            "36 quai des Orfèvres",
            "Mystic River"
    };

    final ArrayAdapter<String> adapterList = new
            ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, filmPoliciers);

    ListView listPolicier = (ListView) findViewById(R.id.policier_listview);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policier);

        String titre = this.getIntent().getStringExtra("titre");
        TextView titreDemande = findViewById(R.id.titreDemande);
        titreDemande.setText(titre);

        Button btnRetour = (Button) findViewById(R.id.boutonRetour);

        btnRetour.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(Policier.this);
                Intent intent = new Intent(Policier.this, MainActivity.class);
                startActivity(intent);
            }
        });
    } // fin onCreate
}
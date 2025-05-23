package com.example.ap4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Reservation extends AppCompatActivity {
    private Button btnConfirmer;
    private Button btnRetour;
    private Button btnAnnuler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        btnRetour = findViewById(R.id.btnRetourReservation);
        btnConfirmer = findViewById(R.id.btnConfirmer);
        btnAnnuler = findViewById(R.id.btnAnnuler);

        btnConfirmer.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(Activity.RESULT_OK);
                finish();
            }
        });

        btnRetour.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(Reservation.this);
                Intent intent = new Intent(Reservation.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnAnnuler.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });
    } // fin onCreate
}
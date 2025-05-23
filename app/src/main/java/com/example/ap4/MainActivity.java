package com.example.ap4;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> reservationLauncher;
    private ActivityResultLauncher<Intent> rechercheLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reservationLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Toast.makeText(MainActivity.this, "Réservation confirmée", Toast.LENGTH_SHORT).show();
                        } else if (result.getResultCode() == Activity.RESULT_CANCELED) {
                            Toast.makeText(MainActivity.this, "Réservation annulée", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        rechercheLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            String titre = data.getStringExtra("titre");
                            Toast.makeText(MainActivity.this, titre, Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        Button btnPolicier = (Button) findViewById(R.id.btnPolicier);
        Button btnFiction = (Button) findViewById(R.id.btnFiction);
        Button btnDocu = (Button) findViewById(R.id.btnDocu);
        Button btnSerie = (Button) findViewById(R.id.btnSerie);

        btnPolicier.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Policier");
                alertDialog.setMessage("Voulez-vous choisir un film Policier ?");

                alertDialog.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(getApplicationContext(), btnPolicier.getText(), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this, Policier.class);
                        startActivity(intent);
                    }
                });

                alertDialog.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                });
                alertDialog.show();
            }
        });

        btnFiction.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Fiction");
                alertDialog.setMessage("Voulez-vous choisir un film de Fiction ?");

                alertDialog.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(getApplicationContext(), btnFiction.getText(), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this, Fiction.class);
                        startActivity(intent);
                    }
                });

                alertDialog.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                });
                alertDialog.show();
            }
        });

        btnDocu.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Docu");
                alertDialog.setMessage("Voulez-vous choisir un film Documentaire ?");

                alertDialog.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(getApplicationContext(), btnDocu.getText(), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this, Docu.class);
                        startActivity(intent);
                    }
                });

                alertDialog.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                });
                alertDialog.show();
            }
        });

        btnSerie.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Série");
                alertDialog.setMessage("Voulez-vous choisir une série ?");

                alertDialog.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(getApplicationContext(), btnSerie.getText(), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this, Serie.class);
                        startActivity(intent);
                    }
                });

                alertDialog.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                });
                alertDialog.show();
            }
        });
    } // fin onCreate

    //Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menugeneral, menu);
        return true;
    }

    // Activation des menus et sous menus
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId())
        {
            case R.id.MenuRechercher:
                Log.i("LocDVD","Menu:Rechercher un film");
                Intent intentRechercher = new Intent(MainActivity.this, Recherche.class);
                rechercheLauncher.launch(intentRechercher);
                return true;

            case R.id.MenuReservation:
                Log.i("LocDVD","Menu:Réserver un film");
                Intent intentReserver = new Intent(MainActivity.this, Reservation.class);
                reservationLauncher.launch(intentReserver);
                return true;

            case R.id.MenuMagasin:
                Log.i("LocDVD","Menu:Magasin");
                return true;

            case R.id.MenuContact:
                Log.i("LocDVD","Menu:Contact");
                return true;
        }
        return true;
    }
}
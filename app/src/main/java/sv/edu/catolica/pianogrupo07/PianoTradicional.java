package sv.edu.catolica.pianogrupo07;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PianoTradicional extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.desing_piano_tradicional);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.acercade) {
            Intent ventana = new Intent(PianoTradicional.this, Acerca_de.class);
            Toast mensajito = Toast.makeText(getApplicationContext(), "Vista Acerca de...", Toast.LENGTH_SHORT);
            mensajito.show();
            startActivity(ventana);
            finish();
        }else if (item.getItemId() == R.id.salir) {
            finish();
        } else if (item.getItemId() == R.id.cambio) {
            final String[] pianos = {"Tradicional", "Infantil de la selva", "Instrumentos musicales"};
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Elija el piano que desee");
            builder.setItems(pianos, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (pianos[which].equals("Tradicional")) {
                        Intent ventana = new Intent(PianoTradicional.this, PianoTradicional.class);
                        startActivity(ventana);
                        finish();
                    } else if (pianos[which].equals("Infantil de la selva")) {
                        Intent ventana = new Intent(PianoTradicional.this, PianoSalvaje.class);
                        startActivity(ventana);
                        finish();
                    } else if (pianos[which].equals("Instrumentos musicales")) {
                        Intent ventana = new Intent(PianoTradicional.this, PianoInstrumentos.class);
                        startActivity(ventana);
                        finish();
                    }
                    Toast mensajito = Toast.makeText(getApplicationContext(), "Piano Seleccionado: " + pianos[which], Toast.LENGTH_SHORT);
                    mensajito.show();
                }
            });
            builder.create();
            builder.show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void PlayDo(View view) {
        MediaPlayer sonido = MediaPlayer.create(this, R.raw.dor);
        sonido.start();
        Toast toastDo = Toast.makeText(getApplicationContext(), "Do", Toast.LENGTH_SHORT);
        toastDo.show();
    }

    public void PlayRe(View view) {
        MediaPlayer sonido = MediaPlayer.create(this, R.raw.re);
        sonido.start();
        Toast toastRe = Toast.makeText(getApplicationContext(), "Re", Toast.LENGTH_SHORT);
        toastRe.show();
    }

    public void PlayMi(View view) {
        MediaPlayer sonido = MediaPlayer.create(this, R.raw.mi);
        sonido.start();
        Toast toastMi = Toast.makeText(getApplicationContext(), "Mi", Toast.LENGTH_SHORT);
        toastMi.show();
    }

    public void PlayFa(View view) {
        MediaPlayer sonido = MediaPlayer.create(this, R.raw.fa);
        sonido.start();
        Toast toastFa = Toast.makeText(getApplicationContext(), "Fa", Toast.LENGTH_SHORT);
        toastFa.show();
    }

    public void PlaySol(View view) {
        MediaPlayer sonido = MediaPlayer.create(this, R.raw.sol);
        sonido.start();
        Toast toastSol = Toast.makeText(getApplicationContext(), "Sol", Toast.LENGTH_SHORT);
        toastSol.show();
    }

    public void PlayLa(View view) {
        MediaPlayer sonido = MediaPlayer.create(this, R.raw.la);
        sonido.start();
        Toast toastLa = Toast.makeText(getApplicationContext(), "La", Toast.LENGTH_SHORT);
        toastLa.show();
    }

    public void PlaySi(View view) {
        MediaPlayer sonido = MediaPlayer.create(this, R.raw.si);
        sonido.start();
        Toast toastSi = Toast.makeText(getApplicationContext(), "Si", Toast.LENGTH_SHORT);
        toastSi.show();
    }
}
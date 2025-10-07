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

public class PianoInstrumentos extends AppCompatActivity {

    private MediaPlayer sonidoActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.desing_piano_instrumentos);
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
            Intent ventana = new Intent(PianoInstrumentos.this, Acerca_de.class);
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
                        Intent ventana = new Intent(PianoInstrumentos.this, PianoTradicional.class);
                        startActivity(ventana);
                        finish();
                    } else if (pianos[which].equals("Infantil de la selva")) {
                        Intent ventana = new Intent(PianoInstrumentos.this, PianoSalvaje.class);
                        startActivity(ventana);
                        finish();
                    } else if (pianos[which].equals("Instrumentos musicales")) {
                        Intent ventana = new Intent(PianoInstrumentos.this, PianoInstrumentos.class);
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

    public void PlayCampana(View view) {
        if (sonidoActual != null && sonidoActual.isPlaying()) {
            sonidoActual.stop();
        }

        MediaPlayer sonido = MediaPlayer.create(this, R.raw.campana);
        sonidoActual = sonido;
        sonido.start();

        Toast toast = Toast.makeText(getApplicationContext(), "Campana", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void PlayPiano(View view) {
        if (sonidoActual != null && sonidoActual.isPlaying()) {
            sonidoActual.stop();
        }

        MediaPlayer sonido = MediaPlayer.create(this, R.raw.piano);
        sonidoActual = sonido;
        sonido.start();
        Toast toast = Toast.makeText(getApplicationContext(), "Piano", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void PlayBateria(View view) {
        if (sonidoActual != null && sonidoActual.isPlaying()) {
            sonidoActual.stop();
        }

        MediaPlayer sonido = MediaPlayer.create(this, R.raw.bateria);
        sonidoActual = sonido;
        sonido.start();
        Toast toast = Toast.makeText(getApplicationContext(), "Bateria", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void PlayPandereta(View view) {
        if (sonidoActual != null && sonidoActual.isPlaying()) {
            sonidoActual.stop();
        }

        MediaPlayer sonido = MediaPlayer.create(this, R.raw.pandereta);
        sonidoActual = sonido;
        sonido.start();
        Toast toast = Toast.makeText(getApplicationContext(), "Pandereta", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void PlayTrombon(View view) {
        if (sonidoActual != null && sonidoActual.isPlaying()) {
            sonidoActual.stop();
        }

        MediaPlayer sonido = MediaPlayer.create(this, R.raw.trombon);
        sonidoActual = sonido;
        sonido.start();
        Toast toast = Toast.makeText(getApplicationContext(), "Trombón", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void PlayFlauta(View view) {
        if (sonidoActual != null && sonidoActual.isPlaying()) {
            sonidoActual.stop();
        }

        MediaPlayer sonido = MediaPlayer.create(this, R.raw.flauta);
        sonidoActual = sonido;
        sonido.start();
        Toast toast = Toast.makeText(getApplicationContext(), "Flauta", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void PlaySaxofon(View view) {
        if (sonidoActual != null && sonidoActual.isPlaying()) {
            sonidoActual.stop();
        }

        MediaPlayer sonido = MediaPlayer.create(this, R.raw.saxofon);
        sonidoActual = sonido;
        sonido.start();
        Toast toast = Toast.makeText(getApplicationContext(), "Saxofón", Toast.LENGTH_SHORT);
        toast.show();
    }
}
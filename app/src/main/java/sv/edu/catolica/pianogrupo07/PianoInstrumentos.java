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

    private Toast toastActual;
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
            startActivity(ventana);

        }else if (item.getItemId() == R.id.salir) {
            this.finishAffinity();

        } else if (item.getItemId() == R.id.cambio) {
            final String[] pianos = {getString(R.string.tradicional), getString(R.string.infantil_de_la_selva), getString(R.string.instrumentos_musicales)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.elija_piano);
            builder.setItems(pianos, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (pianos[which].equals(getString(R.string.tradicional))) {
                        Intent ventana = new Intent(PianoInstrumentos.this, PianoTradicional.class);
                        startActivity(ventana);
                    } else if (pianos[which].equals(getString(R.string.infantil_de_la_selva))) {
                        Intent ventana = new Intent(PianoInstrumentos.this, PianoSalvaje.class);
                        startActivity(ventana);
                    } else if (pianos[which].equals(getString(R.string.instrumentos_musicales))) {
                        Intent ventana = new Intent(PianoInstrumentos.this, PianoInstrumentos.class);
                        startActivity(ventana);
                    }
                }
            });
            builder.create();
            builder.show();
        }
        return super.onOptionsItemSelected(item);
    }

    private void mostrarToast(String mensaje) {
        if (toastActual != null) toastActual.cancel();
        toastActual = Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT);
        toastActual.show();
    }
    public void PlayCampana(View view) {
        if (sonidoActual != null && sonidoActual.isPlaying()) {
            sonidoActual.stop();
        }

        MediaPlayer sonido = MediaPlayer.create(this, R.raw.campana);
        sonidoActual = sonido;
        sonido.start();

        mostrarToast(getString(R.string.campana));
    }

    public void PlayPiano(View view) {
        if (sonidoActual != null && sonidoActual.isPlaying()) {
            sonidoActual.stop();
        }

        MediaPlayer sonido = MediaPlayer.create(this, R.raw.piano);
        sonidoActual = sonido;
        sonido.start();
        mostrarToast(getString(R.string.piano));
    }

    public void PlayBateria(View view) {
        if (sonidoActual != null && sonidoActual.isPlaying()) {
            sonidoActual.stop();
        }

        MediaPlayer sonido = MediaPlayer.create(this, R.raw.bateria);
        sonidoActual = sonido;
        sonido.start();
        mostrarToast(getString(R.string.bater_a));
    }

    public void PlayPandereta(View view) {
        if (sonidoActual != null && sonidoActual.isPlaying()) {
            sonidoActual.stop();
        }

        MediaPlayer sonido = MediaPlayer.create(this, R.raw.pandereta);
        sonidoActual = sonido;
        sonido.start();
        mostrarToast(getString(R.string.pandereta));
    }

    public void PlayTrombon(View view) {
        if (sonidoActual != null && sonidoActual.isPlaying()) {
            sonidoActual.stop();
        }

        MediaPlayer sonido = MediaPlayer.create(this, R.raw.trombon);
        sonidoActual = sonido;
        sonido.start();
        mostrarToast(getString(R.string.tromb_m));
    }

    public void PlayFlauta(View view) {
        if (sonidoActual != null && sonidoActual.isPlaying()) {
            sonidoActual.stop();
        }

        MediaPlayer sonido = MediaPlayer.create(this, R.raw.flauta);
        sonidoActual = sonido;
        sonido.start();
        mostrarToast(getString(R.string.flauta));
    }

    public void PlaySaxofon(View view) {
        if (sonidoActual != null && sonidoActual.isPlaying()) {
            sonidoActual.stop();
        }

        MediaPlayer sonido = MediaPlayer.create(this, R.raw.saxofon);
        sonidoActual = sonido;
        sonido.start();
        mostrarToast(getString(R.string.saxof_n));
    }
}
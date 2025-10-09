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

public class PianoSalvaje extends AppCompatActivity {
    private MediaPlayer sonidoActual;

    private Toast toastActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.desing_piano_salvaje);
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
            Intent ventana = new Intent(PianoSalvaje.this, Acerca_de.class);
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
                        Intent ventana = new Intent(PianoSalvaje.this, PianoTradicional.class);
                        startActivity(ventana);
                    } else if (pianos[which].equals(getString(R.string.infantil_de_la_selva))) {
                        Intent ventana = new Intent(PianoSalvaje.this, PianoSalvaje.class);
                        startActivity(ventana);
                    } else if (pianos[which].equals(getString(R.string.instrumentos_musicales))) {
                        Intent ventana = new Intent(PianoSalvaje.this, PianoInstrumentos.class);
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

    public void PlayElefante(View view) {
        if (sonidoActual != null && sonidoActual.isPlaying()) {
            sonidoActual.stop();
        }

        MediaPlayer sonido = MediaPlayer.create(this, R.raw.elefante);
        sonidoActual = sonido;
        sonido.start();
        mostrarToast(getString(R.string.elefante));
    }

    public void PlayLeon(View view) {
        if (sonidoActual != null && sonidoActual.isPlaying()) {
            sonidoActual.stop();
        }

        MediaPlayer sonido = MediaPlayer.create(this, R.raw.leon);
        sonidoActual = sonido;
        sonido.start();
        mostrarToast(getString(R.string.le_n));
    }

    public void PlayAve(View view) {
        if (sonidoActual != null && sonidoActual.isPlaying()) {
            sonidoActual.stop();
        }

        MediaPlayer sonido = MediaPlayer.create(this, R.raw.ave);
        sonidoActual = sonido;
        sonido.start();
        mostrarToast(getString(R.string.ave));
    }

    public void PlayMono(View view) {
        if (sonidoActual != null && sonidoActual.isPlaying()) {
            sonidoActual.stop();
        }

        MediaPlayer sonido = MediaPlayer.create(this, R.raw.chimpance);
        sonidoActual = sonido;
        sonido.start();
        mostrarToast(getString(R.string.mono));
    }

    public void PlayRana(View view) {
        if (sonidoActual != null && sonidoActual.isPlaying()) {
            sonidoActual.stop();
        }

        MediaPlayer sonido = MediaPlayer.create(this, R.raw.rana);
        sonidoActual = sonido;
        sonido.start();
        mostrarToast(getString(R.string.rana));
    }

    public void PlayGrillo(View view) {
        if (sonidoActual != null && sonidoActual.isPlaying()) {
            sonidoActual.stop();
        }

        MediaPlayer sonido = MediaPlayer.create(this, R.raw.grillo);
        sonidoActual = sonido;
        sonido.start();
        mostrarToast(getString(R.string.grillo));
    }

    public void PlayJabali(View view) {
        if (sonidoActual != null && sonidoActual.isPlaying()) {
            sonidoActual.stop();
        }

        MediaPlayer sonido = MediaPlayer.create(this, R.raw.jabali);
        sonidoActual = sonido;
        sonido.start();
        mostrarToast(getString(R.string.jabal));
    }
}
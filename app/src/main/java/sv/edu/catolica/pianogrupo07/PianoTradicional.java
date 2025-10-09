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
    private Toast toastActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                        Intent ventana = new Intent(PianoTradicional.this, PianoTradicional.class);
                        startActivity(ventana);
                    } else if (pianos[which].equals(getString(R.string.infantil_de_la_selva))) {
                        Intent ventana = new Intent(PianoTradicional.this, PianoSalvaje.class);
                        startActivity(ventana);
                    } else if (pianos[which].equals(getString(R.string.instrumentos_musicales))) {
                        Intent ventana = new Intent(PianoTradicional.this, PianoInstrumentos.class);
                        startActivity(ventana);
                    }
                }
            });
            builder.create();
            builder.show();
        }
        return super.onOptionsItemSelected(item);
    }

    private void reproducirSonido(int indice, String nombreNota){
        MediaPlayer sonido = MediaPlayer.create(this, indice);
        sonido.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
        sonido.start();
        mostrarToast(nombreNota);
    }

    private void mostrarToast(String mensaje) {
        if (toastActual != null) toastActual.cancel();
        toastActual = Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT);
        toastActual.show();
    }

    public void PlayDo(View view) {reproducirSonido(R.raw.dor, getString(R.string.dor));}

    public void PlayRe(View view) {reproducirSonido(R.raw.re, getString(R.string.re));}

    public void PlayMi(View view) {reproducirSonido(R.raw.mi, getString(R.string.mi));}

    public void PlayFa(View view) {reproducirSonido(R.raw.fa, getString(R.string.fa));}

    public void PlaySol(View view) {reproducirSonido(R.raw.sol, getString(R.string.sol));}

    public void PlayLa(View view) {reproducirSonido(R.raw.la, getString(R.string.la));}

    public void PlaySi(View view) {reproducirSonido(R.raw.si, getString(R.string.si));}
}
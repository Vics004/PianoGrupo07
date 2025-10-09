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
    private MediaPlayer[] sonidos;
    private Toast toastActual;

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

        sonidos = new MediaPlayer[]{
                MediaPlayer.create(this, R.raw.dor),
                MediaPlayer.create(this, R.raw.re),
                MediaPlayer.create(this, R.raw.mi),
                MediaPlayer.create(this, R.raw.fa),
                MediaPlayer.create(this, R.raw.sol),
                MediaPlayer.create(this, R.raw.la),
                MediaPlayer.create(this, R.raw.si)
        };
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

    private void reproducirSonido(int indice, String nombreNota) {

        MediaPlayer sonido = sonidos[indice];

        if (sonido.isPlaying()) {
            sonido.seekTo(0); // reinicia si se toca rápido la misma nota
        }
        sonido.start();

        mostrarToast(nombreNota);
    }
    private void mostrarToast(String mensaje) {
        if (toastActual != null) toastActual.cancel();
        toastActual = Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT);
        toastActual.show();
    }

    public void PlayDo(View view) {reproducirSonido(0, "Do");}

    public void PlayRe(View view) {reproducirSonido(1, "Re");}

    public void PlayMi(View view) {reproducirSonido(2, "Mi");}

    public void PlayFa(View view) {reproducirSonido(3, "Fa");}

    public void PlaySol(View view) {reproducirSonido(4, "Sol");}

    public void PlayLa(View view) {reproducirSonido(5, "La");}

    public void PlaySi(View view) {reproducirSonido(6, "Si");}
}
package sv.edu.catolica.pianogrupo07;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Acerca_de extends AppCompatActivity {
    private Toast toastActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.desing_acerca_de);
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
            Intent ventana = new Intent(Acerca_de.this, Acerca_de.class);
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
                        Intent ventana = new Intent(Acerca_de.this, PianoTradicional.class);
                        startActivity(ventana);
                    } else if (pianos[which].equals(getString(R.string.infantil_de_la_selva))) {
                        Intent ventana = new Intent(Acerca_de.this, PianoSalvaje.class);
                        startActivity(ventana);
                    } else if (pianos[which].equals(getString(R.string.instrumentos_musicales))) {
                        Intent ventana = new Intent(Acerca_de.this, PianoInstrumentos.class);
                        startActivity(ventana);
                    }
                }
            });
            builder.create();
            builder.show();
        }
        return super.onOptionsItemSelected(item);
    }

}
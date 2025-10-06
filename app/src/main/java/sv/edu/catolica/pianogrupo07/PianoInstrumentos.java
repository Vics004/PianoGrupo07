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

public class PianoInstrumentos extends AppCompatActivity {

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
}
package celline.lista05.converterbits;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

/*
 *@author:<Celline>
 */
public class MainActivity extends AppCompatActivity {

    private EditText edBits;
    private Spinner spnConverter;
    private Button btnConverter;
    private TextView tvSaida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edBits = findViewById(R.id.edBits);
        spnConverter = findViewById(R.id.spnConverter);
        btnConverter = findViewById(R.id.btnConverter);
        tvSaida = findViewById(R.id.tvSaída);

        preencheSpinner();
        btnConverter.setOnClickListener(op -> converter());
    }

    /*
     *@author:<Celline>
     */
    private void converter() {
        StringBuffer buffer = new StringBuffer();
        String valor = (String) spnConverter.getSelectedItem();
        Double bits = Double.parseDouble(edBits.getText().toString());
        Double res = 0.0;

        Double bytes = bits/8;
        Double KB = bytes/1024;
        Double MB = KB/1024;
        Double GB = MB/1024;
        Double TB = GB/1024;

        if (valor == "Bytes") {
            res = bytes;
            buffer.append("Valor convertido para Bytes = ").append(res);
        }

        if (valor == "KB") {
            res = KB;
            buffer.append("Valor convertido para KB = ").append(res);
        }

        if (valor == "MB") {
            res = MB;
            buffer.append("Valor convertido para MB = ").append(res);
        }

        if (valor == "GB") {
            res = GB;
            buffer.append("Valor convertido para GB = ").append(res);
        }

        if (valor == "TB") {
            res = TB;
            buffer.append("Valor convertido para TB = ").append(res);
        }

        tvSaida.setText(buffer.toString());
    }

    /*
     *@author:<Celline>
     */
    private void preencheSpinner() {
        List<String> lista = new ArrayList<>();

        lista.add("Bytes");
        lista.add("KB");
        lista.add("MB");
        lista.add("GB");
        lista.add("TB");

        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lista);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnConverter.setAdapter(adapter);
    }
}
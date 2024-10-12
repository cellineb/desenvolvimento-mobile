package celline.lista05.Dados;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 *@author:<Celline>
 */
public class MainActivity extends AppCompatActivity {

    private RadioButton rbUmDado;
    private RadioButton rbDoisDados;
    private RadioButton rbTresDados;
    private TextView tvQntdDados;
    private TextView tvFaces;
    private Spinner spnFaces;
    private Button btnLancar;
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

        rbUmDado = findViewById(R.id.rbUmDado);
        rbUmDado.setChecked(true);
        rbDoisDados = findViewById(R.id.rbDoisDados);
        rbTresDados = findViewById(R.id.rbTresDados);
        spnFaces = findViewById(R.id.spnFaces);
        btnLancar = findViewById(R.id.btnLancar);
        tvSaida = findViewById(R.id.tvSaida);

        preencheSpinner();
        btnLancar.setOnClickListener(op -> gerar());
    }

    /*
     *@author:<Celline>
     */
    private void gerar() {
        StringBuffer buffer = new StringBuffer();
        Integer qntd = (Integer) spnFaces.getSelectedItem();
        Random random = new Random();
        int res1;
        int res2;
        int res3;

        if (rbUmDado.isChecked()) {
            res1 = random.nextInt(qntd) + 1;
            buffer.append("Dado 1: ").append(res1).append("\n");
        }
        if (rbDoisDados.isChecked()) {
            res1 = random.nextInt(qntd) + 1;
            res2 = random.nextInt(qntd) + 1;
            buffer.append("Dado 1: ").append(res1).append("\n");
            buffer.append("Dado 2: ").append(res2).append("\n");

        }
        if (rbTresDados.isChecked()) {
            res1 = random.nextInt(qntd) + 1;
            res2 = random.nextInt(qntd) + 1;
            res3 = random.nextInt(qntd) + 1;
            buffer.append("Dado 1: ").append(res1).append("\n");
            buffer.append("Dado 2: ").append(res2).append("\n");
            buffer.append("Dado 3: ").append(res3).append("\n");
        }

        tvSaida.setText(buffer.toString());

    }

    /*
     *@author:<Celline>
     */
    private void preencheSpinner() {
        List<Integer> lista = new ArrayList<>();

        lista.add(4);
        lista.add(6);
        lista.add(8);
        lista.add(10);
        lista.add(12);
        lista.add(20);
        lista.add(100);

        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lista);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnFaces.setAdapter(adapter);

    }
}
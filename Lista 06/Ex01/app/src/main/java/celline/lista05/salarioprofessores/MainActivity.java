package celline.lista05.salarioprofessores;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import celline.lista05.salarioprofessores.model.Horista;
import celline.lista05.salarioprofessores.model.Titular;

/*
 *@author: Celline
 */
public class MainActivity extends AppCompatActivity {

    private EditText etNomeP;
    private EditText etMatricula;
    private EditText etIdade;
    private RadioButton rbTitular;
    private RadioButton rbHorista;
    private Button btnCalcular;
    private TextView tvSaida;
    private EditText etAnos;
    private EditText etQntdHoras;
    private EditText etHoristaValor;

    @SuppressLint("MissingInflatedId")
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

        etNomeP = findViewById(R.id.etNomeP);
        etMatricula = findViewById(R.id.etMatricula);
        etIdade = findViewById(R.id.etIdade);
        rbTitular = findViewById(R.id.rbTitular);
        rbTitular.setChecked(true);
        rbHorista = findViewById(R.id.rbHorista);
        btnCalcular = findViewById(R.id.btnCalcular);
        tvSaida = findViewById(R.id.tvSaida);
        etAnos = findViewById(R.id.etAnos);
        etQntdHoras = findViewById(R.id.etQntdHoras);
        etHoristaValor = findViewById(R.id.etHoristaValor);

        btnCalcular.setOnClickListener(op -> calcular());


    }

    /*
     *@author: Celline
     */
    private void calcular() {
        if (rbTitular.isChecked()) {
            Titular titular = new Titular();
            titular.setNome(etNomeP.getText().toString());
            titular.setMatricula(etMatricula.getText().toString());
            titular.setIdade(Integer.parseInt(etIdade.getText().toString()));
            titular.setAnosInstituicao(Integer.parseInt(etAnos.getText().toString()));

            tvSaida.setText(String.valueOf("O salário do professor é R$" + titular.calcSalario()));
        }

        if (rbHorista.isChecked()) {
            Horista horista = new Horista();
            horista.setNome(etNomeP.getText().toString());
            horista.setMatricula(etMatricula.getText().toString());
            horista.setIdade(Integer.parseInt(etIdade.getText().toString()));
            horista.setHorasAula(Integer.parseInt(etQntdHoras.getText().toString()));
            horista.setValorHoraAula(Double.parseDouble(etHoristaValor.getText().toString()));

            tvSaida.setText(String.valueOf("O salário do professor é R$" + horista.calcSalario()));
        }
    }
}
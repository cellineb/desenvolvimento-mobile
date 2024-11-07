package celline.lista08.figuras;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import celline.lista08.figuras.controller.IGeometriaController;
import celline.lista08.figuras.controller.OperacaoCirculo;
import celline.lista08.figuras.model.Circulo;

public class CirculoFragment extends Fragment {

    private View view;
    private EditText etRaio;
    private Button btnAreaC;
    private Button btnPerimetroC;
    private TextView tvSaidaC;

    public CirculoFragment() {
        super();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_circulo, container, false);

        etRaio = view.findViewById(R.id.etRaio);
        btnAreaC = view.findViewById(R.id.btnAreaC);
        btnPerimetroC = view.findViewById(R.id.btnPerimetroC);
        tvSaidaC = view.findViewById(R.id.tvSaidaC);

        btnAreaC.setOnClickListener(op -> calculaArea());
        btnPerimetroC.setOnClickListener(op -> calculaPerimetro());

        return view;
    }

    private void calculaPerimetro() {
        Circulo c = new Circulo();
        c.setRaio(Float.parseFloat(etRaio.getText().toString()));

        IGeometriaController<Circulo> op = new OperacaoCirculo();
        float p = op.Perimetro(c);

        tvSaidaC.setText("Perimetro do circulo: " + p);
        limpaCampos();
    }

    private void limpaCampos() {
        etRaio.setText("");
    }

    private void calculaArea() {
        Circulo c = new Circulo();
        c.setRaio(Float.parseFloat(etRaio.getText().toString()));

        IGeometriaController<Circulo> op = new OperacaoCirculo();
        float a = op.Area(c);

        tvSaidaC.setText("Área do círculo: " + a);
        limpaCampos();
    }
}
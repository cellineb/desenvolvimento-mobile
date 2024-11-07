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
import celline.lista08.figuras.controller.OperacaoRetangulo;
import celline.lista08.figuras.model.Retangulo;

public class RetanguloFragment extends Fragment {

    private View view;
    private EditText etBase;
    private EditText etAltura;
    private Button btnAreaR;
    private Button btnPerimetroR;
    private TextView tvSaidaR;

    public RetanguloFragment() {
       super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_retangulo, container, false);

        etBase = view.findViewById(R.id.etBase);
        etAltura = view.findViewById(R.id.etAltura);
        btnAreaR = view.findViewById(R.id.btnAreaR);
        btnPerimetroR = view.findViewById(R.id.btnPerimetroR);
        tvSaidaR = view.findViewById(R.id.tvSaidaR);
        
        btnAreaR.setOnClickListener(op -> calculaArea());
        btnPerimetroR.setOnClickListener(op -> calculaPerimetro());

        return view;
    }

    private void calculaPerimetro() {
        Retangulo r = new Retangulo();
        r.setBase(Float.parseFloat(etBase.getText().toString()));
        r.setAltura(Float.parseFloat(etAltura.getText().toString()));

        IGeometriaController<Retangulo> op = new OperacaoRetangulo();
        float p = op.Perimetro(r);

        tvSaidaR.setText("Perimetro do retângulo: " + p);
        limpaCampos();
    }

    private void limpaCampos() {
        etBase.setText("");
        etAltura.setText("");
    }

    private void calculaArea() {
        Retangulo r = new Retangulo();
        r.setBase(Float.parseFloat(etBase.getText().toString()));
        r.setAltura(Float.parseFloat(etAltura.getText().toString()));

        IGeometriaController<Retangulo> op = new OperacaoRetangulo();
        float a = op.Area(r);

        tvSaidaR.setText("Área do retângulo: " + a);
        limpaCampos();
    }
}
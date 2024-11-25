package celline.lista13.biblioteca;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class AluguelFragment extends Fragment {

    private View view;
    private Spinner spnAlunoAL;
    private Spinner spnExemplarAL;
    private EditText etDataRetiradaAL;
    private EditText etDataDevolucaoAL;
    private Button btnBuscarAL;
    private Button btnInserirAL;
    private Button btnEditarAL;
    private Button btnExcluirAL;
    private Button btnListarAL;
    private TextView tvSaidaAL;

    public AluguelFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_aluguel, container, false);

        spnAlunoAL = view.findViewById(R.id.spnAlunoAL);
        spnExemplarAL = view.findViewById(R.id.spnExemplarAL);
        etDataRetiradaAL = view.findViewById(R.id.etDataRetiradaAL);
        etDataDevolucaoAL = view.findViewById(R.id.etDataDevolucaoAL);
        btnBuscarAL = view.findViewById(R.id.btnBuscarAL);
        btnInserirAL = view.findViewById(R.id.btnInserirAL);
        btnEditarAL = view.findViewById(R.id.btnEditarAL);
        btnExcluirAL = view.findViewById(R.id.btnExcluirAL);
        btnListarAL = view.findViewById(R.id.btnListarAL);
        tvSaidaAL = view.findViewById(R.id.tvSaidaAL);
        tvSaidaAL.setMovementMethod(new ScrollingMovementMethod());
        
        preencheSpinner();

        return view;
    }

    private void preencheSpinner() {
    }
}
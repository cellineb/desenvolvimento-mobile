package celline.lista08.timejogador;

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

public class JogadorFragment extends Fragment {

    private View view;
    private EditText etNomeJ;
    private EditText etCodJ;
    private EditText etNascJ;
    private EditText etAlturaJ;
    private EditText etPesoJ;
    private Spinner spnTimeJ;
    private Button btnBuscarJ;
    private Button btnInserirJ;
    private Button btnEditarJ;
    private Button btnExcluirJ;
    private Button btnListarJ;
    private TextView tvSaidaJ;


    public JogadorFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_jogador, container, false);

        etNomeJ = view.findViewById(R.id.etNomeJ);
        etCodJ = view.findViewById(R.id.etCodJ);
        etNascJ = view.findViewById(R.id.etNascJ);
        etAlturaJ = view.findViewById(R.id.etAlturaJ);
        etPesoJ = view.findViewById(R.id.etPesoJ);
        spnTimeJ = view.findViewById(R.id.spnTimeJ);
        btnBuscarJ = view.findViewById(R.id.btnBuscarJ);
        btnInserirJ = view.findViewById(R.id.btnInserirJ);
        btnEditarJ = view.findViewById(R.id.btnEditarJ);
        btnExcluirJ = view.findViewById(R.id.btnExcluirJ);
        btnListarJ = view.findViewById(R.id.btnListarJ);
        tvSaidaJ = view.findViewById(R.id.tvSaidaJ);
        tvSaidaJ.setMovementMethod(new ScrollingMovementMethod());

        return view;
    }
}
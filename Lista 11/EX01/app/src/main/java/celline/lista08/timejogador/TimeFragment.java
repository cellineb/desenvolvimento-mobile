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

public class TimeFragment extends Fragment {

    private View view;
    private EditText etNomeT;
    private EditText etCodT;
    private EditText etCidadeT;
    private Button btnBuscarT;
    private Button btnInserirT;
    private Button btnEditarT;
    private Button btnExcluirT;
    private Button btnListarT;
    private TextView tvSaidaT;

    public TimeFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_time, container, false);

        etNomeT = view.findViewById(R.id.etNomeT);
        etCodT = view.findViewById(R.id.etCodT);
        etCidadeT = view.findViewById(R.id.etCidadeT);
        btnBuscarT = view.findViewById(R.id.btnBuscarT);
        btnInserirT = view.findViewById(R.id.btnInserirT);
        btnEditarT = view.findViewById(R.id.btnEditarT);
        btnExcluirT = view.findViewById(R.id.btnExcluirT);
        btnListarT = view.findViewById(R.id.btnListarT);
        tvSaidaT = view.findViewById(R.id.tvSaidaT);
        tvSaidaT.setMovementMethod(new ScrollingMovementMethod());

        return view;
    }
}
package celline.lista13.biblioteca;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AlunoFragment extends Fragment {

    private View view;
    private EditText etRAA;
    private EditText etNomeA;
    private EditText etEmailA;
    private Button btnBuscarA;
    private Button btnInserirA;
    private Button btnEditarA;
    private Button btnExcluirA;
    private Button btnListarA;
    private TextView tvSaidaA;

    public AlunoFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_aluno, container, false);

        etRAA = view.findViewById(R.id.etRAA);
        etNomeA = view.findViewById(R.id.etNomeA);
        etEmailA = view.findViewById(R.id.etEmailA);
        btnBuscarA = view.findViewById(R.id.btnBuscarA);
        btnInserirA = view.findViewById(R.id.btnInserirA);
        btnEditarA = view.findViewById(R.id.btnEditarA);
        btnExcluirA = view.findViewById(R.id.btnExcluirA);
        btnListarA = view.findViewById(R.id.btnListarA);
        tvSaidaA = view.findViewById(R.id.tvSaidaA);
        tvSaidaA.setMovementMethod(new ScrollingMovementMethod());

        return view;
    }
}
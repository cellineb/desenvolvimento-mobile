package celline.lista13.biblioteca;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class ExemplarFragment extends Fragment {

    private View view;
    private EditText etCodigoE;
    private EditText etNomeE;
    private EditText etPaginasE;
    private RadioButton rbLivroE;
    private RadioButton rbRevistaE;
    private EditText etISBNE;
    private EditText etEdicao;
    private EditText etISSNE;
    private Button btnBuscarE;
    private Button btnInserirE;
    private Button btnEditarE;
    private Button btnExcluirE;
    private Button btnListarE;
    private TextView tvSaidaE;

    public ExemplarFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_exemplar, container, false);

        etCodigoE = view.findViewById(R.id.etCodigoE);
        etNomeE = view.findViewById(R.id.etNomeE);
        etPaginasE = view.findViewById(R.id.etPaginasE);
        rbLivroE = view.findViewById(R.id.rbLivroE);
        rbLivroE.setChecked(true);
        rbRevistaE = view.findViewById(R.id.rbRevistaE);
        etISBNE = view.findViewById(R.id.etISBNE);
        etISSNE = view.findViewById(R.id.etISSNE);
        etEdicao = view.findViewById(R.id.etEdicaoE);
        btnBuscarE = view.findViewById(R.id.btnBuscarE);
        btnInserirE = view.findViewById(R.id.btnInserirE);
        btnEditarE = view.findViewById(R.id.btnEditarE);
        btnExcluirE = view.findViewById(R.id.btnExcluirE);
        btnListarE = view.findViewById(R.id.btnListarE);
        tvSaidaE = view.findViewById(R.id.tvSaidaE);
        tvSaidaE.setMovementMethod(new ScrollingMovementMethod());

        return view;
    }
}
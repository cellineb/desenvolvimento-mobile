package celline.trabalhosemestral.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/*
 *@author: Celline
 */
public class MainActivity extends AppCompatActivity {

    private Fragment fragment;

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

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            carregaFragment(bundle);
        } else {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment, new InicioFragment());
            fragmentTransaction.commit();
        }

    }

    private void carregaFragment(Bundle bundle) {
        String tipo = bundle.getString("tipo");
        if (tipo.equals("compromissos")) {
            fragment = new CompromissosFragment();
        } else if (tipo.equals("tarefas")) {
            fragment = new TarefasFragment();
        } else if (tipo.equals("disciplinas")) {
            try {
                fragment = new DisciplinaFragment();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Bundle bundle = new Bundle();
        Intent intent = new Intent(this, MainActivity.class);

        if (id == R.id.itemCompromissos) {
            bundle.putString("tipo", "compromissos");
            intent.putExtras(bundle);
            this.startActivity(intent);
            this.finish();
            return true;
        } else if (id == R.id.itemTarefas) {
            bundle.putString("tipo", "tarefas");
            intent.putExtras(bundle);
            this.startActivity(intent);
            this.finish();
            return true;
        } else if (id == R.id.itemDisciplinas) {
            try {
                bundle.putString("tipo", "disciplinas");
                intent.putExtras(bundle);
                this.startActivity(intent);
                this.finish();
                return true;
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }
        return true;
    }
}
package consumo.api.esportesapi.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import consumo.api.esportesapi.R;
import consumo.api.esportesapi.model.Sport;
import consumo.api.esportesapi.viewmodel.SportViewModel;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SportViewModel charactersViewModel;
    private List<Sport> results = new ArrayList<>();
    private SportAdapter adapterCharacters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapterCharacters);

        charactersViewModel.getListCharacters();

        charactersViewModel.listLiveData.observe(this, results1 -> adapterCharacters.setUpdate(results1));
    }

    public void initViews(){
        recyclerView = findViewById(R.id.recycler_view);
        charactersViewModel = ViewModelProviders.of(this).get(SportViewModel.class);
        adapterCharacters = new SportAdapter(results);

    }
}

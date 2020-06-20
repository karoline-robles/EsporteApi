package consumo.api.esportesapi.view;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import consumo.api.esportesapi.R;
import consumo.api.esportesapi.model.Sport;

public class DetalheActivity extends AppCompatActivity {
    private TextView textViewCategoria;
    private ImageView imagem;
    private TextView textViewDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalhe_esporte);
        initViews();
        if (getIntent() != null){
            Sport sport = getIntent().getExtras().getParcelable("esporte");
            Picasso.get().load(sport.getStrSportThumb()).into(imagem);
            textViewDescription.setText(sport.getStrSportDescription());
            textViewCategoria.setText(sport.getStrSport());
        }
    }

    public void initViews(){
        textViewCategoria = findViewById(R.id.text_view_categoria);
        imagem = findViewById(R.id.imageView_detalhe);
        textViewDescription = findViewById(R.id.text_view_description);
    }

}

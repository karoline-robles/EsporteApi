package consumo.api.esportesapi.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import consumo.api.esportesapi.R;
import consumo.api.esportesapi.model.Sport;

public class SportAdapter extends RecyclerView.Adapter<SportAdapter.ViewHolder> {
    private List<Sport> resultList;

    public SportAdapter(List<Sport> resultList) {
        this.resultList = resultList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Sport sport = resultList.get(position);
        holder.bind(sport);
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetalheActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("esporte", sport);
                intent.putExtras(bundle);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return resultList.size(); }

    public void setUpdate(List<Sport> results) {
        if (this.resultList.isEmpty()) {
            this.resultList = results;
        } else {
            this.resultList.addAll(results);
        }
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nome;
        ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.txt_card);
            img = itemView.findViewById(R.id.imgCharacter_card);
        }

        public void bind(Sport result) {
            nome.setText(result.getStrSport());
            Picasso.get().load(result.getStrSportThumb()).into(img);
        }
    }
}

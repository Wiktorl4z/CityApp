package pl.futuredev.capstoneproject.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pl.futuredev.capstoneproject.R;
import pl.futuredev.capstoneproject.data.local.entities.City;


public class FavouritesCityAdapter extends RecyclerView.Adapter<FavouritesCityAdapter.ViewHolder> {

    List<City> cities;

    public FavouritesCityAdapter(List<City> cities) {
        this.cities = cities;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView ivCity;
        TextView tvCityName;
        TextView tvCitySnippet;
        TextView tvCountryId;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int clickPosition = getAdapterPosition();
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_city_result, parent, false);
        view.setFocusable(true);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ImageView ivCity = holder.ivCity;
        TextView tvCityName = holder.tvCityName;
        TextView tvCitySnippet = holder.tvCitySnippet;
        TextView tvCountryId = holder.tvCountryId;

    //    List<Image> images = cities.get(position).getImages();
 /*       if (images != null && !images.isEmpty()) {
            Original originalImage = images.get(0).getSizes().getOriginal();
            Picasso.get()
                    .load(originalImage.getUrl())
                    .into(ivCity, new Callback() {
                        @Override
                        public void onSuccess() {
                            Picasso.get().load(originalImage.getUrl()).into(ivCity);

                        }

                        @Override
                        public void onError(Exception e) {
                            Picasso.get().load(R.drawable.rest1).into(ivCity);
                        }
                    });
        }*/
        tvCountryId.setText(cities.get(position).getCityId());
        tvCityName.setText(cities.get(position).getName());
        tvCitySnippet.setText(cities.get(position).getSnippet());
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

}
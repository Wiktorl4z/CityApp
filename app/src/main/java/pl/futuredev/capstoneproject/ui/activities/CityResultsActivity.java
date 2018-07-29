package pl.futuredev.capstoneproject.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import pl.futuredev.capstoneproject.R;
import pl.futuredev.capstoneproject.models.Result;
import pl.futuredev.capstoneproject.ui.adapters.CityResultAdapter;
import pl.futuredev.capstoneproject.ui.interfaces.IOnClickHandler;

public class CityResultsActivity extends AppCompatActivity implements IOnClickHandler {

    @BindView(R.id.my_recycler_view)
    RecyclerView myRecyclerView;
    private CityResultAdapter cityResultAdapter;
    private List<Result> resultCity;
    private LinearLayoutManager linearLayoutManager;
    private static final String CITY_NAME = "city";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_result);
        ButterKnife.bind(this);

        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        resultCity = getIntent().getParcelableArrayListExtra("city");
        cityResultAdapter = new CityResultAdapter(resultCity,CityResultsActivity.this::onClick);
        ScaleInAnimationAdapter scaleInAnimationAdapter = new ScaleInAnimationAdapter(cityResultAdapter);
        scaleInAnimationAdapter.setDuration(1650);
        scaleInAnimationAdapter.setFirstOnly(false);
        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setLayoutManager(linearLayoutManager);
        myRecyclerView.setAdapter(scaleInAnimationAdapter);


    }

    @Override
    public void onClick(int clickedItemIndex) {
        Intent intent = new Intent(CityResultsActivity.this, MainCityActivity.class);
        intent.putExtra(CITY_NAME, resultCity.get(clickedItemIndex).getId());
        startActivity(intent);
    }
}
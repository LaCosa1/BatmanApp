package fsociety.batmanmovie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;


import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

   ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("http://www.omdbapi.com").build();
        Servicio servicio = restAdapter.create(Servicio.class);
        servicio.ObtenerMovie(new Callback<Result>() {
            @Override
            public void success(Result result, Response response) {

                Adapter adapter = new Adapter(result.Search,getApplicationContext());
                listView.setAdapter(adapter);



            }

            @Override
            public void failure(RetrofitError retrofitError) {

            }
        });


    }}



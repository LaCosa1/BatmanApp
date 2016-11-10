package fsociety.batmanmovie;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by FSociety on 02/11/2016.
 */
public interface Servicio {

    @GET("/?s=batman")
    void ObtenerMovie(Callback<Result> callback);

}

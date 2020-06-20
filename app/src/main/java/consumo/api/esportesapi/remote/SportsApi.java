package consumo.api.esportesapi.remote;

import consumo.api.esportesapi.model.SportsService;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface SportsApi {
    @GET("all_sports.php")
    Observable<SportsService> getCategoriaResponse();
}

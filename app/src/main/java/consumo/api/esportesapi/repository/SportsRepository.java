package consumo.api.esportesapi.repository;

import consumo.api.esportesapi.model.SportsService;
import io.reactivex.Observable;

import static consumo.api.esportesapi.remote.ServiceRetrofit.getApiService;

public class SportsRepository {
    public Observable<SportsService> sportObservable(){
        return getApiService().getCategoriaResponse();
    }
}

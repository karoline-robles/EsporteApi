package consumo.api.esportesapi.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import consumo.api.esportesapi.model.Sport;
import consumo.api.esportesapi.repository.SportsRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class SportViewModel extends AndroidViewModel {
    private MutableLiveData<List<Sport>> listMutableLiveData = new MutableLiveData<>();
    public LiveData<List<Sport>> listLiveData = listMutableLiveData;
    private CompositeDisposable disposable = new CompositeDisposable();
    private SportsRepository respository = new SportsRepository();

    public SportViewModel(@NonNull Application application) { super(application); }

    public void getListCharacters() {
        disposable.add(
                respository.sportObservable()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(sportResponse -> listMutableLiveData.setValue(sportResponse.getSports()),
                                throwable -> Log.i("LOG", "MESSAGE -> " + throwable.getMessage()))
        );
    }
    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}


package consumo.api.esportesapi.model;

import java.util.List;
import com.google.gson.annotations.Expose;


@SuppressWarnings("unused")
public class SportsService {
    @Expose
    private List<Sport> sports;

    public List<Sport> getSports() {
        return sports; }

    public void setSports(List<Sport> sports) {
        this.sports = sports;
    }

}

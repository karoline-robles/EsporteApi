
package consumo.api.esportesapi.model;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

@SuppressLint("ParcelCreator")
public class Sport implements Parcelable {

    @Expose
    private String idSport;
    @Expose
    private String strFormat;
    @Expose
    private String strSport;
    @Expose
    private String strSportDescription;
    @Expose
    private String strSportThumb;
    @Expose
    private String strSportThumbGreen;

    protected Sport(Parcel in) {
        idSport = in.readString();
        strFormat = in.readString();
        strSport = in.readString();
        strSportDescription = in.readString();
        strSportThumb = in.readString();
        strSportThumbGreen = in.readString();
    }

    public static final Creator<Sport> CREATOR = new Creator<Sport>() {
        @Override
        public Sport createFromParcel(Parcel in) {
            return new Sport(in);
        }

        @Override
        public Sport[] newArray(int size) {
            return new Sport[size];
        }
    };

    public String getIdSport() {
        return idSport;
    }

    public void setIdSport(String idSport) {
        this.idSport = idSport;
    }

    public String getStrFormat() {
        return strFormat;
    }

    public void setStrFormat(String strFormat) {
        this.strFormat = strFormat;
    }

    public String getStrSport() {
        return strSport;
    }

    public void setStrSport(String strSport) {
        this.strSport = strSport;
    }

    public String getStrSportDescription() {
        return strSportDescription;
    }

    public void setStrSportDescription(String strSportDescription) {
        this.strSportDescription = strSportDescription;
    }

    public String getStrSportThumb() {
        return strSportThumb;
    }

    public void setStrSportThumb(String strSportThumb) {
        this.strSportThumb = strSportThumb;
    }

    public String getStrSportThumbGreen() {
        return strSportThumbGreen;
    }

    public void setStrSportThumbGreen(String strSportThumbGreen) {
        this.strSportThumbGreen = strSportThumbGreen;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idSport);
        dest.writeString(strFormat);
        dest.writeString(strSport);
        dest.writeString(strSportDescription);
        dest.writeString(strSportThumb);
        dest.writeString(strSportThumbGreen);
    }
}

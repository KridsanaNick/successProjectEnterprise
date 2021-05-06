package model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONObject;

@Generated("jsonschema2pojo")
public class Covid {

    @SerializedName("Confirmed")
    @Expose
    private Integer confirmed;

    @SerializedName("Recovered")
    @Expose
    private Integer recovered;

    @SerializedName("Hospitalized")
    @Expose
    private Integer hospitalized;

    @SerializedName("Deaths")
    @Expose
    private Integer deaths;

    @SerializedName("NewConfirmed")
    @Expose
    private Integer newConfirmed;

    @SerializedName("NewRecovered")
    @Expose
    private Integer newRecovered;

    @SerializedName("NewHospitalized")
    @Expose
    private Integer newHospitalized;

    @SerializedName("NewDeaths")
    @Expose
    private Integer newDeaths;

    @SerializedName("UpdateDate")
    @Expose
    private String updateDate;

    @SerializedName("Source")
    @Expose
    private String source;

    @SerializedName("DevBy")
    @Expose
    private String devBy;

    @SerializedName("SeverBy")
    @Expose
    private String severBy;

    public void Json() throws MalformedURLException, IOException {
        String api = "https://covid19.th-stat.com/api/open/today";
        URL url = new URL(api);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        if (con.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + con.getResponseCode());
        }
        StringBuffer response;
        BufferedReader in = new BufferedReader(new InputStreamReader(
                (con.getInputStream())));

        String inputLine;
        response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        String string = response.toString();
        System.out.println(string);
        JSONObject json = new JSONObject(string);

        confirmed = json.getInt("Confirmed");
        recovered = json.getInt("Recovered");
        hospitalized = json.getInt("Hospitalized");
        deaths = json.getInt("Deaths");
        newConfirmed = json.getInt("NewConfirmed");
        newRecovered = json.getInt("NewRecovered");
        newHospitalized = json.getInt("NewHospitalized");
        newDeaths = json.getInt("NewDeaths");
        updateDate = json.getString("UpdateDate");
        source = json.getString("Source");
        devBy = json.getString("DevBy");
        severBy = json.getString("SeverBy");

    }

    public Integer getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Integer confirmed) {
        this.confirmed = confirmed;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public Integer getHospitalized() {
        return hospitalized;
    }

    public void setHospitalized(Integer hospitalized) {
        this.hospitalized = hospitalized;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Integer getNewConfirmed() {
        return newConfirmed;
    }

    public void setNewConfirmed(Integer newConfirmed) {
        this.newConfirmed = newConfirmed;
    }

    public Integer getNewRecovered() {
        return newRecovered;
    }

    public void setNewRecovered(Integer newRecovered) {
        this.newRecovered = newRecovered;
    }

    public Integer getNewHospitalized() {
        return newHospitalized;
    }

    public void setNewHospitalized(Integer newHospitalized) {
        this.newHospitalized = newHospitalized;
    }

    public Integer getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(Integer newDeaths) {
        this.newDeaths = newDeaths;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDevBy() {
        return devBy;
    }

    public void setDevBy(String devBy) {
        this.devBy = devBy;
    }

    public String getSeverBy() {
        return severBy;
    }

    public void setSeverBy(String severBy) {
        this.severBy = severBy;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author kridsana
 */
public class CovidRank {

//    private String[] Province = {"Bangkok", "Phuket", "Nonthaburi", "Yala", "SamutPrakan", "Songkhla", "Pattani", "Chonburi", "ChiangMai", "PathumThani", "Narathiwat", "NakhonPathom", "Chumphon", "Krabi", "NakhonRatchasima", "SuratThani", "Satun", "PrachuapKhiriKhan", "Chachoengsao", "UbonRatchathani", "Phatthalung", "SamutSakhon", "Buriram", "NakhonSiThammarat",
//        "NakhonSawan", "SaKaeo", "Surin", "Kanchanaburi", "UdonThani", "Sisaket", "ChiangRai", "Prachinburi", "Ratchaburi", "SuphanBuri", "Trang", "Phitsanulok", "KhonKaen", "Rayong",
//        "MaeHongSon", "Loei", "PhraNakhonSiAyutthaya", "Lampang"};
//    private int ProvinceValue[] = new int[Province.length];
//    private int Top[] = new int[5];
    private Integer Male;
    private Integer Female;
    private Integer Unknown;
    private String LastData;
    private String UpdateDate;
    private String Source;
    private String DevBy;
    private String SeverBy;

    public void Json() throws MalformedURLException, IOException {
        String api = "https://covid19.th-stat.com/api/open/cases/sum";
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
        if (!string.equals("")) {
            JSONObject json = new JSONObject(string);
//
//        for (int i = 0; i < Province.length; i++) {
//
//            ProvinceValue[i] = json.getJSONObject("Province").getInt(Province[i]);
//
//        }
            Male = json.getJSONObject("Gender").getInt("Male");
            Female = json.getJSONObject("Gender").getInt("Female");
            Unknown = json.getJSONObject("Gender").getInt("Unknown");

            LastData = json.getString("LastData");
            UpdateDate = json.getString("UpdateDate");
            Source = json.getString("Source");
            DevBy = json.getString("DevBy");
            SeverBy = json.getString("SeverBy");
        } else {
            Male = 1000;
            Female = 1500;
            Unknown = 500;
            UpdateDate = "api Err";
        }

//
    }

    // Getter Methods 
    public Integer getMale() {
        return Male;
    }

    public Integer getFemale() {
        return Female;
    }

    public Integer getUnknown() {
        return Unknown;
    }

    public String getLastData() {
        return LastData;
    }

    public String getUpdateDate() {
        return UpdateDate;
    }

    public String getSource() {
        return Source;
    }

    public String getDevBy() {
        return DevBy;
    }

    public String getSeverBy() {
        return SeverBy;
    }

}

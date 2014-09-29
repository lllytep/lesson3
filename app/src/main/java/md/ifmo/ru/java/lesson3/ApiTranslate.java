package md.ifmo.ru.java.lesson3;

import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by lllytep on 29.09.2014.
 */

public class ApiTranslate {
    private static final String URL = "https://translate.yandex.net/api/v1.5/tr.json/translate?";
    private static final String API_KEY = "trnsl.1.1.20140929T160445Z.da0a77214d42cd6f.6433faebe0aad4294369b7596e758e7a346ce124";
    private static final String LANG = "en-ru";
    private static final String FORMAT = "";
    private static final String OPTIONS = "";
    private static final String CALLBACK = "jsonObject";
    private HttpClient client;
    private JSONObject jsonObject;



    private String text;

    public ApiTranslate(String text){
        this.text = text;
        client = new DefaultHttpClient();
        jsonObject = new JSONObject();
        HttpGet httpGet = new HttpGet(URL +
                "key=" + API_KEY +
                "&text=" + this.text +
                "&lang=" + LANG +
                "&format=" + FORMAT +
                "&options=" + OPTIONS +
                "&callback=" + CALLBACK);
        Log.i(ApiTranslate.class.getName(), httpGet.getMethod());
        HttpResponse httpResponse = null;
        try {
            httpResponse = client.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.i( ApiTranslate.class.getName(),httpResponse.getEntity().toString());

    }

    /*public String getTextTranslate(){

    }*/


}

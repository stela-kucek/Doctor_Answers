package at.ac.univie.team8.doctoranswers;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Stela on 27.05.2016.
 */
public class CountDoctorsRequest extends StringRequest {

    private static final String REQUEST_URL = "http://doctoranswers.comlu.com/CountDocs.php";
    private Map<String, String> params;

    public CountDoctorsRequest(int userID, Response.Listener<String> listener) {
        super(Request.Method.POST, REQUEST_URL, listener, null);
        params = new HashMap<>();

        params.put("user_id", userID + "");
    }
    @Override
    public Map<String, String> getParams() {
        return params;
    }
}

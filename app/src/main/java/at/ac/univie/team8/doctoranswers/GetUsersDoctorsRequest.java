package at.ac.univie.team8.doctoranswers;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Stela on 26.05.2016.
 */
public class GetUsersDoctorsRequest extends StringRequest {

    private static final String REQUEST_URL = "http://doctoranswers.comlu.com/UsersDoctors.php";
    private Map<String, String> params;

    public GetUsersDoctorsRequest(int userID, Response.Listener<String> listener) {
        super(Method.POST, REQUEST_URL, listener, null);
        params = new HashMap<>();

        params.put("user_id", userID + "");
    }
    @Override
    public Map<String, String> getParams() {
        return params;
    }
}

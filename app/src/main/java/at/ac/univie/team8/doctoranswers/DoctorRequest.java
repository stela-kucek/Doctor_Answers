package at.ac.univie.team8.doctoranswers;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Stela on 26.05.2016.
 */
public class DoctorRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://doctoranswers.comlu.com/NewDoc.php";
    private Map<String, String> params;

    public DoctorRequest(String name, String address, String contact, String category, int userID, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("name", name);
        params.put("specialization", category);
        params.put("address", address);
        params.put("contact", contact);
        params.put("user_id", userID + "");
    }
    @Override
    public Map<String, String> getParams() {
        return params;
    }
}

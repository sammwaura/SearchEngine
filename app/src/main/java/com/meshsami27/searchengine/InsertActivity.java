package com.meshsami27.searchengine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class InsertActivity extends AppCompatActivity {

    EditText et_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        et_name = findViewById(R.id.name);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_insert, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.insert:
                //save names
                final String name = et_name.getText().toString().trim();

                if (name.isEmpty()) {
                    et_name.setError("Please enter your name");
                } else {

                    StringRequest stringRequest = new StringRequest(Request.Method.POST,
                            "http://enginesearch.000webhostapp.com/save.php",
                            new Response.Listener <String>() {
                                @Override
                                public void onResponse(String response) {
                                    Toast.makeText(InsertActivity.this, "Successfully Saved", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(intent);
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }) {
                        @Override
                        protected Map <String, String> getParams() {
                            Map <String, String> params = new HashMap <>();
                            params.put("name", name);
                            System.out.println("######" + name);
                            return params;
                        }
                    };
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(stringRequest);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

package com.example.yashpandya.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Adapter.OnItemClickListener{
    private RecyclerView recyclerView;
    private RecyclerView.Adapter myadapter;
    private static final String API_URL="https://simplifiedcoding.net/demos/marvel";
    private List<Listitem> listitems;
    private static final String DATA_URL="https://simplifiedcoding.net/demos/marvel/";

    public static final String GET_BIO = "bio";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listitems=new ArrayList<>();

        recyclerView= (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadjsondata();
//        listitems.add(new Listitem(1, "Dell Laptop","13.3 inch, Silver, 1.35 kg",4.0,5000,R.drawable.dell));
//        listitems.add(new Listitem(1, "Lenovo Laptop","13.3 inch, black, 1.35 kg",4.6,6000,R.drawable.lenovo));
//        listitems.add(new Listitem(1, "hp Laptop","13.3 inch, white, 1.35 kg",3.7,4500,R.drawable.hp));


    }

    private void loadjsondata() {
        StringRequest strignrequest=new StringRequest(Request.Method.GET, DATA_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray=new JSONArray(response);

                    for (int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject=jsonArray.getJSONObject(i);

                        String name=jsonObject.getString("name");
                        String team=jsonObject.getString("team");
                        int year=jsonObject.getInt("firstappearance");
                        String publisher=jsonObject.getString("publisher");
                        String image=jsonObject.getString("imageurl");
                        String bio=jsonObject.getString("bio");

                        Listitem hero=new Listitem(name,team,year,publisher,image,bio);
                        listitems.add(hero);
                    }
                    myadapter=new Adapter(MainActivity.this,listitems);
                    recyclerView.setAdapter(myadapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(this).add(strignrequest);
    }


    @Override
    public void onItemClick(View v, int position) {
        Intent detailintent=new Intent(this,Itemdetails.class);
        Listitem itemdetails=listitems.get(position);
        detailintent.putExtra(GET_BIO,itemdetails.getBio());
        Log.i("bio is",itemdetails.getBio());
        startActivity(detailintent);
    }
}

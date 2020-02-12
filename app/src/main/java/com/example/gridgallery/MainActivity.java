package com.example.gridgallery;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.gridgallery.model.Nasa;
import com.example.gridgallery.network.APIclient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    CustomAdapter customAdapter;
    float x1,y1,x2,y2;

    public static List<Nasa> nasaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView=findViewById(R.id.gridView);

        nasaList=new ArrayList<>();

        Call<List<Nasa>> call= APIclient.apIinterface().getNasa();

        call.enqueue(new Callback<List<Nasa>>() {
            @Override
            public void onResponse(Call<List<Nasa>> call, Response<List<Nasa>> response) {

                if (response.isSuccessful()){


                    nasaList=response.body();

                    customAdapter = new CustomAdapter(response.body(), MainActivity.this);
                    gridView.setAdapter(customAdapter);

                    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            Intent intent=new Intent();



                            startActivity(new Intent(getApplicationContext(), ItemDataActivity.class)
                                    .putExtra("name",nasaList.get(position).getTitle())
                                    .putExtra("image",nasaList.get(position).getUrl())
                                    .putExtra("cr",nasaList.get(position).getCopyright())
                                    .putExtra("exp",nasaList.get(position).getExplanation())
                                    .putExtra("date",nasaList.get(position).getDate())
                                    .putExtra("url",nasaList.get(position).getUrl())
                                    .putExtra("hdurl",nasaList.get(position).getHdurl())
                                    .putExtra("version",nasaList.get(position).getService_version())
                                    .putExtra("media",nasaList.get(position).getMedia_type())

                            );

                        }
                    });
                }
                else {
                    Toast.makeText(getApplicationContext(),"An error occured",Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onFailure(Call<List<Nasa>> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"An error occured"+ t.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        });




    }


    public class CustomAdapter extends BaseAdapter{

        public List<Nasa> nasaList;
        public Context context;

        public CustomAdapter(List<Nasa> nasaList, Context context) {
            this.nasaList = nasaList;
            this.context = context;
        }

        @Override
        public int getCount() {
            return nasaList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view= LayoutInflater.from(context).inflate(R.layout.row_data,null);

            TextView name=view.findViewById(R.id.textView);
            ImageView image=view.findViewById(R.id.imageView);


            name.setText(nasaList.get(position).getTitle());

            Glide.with(context)
                    .load(nasaList.get(position).getHdurl())
                    .into(image);



            return view;
        }
    }


}

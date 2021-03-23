package com.example.testca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class shop extends AppCompatActivity {
    GridView g;
    int[] icons =
            {
                    R.drawable.s3, R.drawable.s3, R.drawable.s3, R.drawable.s3, R.drawable.s3,
                    R.drawable.s3, R.drawable.s3, R.drawable.s3,
                    R.drawable.s3,
            };

    String[] name = {"lower", "Hoodie", "Laptop", "Shoes", "Crocs", "Cycle", "Cap", "Phone ", "Jacket"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        g = (GridView) findViewById(R.id.gridview);
        CustomAdapter customAdapter = new CustomAdapter(name, icons, this);
        //  gridadapter obj = (new gridadapter(name, icons, this));
        g.setAdapter(customAdapter);
        g.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(shop.this, "Item added to the cart ", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public class CustomAdapter extends BaseAdapter {
        private   String[] name;
        private   int[] image;
        Context context;
        LayoutInflater layoutInflater;

        public CustomAdapter(String[] name, int[] image, Context context) {
            this.name = name;
            this.image = image;
            this.context = context;
            this.layoutInflater=(LayoutInflater)context.getSystemService((Context.LAYOUT_INFLATER_SERVICE));
        }




        @Override
        public int getCount() {
            return image.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup parent) {
            if(view==null)
            {
                view=layoutInflater.inflate(R.layout.root , parent,false);
            }
            TextView textView=view.findViewById(R.id.textView);
            ImageView imageView=view.findViewById(R.id.imageView);

            textView.setText(name[i]);
            imageView.setImageResource(image[i]);

            return  view;

        }

    }
}
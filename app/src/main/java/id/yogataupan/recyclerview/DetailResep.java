package id.yogataupan.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailResep extends AppCompatActivity {
    private ArrayList<Integer>mImageID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_resep);
        ActionBar toolbar = getSupportActionBar();
        toolbar.setDisplayHomeAsUpEnabled(true);
        addImageID();
        bindData();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void bindData() {
        int position;
        String judul;
        String s1[] = getResources().getStringArray(R.array.detail_resep);
        Intent intent = getIntent();
        judul = intent.getStringExtra(Intent.EXTRA_TEXT);
        position = intent.getIntExtra(MainActivity.POSITION, 0);
        TextView tv_judul =  (TextView) findViewById(R.id.judul);
        TextView tv_s1 =  (TextView) findViewById(R.id.detail);
        ImageView image=(ImageView) findViewById(R.id.gambar);
        tv_judul.setText(judul);
        tv_s1.setText(s1[position]);
        image.setImageResource(mImageID.get(position));
    }
    private void addImageID(){
        mImageID = new ArrayList<>();
        mImageID.add(R.drawable.nasitimbel);
        mImageID.add(R.drawable.nasiliwet);
        mImageID.add(R.drawable.karedok);
        mImageID.add(R.drawable.lotek);
        mImageID.add(R.drawable.pepes);
        mImageID.add(R.drawable.bakakak);
        mImageID.add(R.drawable.empal);
        mImageID.add(R.drawable.soto);
    }
}
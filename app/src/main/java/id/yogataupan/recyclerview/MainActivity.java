package id.yogataupan.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements OwnAdapter.ResepListener {

    public static final String POSITION = "position";
    RecyclerView r1;
    OwnAdapter ad;
    int imageResource[] = {R.drawable.nasitimbel, R.drawable.nasiliwet, R.drawable.karedok, R.drawable.lotek, R.drawable.pepes, R.drawable.bakakak, R.drawable.empal, R.drawable.soto};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r1 = (RecyclerView) findViewById(R.id.rc);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        r1.setLayoutManager(layoutManager);
        r1.setHasFixedSize(true);
        String s1[] = getResources().getStringArray(R.array.nama_resep);
        Log.v("Main",s1[0]);
        String s2[] = getResources().getStringArray(R.array.deskripsi);

        ad = new OwnAdapter(this, s1, s2,imageResource, this);

        r1.setAdapter(ad);
        r1.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onClick(int position) {
        Intent intent = new Intent(this,DetailResep.class);
        intent.putExtra(Intent.EXTRA_TEXT,ad.getData1(position));
        intent.putExtra(POSITION,position);
        startActivity(intent);
    }
}
package id.yogataupan.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by yogataupan on 30/09/2017.
 */

public class OwnAdapter extends RecyclerView.Adapter<OwnAdapter.OwnHolder> {

    private String data1[];
    private  String data2[];
    private ResepListener mListener;
    int img[];
    Context ctx;


    public OwnAdapter(Context ct,String s1[], String s2[],int i1[],ResepListener listener){
        ctx=ct;
        data1 = s1;
        data2 = s2;
        img = i1;
        mListener = listener;
    }

    interface ResepListener{
        void onClick(int position);
    }

    @Override
    public OwnHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ctx = parent.getContext();
        View OwnView = LayoutInflater.from(ctx).inflate(R.layout.my_row,parent,false);
        return new OwnHolder(OwnView);
    }

    @Override
    public void onBindViewHolder(OwnHolder holder, int position) {
        RecyclerView.LayoutParams  params = (RecyclerView.LayoutParams) holder.mItemView.getLayoutParams();
        if(position == 0){
            params.topMargin = params.bottomMargin;
        }
        else{
            params.topMargin = 0;
        }
        String s1 = data1[position];
        String s2 = data2[position];
        holder.setResep(s1,s2);
        holder.myimage.setImageResource(img[position]);
    }

    @Override
    public int getItemCount() {

        return data1.length;
    }
    public String getData1 (int position) {
        return data1[position];
    }

    public class OwnHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private  TextView t1;
        private TextView t2;
        ImageView myimage;
        private View mItemView;

        public OwnHolder(View itemView) {
            super(itemView);
            t1 = (TextView) itemView.findViewById(R.id.text1);
            t2 = (TextView) itemView.findViewById(R.id.text2);
            myimage = (ImageView) itemView.findViewById(R.id.myimage);
            mItemView = itemView;
            mItemView.setOnClickListener(this);
        }

        public void setResep(String judul, String deskr){
            t1.setText(judul);
            t2.setText(deskr);
        }
        @Override
        public void onClick(View v) {
            mListener.onClick(getAdapterPosition());
        }
    }
}

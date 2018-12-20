package guopuran.bwie.com.space15.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import guopuran.bwie.com.space15.R;
import guopuran.bwie.com.space15.bean.LeftBean;

public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.ViewHolder> {
    private List<LeftBean.DataBean> list;
    private Context context;

    public LeftAdapter(Context context) {
        this.context = context;
        //初始化
        list=new ArrayList<>();
    }

    public void setList(List<LeftBean.DataBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }
    public LeftBean.DataBean getitem(int position){
        return list.get(position);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_left, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.getdata(getitem(i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.left_name);
        }

        public void getdata(final LeftBean.DataBean getitem) {
            name.setText(getitem.getName());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    monClick.click(getitem.getCid());
                }
            });
        }
    }
    public onClick monClick;
    public void setonclick(onClick monClick){
        this.monClick=monClick;
    }
    public interface onClick{
        void click(int cid);
    }
}

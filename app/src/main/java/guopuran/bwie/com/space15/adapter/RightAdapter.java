package guopuran.bwie.com.space15.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import guopuran.bwie.com.space15.R;
import guopuran.bwie.com.space15.bean.RightBean;

public class RightAdapter extends RecyclerView.Adapter<RightAdapter.ViewHolder> {
    private List<RightBean.DataBean> list;
    private Context context;

    public RightAdapter(Context context) {
        this.context = context;
        //初始化
        list=new ArrayList<>();
    }

    public void setList(List<RightBean.DataBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }
    public RightBean.DataBean getitem(int position){
        return list.get(position);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_right, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.getdata(getitem(i),context);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private RecyclerView recyclerView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.right_text);
            recyclerView=itemView.findViewById(R.id.right_recy);

        }

        public void getdata(RightBean.DataBean getitem, Context context) {
            textView.setText(getitem.getName());
            initView(getitem);
        }
        private void initView(RightBean.DataBean getitem) {
            GridLayoutManager gridLayoutManager=new GridLayoutManager(context,2);
            gridLayoutManager.setOrientation(OrientationHelper.VERTICAL);
            recyclerView.setLayoutManager(gridLayoutManager);
            ZiAdapter ziAdapter=new ZiAdapter(context);
            recyclerView.setAdapter(ziAdapter);
            ziAdapter.setList(getitem.getList());
        }
    }
}

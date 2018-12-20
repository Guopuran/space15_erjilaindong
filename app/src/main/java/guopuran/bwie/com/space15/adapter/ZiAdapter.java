package guopuran.bwie.com.space15.adapter;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import guopuran.bwie.com.space15.R;
import guopuran.bwie.com.space15.bean.RightBean;

public class ZiAdapter extends RecyclerView.Adapter<ZiAdapter.ViewHolder> {
    private List<RightBean.DataBean.ListBean> list;
    private Context context;

    public ZiAdapter(Context context) {
        this.context = context;
        //初始化
        list=new ArrayList<>();
    }

    public void setList(List<RightBean.DataBean.ListBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }
    public RightBean.DataBean.ListBean getitem(int position){
        return list.get(position);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.right_zi, viewGroup, false);
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
        private ImageView imageView;
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.zi_image);
            textView=itemView.findViewById(R.id.zi_text);
        }

        public void getdata(RightBean.DataBean.ListBean getitem, Context context) {
            Glide.with(context).load(getitem.getIcon()).into(imageView);
            textView.setText(getitem.getName());
        }
    }
}

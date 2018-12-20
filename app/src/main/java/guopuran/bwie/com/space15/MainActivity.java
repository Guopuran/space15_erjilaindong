package guopuran.bwie.com.space15;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

import guopuran.bwie.com.space15.adapter.LeftAdapter;
import guopuran.bwie.com.space15.adapter.RightAdapter;
import guopuran.bwie.com.space15.bean.LeftBean;
import guopuran.bwie.com.space15.bean.RightBean;
import guopuran.bwie.com.space15.presenter.IpresenterImpl;
import guopuran.bwie.com.space15.view.IView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,IView {

    private IpresenterImpl mIpresenterImpl;
    private RecyclerView recy_left;
    private RecyclerView recy_right;
    private LeftAdapter leftAdapter;
    private RightAdapter rightAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPresenter();
        initLeftView();
        initRightView();
    }
    private void initLeftView() {
                    //获取资源ID
                    recy_left = findViewById(R.id.main_recy_left);
                    //布局管理器
                    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
                    linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
                    recy_left.setLayoutManager(linearLayoutManager);
                    recy_left.addItemDecoration(new DividerItemDecoration(this,OrientationHelper.VERTICAL));
                    initLeftUrl();
                    //设置适配器
                    leftAdapter = new LeftAdapter(this);
                    recy_left.setAdapter(leftAdapter);
                    leftAdapter.setonclick(new LeftAdapter.onClick() {
                        @Override
                        public void click(int cid) {
                            initRightUrl(cid);
                    }
        });
    }
    private void initRightUrl(int cid) {
        Map<String, String> params=new HashMap<>();
        params.put("cid",String.valueOf(cid));
        mIpresenterImpl.requestter(Apis.URL_RIGHT,params,RightBean.class);
    }
    private void initLeftUrl() {
        mIpresenterImpl.requestter(Apis.URL_LEFT,new HashMap<String, String>(),LeftBean.class);
    }

    private void initRightView() {
        //获取资源ID
        recy_right = findViewById(R.id.main_recy_right);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        recy_right.setLayoutManager(linearLayoutManager);
        rightAdapter = new RightAdapter(this);
        recy_right.setAdapter(rightAdapter);
    }

    //互绑
    private void initPresenter() {
        mIpresenterImpl=new IpresenterImpl(this);
    }

    //解绑
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mIpresenterImpl.Deatch();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void getdata(Object object) {
        if (object instanceof LeftBean){
            LeftBean leftBean= (LeftBean) object;
            leftAdapter.setList(leftBean.getData());
        }
        if (object instanceof RightBean){
            RightBean rightBean= (RightBean) object;
            rightAdapter.setList(rightBean.getData());
        }
    }
}

package guopuran.bwie.com.space15.Imodel;

import java.util.Map;

import guopuran.bwie.com.space15.util.MyCallBack;

public interface Imodel {
    void requestmodel(String url, Map<String,String> params, Class clazz, MyCallBack callBack);
}

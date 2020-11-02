package com.jtl.longlive;

/**
 * @author：TianLong
 * @date：2020/10/30 19:18
 */
public class LiveData {
    public String name ="";
    public String url = "";

    public LiveData(String name, String url) {
        this.name = name;
        this.url = url;
    }

    @Override
    public String toString() {
        return "LiveData{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}

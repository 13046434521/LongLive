package com.jtl.longlive;

import android.util.Log;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    private String msg ="CCTV-1综合：rtmp://58.200.131.2:1935/livetv/cctv1,\n" +
            "CCTV-2财经：rtmp://58.200.131.2:1935/livetv/cctv2,\n" +
            "CCTV-3综艺：rtmp://58.200.131.2:1935/livetv/cctv3,\n" +
            "CCTV-4中文国际：rtmp://58.200.131.2:1935/livetv/cctv4,\n" +
            "CCTV-5体育：rtmp://58.200.131.2:1935/livetv/cctv5,\n" +
            "CCTV-6电影：rtmp://58.200.131.2:1935/livetv/cctv6,\n" +
            "CCTV-7军事农业：rtmp://58.200.131.2:1935/livetv/cctv7,\n" +
            "CCTV-8电视剧：rtmp://58.200.131.2:1935/livetv/cctv8,\n" +
            "CCTV-9记录：rtmp://58.200.131.2:1935/livetv/cctv9,\n" +
            "CCTV-10科教：rtmp://58.200.131.2:1935/livetv/cctv10,\n" +
            "CCTV-11戏曲：rtmp://58.200.131.2:1935/livetv/cctv11,\n" +
            "CCTV-12社会与法：rtmp://58.200.131.2:1935/livetv/cctv12,\n" +
            "CCTV-13新闻：rtmp://58.200.131.2:1935/livetv/cctv13,\n" +
            "CCTV-14少儿：rtmp://58.200.131.2:1935/livetv/cctv14,\n" +
            "CCTV-15音乐：rtmp://58.200.131.2:1935/livetv/cctv15,\n" +
            "安徽卫视：rtmp://58.200.131.2:1935/livetv/ahtv,\n" +
            "兵团卫视：rtmp://58.200.131.2:1935/livetv/bttv,\n" +
            "重庆卫视：rtmp://58.200.131.2:1935/livetv/cqtv,\n" +
            "东方卫视：rtmp://58.200.131.2:1935/livetv/dftv,\n" +
            "东南卫视：rtmp://58.200.131.2:1935/livetv/dntv,\n" +
            "广东卫视：rtmp://58.200.131.2:1935/livetv/gdtv,\n" +
            "广西卫视：rtmp://58.200.131.2:1935/livetv/gxtv,\n" +
            "甘肃卫视：rtmp://58.200.131.2:1935/livetv/gstv,\n" +
            "贵州卫视：rtmp://58.200.131.2:1935/livetv/gztv,\n" +
            "湖北卫视：rtmp://58.200.131.2:1935/livetv/hbtv,\n" +
            "湖南卫视：rtmp://58.200.131.2:1935/livetv/hunantv,\n" +
            "河北卫视：rtmp://58.200.131.2:1935/livetv/hebtv,\n" +
            "河南卫视：rtmp://58.200.131.2:1935/livetv/hntv,\n" +
            "黑龙江卫视：rtmp://58.200.131.2:1935/livetv/hljtv,\n" +
            "江苏卫视：rtmp://58.200.131.2:1935/livetv/jstv,\n" +
            "江西卫视：rtmp://58.200.131.2:1935/livetv/jxtv,\n" +
            "吉林卫视：rtmp://58.200.131.2:1935/livetv/jltv,\n" +
            "辽宁卫视：rtmp://58.200.131.2:1935/livetv/lntv,\n" +
            "内蒙古卫视：rtmp://58.200.131.2:1935/livetv/nmtv,\n" +
            "宁夏卫视：rtmp://58.200.131.2:1935/livetv/nxtv,\n" +
            "青海卫视：rtmp://58.200.131.2:1935/livetv/qhtv,\n" +
            "四川卫视：rtmp://58.200.131.2:1935/livetv/sctv,\n" +
            "山东卫视：rtmp://58.200.131.2:1935/livetv/sdtv,\n" +
            "山西卫视：rtmp://58.200.131.2:1935/livetv/sxrtv,\n" +
            "陕西卫视：rtmp://58.200.131.2:1935/livetv/sxtv,\n" +
            "山东教育：rtmp://58.200.131.2:1935/livetv/sdetv,\n" +
            "中国教育-1：rtmp://58.200.131.2:1935/livetv/cetv1,\n" +
            "中国教育-3：rtmp://58.200.131.2:1935/livetv/cetv3,\n" +
            "中国教育-4：rtmp://58.200.131.2:1935/livetv/cetv4,\n" +
            "CCTV-第一剧场：rtmp://58.200.131.2:1935/livetv/dyjctv,\n" +
            "CCTV-国防军事：rtmp://58.200.131.2:1935/livetv/gfjstv,\n" +
            "CCTV-怀旧剧场：rtmp://58.200.131.2:1935/livetv/hjjctv,\n" +
            "CCTV-风云剧场：rtmp://58.200.131.2:1935/livetv/fyjctv,\n" +
            "CCTV-风云足球：rtmp://58.200.131.2:1935/livetv/fyzqtv,\n" +
            "CCTV-风云音乐：rtmp://58.200.131.2:1935/livetv/fyyytv,\n" +
            "CCTV-世界地理：rtmp://58.200.131.2:1935/livetv/sjdltv,\n" +
            "CCTV-1HD：rtmp://58.200.131.2:1935/livetv/cctv1hd,\n" +
            "CCTV-2HD：rtmp://58.200.131.2:1935/livetv/cctv2hd,\n" +
            "CCTV-3HD：rtmp://58.200.131.2:1935/livetv/cctv3hd,\n" +
            "CCTV-4HD：rtmp://58.200.131.2:1935/livetv/cctv4hd,\n" +
            "CCTV-5HD：rtmp://58.200.131.2:1935/livetv/cctv5hd,\n" +
            "CCTV5+HD：rtmp://58.200.131.2:1935/livetv/cctv5phd,\n" +
            "CCTV-6HD：rtmp://58.200.131.2:1935/livetv/cctv6hd,\n" +
            "CCTV-7HD：rtmp://58.200.131.2:1935/livetv/cctv7hd,\n" +
            "CCTV-8HD：rtmp://58.200.131.2:1935/livetv/cctv8hd,\n" +
            "CCTV-9HD：rtmp://58.200.131.2:1935/livetv/cctv9hd,\n" +
            "CCTV-10HD：rtmp://58.200.131.2:1935/livetv/cctv10hd,\n" +
            "CCTV-12HD：rtmp://58.200.131.2:1935/livetv/cctv12hd,\n" +
            "CCTV-14HD：rtmp://58.200.131.2:1935/livetv/cctv14hd,\n" +
            "CGTN-新闻：rtmp://58.200.131.2:1935/livetv/cctv16,\n" +
            "CETV-1：rtmp://58.200.131.2:1935/livetv/cetv1,\n" +
            "CETV-3：rtmp://58.200.131.2:1935/livetv/cetv3,\n" +
            "CETV-4：rtmp://58.200.131.2:1935/livetv/cetv4,\n" +
            "北京卫视高清：rtmp://58.200.131.2:1935/livetv/btv1hd,\n" +
            "北京影视高清：rtmp://58.200.131.2:1935/livetv/btv4hd,\n" +
            "北京体育高清：rtmp://58.200.131.2:1935/livetv/btv6hd,\n" +
            "北京新闻高清：rtmp://58.200.131.2:1935/livetv/btv9hd,\n" +
            "北京纪实高清：rtmp://58.200.131.2:1935/livetv/btv11hd,\n" +
            "北京卫视：rtmp://58.200.131.2:1935/livetv/btv1,\n" +
            "北京文艺：rtmp://58.200.131.2:1935/livetv/btv2,\n" +
            "北京科教：rtmp://58.200.131.2:1935/livetv/btv3,\n" +
            "北京影视：rtmp://58.200.131.2:1935/livetv/btv4,\n" +
            "北京财经：rtmp://58.200.131.2:1935/livetv/btv5,\n" +
            "北京体育：rtmp://58.200.131.2:1935/livetv/btv6,\n" +
            "北京生活：rtmp://58.200.131.2:1935/livetv/btv7,\n" +
            "北京青年：rtmp://58.200.131.2:1935/livetv/btv8,\n" +
            "北京新闻：rtmp://58.200.131.2:1935/livetv/btv9,\n" +
            "北京卡酷：rtmp://58.200.131.2:1935/livetv/btv10,\n" +
            "北京文艺高清：rtmp://58.200.131.2:1935/livetv/btv2hd,\n" +
            "安徽卫视高清：rtmp://58.200.131.2:1935/livetv/ahhd,\n" +
            "重庆卫视高清：rtmp://58.200.131.2:1935/livetv/cqhd,\n" +
            "东方卫视高清：rtmp://58.200.131.2:1935/livetv/dfhd,\n" +
            "天津卫视高清：rtmp://58.200.131.2:1935/livetv/tjhd,\n" +
            "东南卫视高清：rtmp://58.200.131.2:1935/livetv/dnhd,\n" +
            "江西卫视高清：rtmp://58.200.131.2:1935/livetv/jxhd,\n" +
            "河北卫视高清：rtmp://58.200.131.2:1935/livetv/hebhd,\n" +
            "湖南卫视高清：rtmp://58.200.131.2:1935/livetv/hunanhd,\n" +
            "湖北卫视高清：rtmp://58.200.131.2:1935/livetv/hbhd,\n" +
            "辽宁卫视高清：rtmp://58.200.131.2:1935/livetv/lnhd,\n" +
            "四川卫视高清：rtmp://58.200.131.2:1935/livetv/schd,\n" +
            "江苏卫视高清：rtmp://58.200.131.2:1935/livetv/jshd,\n" +
            "浙江卫视高清：rtmp://58.200.131.2:1935/livetv/zjhd,\n" +
            "山东卫视高清：rtmp://58.200.131.2:1935/livetv/sdhd,\n" +
            "广东卫视高清：rtmp://58.200.131.2:1935/livetv/gdhd,\n" +
            "深圳卫视高清：rtmp://58.200.131.2:1935/livetv/szhd,\n" +
            "黑龙江卫视高清：rtmp://58.200.131.2:1935/livetv/hljhd,\n" +
            "CHC高清电影：rtmp://58.200.131.2:1935/livetv/chchd,\n" +
            "上海纪实高清：rtmp://58.200.131.2:1935/livetv/docuchina,\n" +
            "金鹰纪实高清：rtmp://58.200.131.2:1935/livetv/gedocu,\n" +
            "全纪实高清：rtmp://58.200.131.2:1935/livetv/documentaryhd,\n" +
            "凤凰卫视中文台：rtmp://58.200.131.2:1935/livetv/fhzw,\n" +
            "凤凰卫视资讯台：rtmp://58.200.131.2:1935/livetv/fhzx,\n" +
            "凤凰卫视电影台：rtmp://58.200.131.2:1935/livetv/fhdy,\n" +
            "星空卫视：rtmp://58.200.131.2:1935/livetv/startv,\n" +
            "Star Sports：rtmp://58.200.131.2:1935/livetv/starsports,\n" +
            "Channel[V]：rtmp://58.200.131.2:1935/livetv/channelv,\n" +
            "探索频道：rtmp://58.200.131.2:1935/livetv/discovery,\n" +
            "国家地理频道：rtmp://58.200.131.2:1935/livetv/natlgeo,\n" +
            "CHC家庭影院：rtmp://58.200.131.2:1935/livetv/chctv,\n" +
            "CHC动作电影：rtmp://58.200.131.2:1935/livetv/chcatv,\n" +
            "美国电视频道：rtmp://media3.scctv.net/live/scctv_800,\n" +
            "香港财经：rtmp://202.69.69.180：443/webcast/bshdlive-pc";

    @Test
    public void initList(){
        String list = msg;
        ArrayList arrayList = new ArrayList<String>(16);

        String [] result = list.split("：");
        for (String res :result){
            System.out.println(res+"\n");
        }
    }
}
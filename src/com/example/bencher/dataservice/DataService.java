package com.example.bencher.dataservice;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.widget.Toast;

import com.example.bencher.entity.HomePage;
import com.example.bencher.https.HttpUtils;
import com.example.bencher.json.Json;

public class DataService {
	private Context context;
	public DataService(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	public  List<HomePage> getHomeData(int offset, int maxResult){
		//����List
		List<HomePage> data = new ArrayList<HomePage>();
//		
//	    String stringjson = HttpUtils.postByHttpClient(context, strUrl, nameValuePairs);
//		data = Json.///////
//		��������
//		 data;
		for(int k=offset;k<maxResult;k++){
			HomePage h = new HomePage("����", "��ӭʵϰ", "123");
			data.add(h);
		}
		//Toast.makeText(context, "��������", Toast.LENGTH_LONG).show();
		return data;
	}
}

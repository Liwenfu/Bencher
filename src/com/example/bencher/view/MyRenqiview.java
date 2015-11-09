package com.example.bencher.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.example.bencher.city.FocusCity;
import com.example.bencher.ui.R;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class MyRenqiview {

	private Context context;
	private View myview;
	private ListView listview;
	Button location_btn;
	List<Map<String, Object>> mylist = new ArrayList<Map<String,Object>>();
	public MyRenqiview(Context context){
		this.context  = context;
		init();
		addValues();
		SetAdapter();
	}
	
	private void init() {
		// TODO Auto-generated method stub
		myview = View.inflate(context, R.layout.renqi_view, null);
		listview = (ListView) myview.findViewById(R.id.newslist);
		location_btn = (Button) myview.findViewById(R.id.home_location_button);
		location_btn.setText(FocusCity.CurrentCity);
		
		location_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	

	public void addValues(){
		for(int i = 0;i<5;i++){
			 Map<String,Object> map = new HashMap<String, Object>();
			 map.put("bigtitle", "豪嘉基");
			 map.put("littletitle", "赶紧来吃东西");
			 map.put("picture",R.drawable.ad );
			 mylist.add(map);
		}
	}
	
		
		public void SetAdapter(){
			SimpleAdapter simpleAdapter_1 = new SimpleAdapter(context,mylist,
				    R.layout.firstactivity_view1_listview_item,
				    new String[]{"bigtitle", "littletitle","picture"},
				    new int[]{R.id.myhome_bigtitle, R.id.myhomge_litttletitle,R.id.myhome_imageview});
			
			listview.setAdapter(simpleAdapter_1);
		
	
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				String url = "http://218.200.69.66:8302/upload/Media/20150327/43bfda1b-7280-469c-a83b-82fa311c79d7.m4v";
				new VideoPlayAsyncTask().execute(url);
			}
		});
		listview.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(context, "已经关注，你可以去我的关注中查看", Toast.LENGTH_LONG).show();
				return true;
			}
			
		});
			
	}
		
		public View getView(){
			return this.myview;
		}

		class VideoPlayAsyncTask extends AsyncTask<String, Void, Void>{

			@Override
			protected Void doInBackground(String... arg0) {
				// TODO Auto-generated method stub
				Uri uri = Uri.parse(arg0[0]);
                // 调用系统自带的播放器来播放流媒体视频
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Log.v("URI:::::::::", uri.toString());
                intent.setDataAndType(uri, "video/mp4");
                context.startActivity(intent);
				return null;
			}
			
		}
}


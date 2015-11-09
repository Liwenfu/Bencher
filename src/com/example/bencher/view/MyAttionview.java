package com.example.bencher.view;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.bencher.adapter.MyFoucsAdapter;
import com.example.bencher.entity.HomePage;
import com.example.bencher.ui.R;

public class MyAttionview {
	private Context context;
	private View myview;
	private ListView listview;
	List<HomePage> businfo = new ArrayList<HomePage>();
	public MyAttionview(Context context){
		this.context  = context;
		myview = View.inflate(context, R.layout.myattention, null);
		listview = (ListView) myview.findViewById(R.id.myattion_list);
		addValues();
		SetAdapter();
		listview.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
			}
		});
	}
	
public void addValues(){
		
		for(int k=0;k<6;k++){
			HomePage h = new HomePage("华侨大学", "欢迎2016级鲜肉", "imageurl");
			businfo.add(h);
		}
	
	}
		
		public void SetAdapter(){
			
		MyFoucsAdapter adapter = new MyFoucsAdapter(businfo, context, R.layout.myattention_listitem, null);
		listview.setAdapter(adapter);
	
	}
		
		public View getView(){
			return this.myview;
		}
}

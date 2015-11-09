package com.example.bencher.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.example.bencher.ui.R;
import com.example.bencher.ui.UserLoginUidActivity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MyPageview implements OnClickListener{

	private Context context;
	private View myview;
	private ListView listview;
	List<Map<String, Object>> mylist = new ArrayList<Map<String,Object>>();
	TextView mypage_image_btn_all,mypage_image_btn_asmoney,mypage_image_btn_gift,mypage_image_btn_money;
	ImageView imageview_userpicture;
	public MyPageview(Context context){
		this.context  = context;
		init();
		addValues();
		SetAdapter();
	}
	
	public void init(){
		myview = View.inflate(context, R.layout.mypage, null);
		listview = (ListView) myview.findViewById(R.id.mypage_listview);
		
		mypage_image_btn_all = (TextView) myview.findViewById(R.id.mypage_image_btn_all);
		mypage_image_btn_all.setOnClickListener(this);
		mypage_image_btn_asmoney = (TextView) myview.findViewById(R.id.mypage_image_btn_asmoney);
		mypage_image_btn_asmoney.setOnClickListener(this);
		mypage_image_btn_gift = (TextView) myview.findViewById(R.id.mypage_image_btn_gift);
		mypage_image_btn_gift.setOnClickListener(this);
		mypage_image_btn_money = (TextView) myview.findViewById(R.id.mypage_image_btn_money);
		mypage_image_btn_money.setOnClickListener(this);
		
		imageview_userpicture = (ImageView) myview.findViewById(R.id.imageView1);
		imageview_userpicture.setOnClickListener(this);
	}
	public void addValues(){
		for(int i = 0;i<5;i++){
			 Map<String,Object> map = new HashMap<String, Object>();
			 map.put("bigtitle", "大标题");
			 map.put("littletitle", "中标题");
			 map.put("third","小标题" );
			 mylist.add(map);
		}
	}
		
		public void SetAdapter(){
			SimpleAdapter simpleAdapter_1 = new SimpleAdapter(context,mylist,
				    R.layout.mypage_all,
				    new String[]{"bigtitle", "littletitle","third"},
				    new int[]{R.id.mypage_textViewfirst, R.id.mypage_textViewsecond,R.id.mypage_textViewthird});
			
			listview.setAdapter(simpleAdapter_1);
	
			}
		
		public View getView(){
			return this.myview;
		}

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			 switch(arg0.getId()){  
		        case R.id.mypage_image_btn_all:  
		        	//加载所有
		        	Toast.makeText(context, "你点击了分类", Toast.LENGTH_SHORT).show();
		            break;  
		        case R.id.mypage_image_btn_asmoney:  
		        	//
		        	Toast.makeText(context, "你点击了分类", Toast.LENGTH_SHORT).show();
		            break;  
		        case R.id.mypage_image_btn_gift:  
		        	Toast.makeText(context, "你点击了分类", Toast.LENGTH_SHORT).show();
		            break;  
		        case R.id.mypage_image_btn_money:  
		        	Toast.makeText(context, "你点击了分类", Toast.LENGTH_SHORT).show();
		            break;  
		        case R.id.imageView1:
		        	Intent intent = new Intent(context, UserLoginUidActivity.class);
					context.startActivity(intent);
		        	break;
		}
	}
}

package com.example.bencher.ui;

import java.util.ArrayList;
import java.util.List;
import com.example.bencher.adapter.MyPagerAdapter;
import com.example.bencher.city.FocusCity;
import com.example.bencher.view.MyAttionview;
import com.example.bencher.view.MyPageview;
import com.example.bencher.view.MyRenqiview;
import com.example.bencher.view.Myhomeview;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class EveryActivity extends Activity implements OnClickListener{

	ViewPager viewpager;
	List<View> viewList = new ArrayList<View>();
	private ArrayList<View> dots;
	private MyPagerAdapter pageradapter;
	View dot_main,dot_renqi,dot_focus,dot_me,dot_more;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.every_activity);
		init();
		addView();
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		Button btn = (Button) viewList.get(0).findViewById(R.id.home_location_button);
		btn.setText(FocusCity.CurrentCity);
	}

	public void init(){
		//加载下滑显示图标
		dots = new ArrayList<View>();
		dots.add(findViewById(R.id.dot_mainview));
		dots.add(findViewById(R.id.dot_renqi));
		dots.add(findViewById(R.id.dot_like));
		dots.add(findViewById(R.id.dot_me));
		dots.add(findViewById(R.id.dot_more));
		
		
		viewpager  = (ViewPager) findViewById(R.id.viewpager);
		 pageradapter = new MyPagerAdapter(viewList);
		 viewpager.setAdapter(pageradapter);
		 
		 dot_main = findViewById(R.id.dot_mainview);
		 dot_main.setOnClickListener(this);
		 dot_renqi = findViewById(R.id.dot_renqi);
		 dot_renqi.setOnClickListener(this);
		 dot_focus = findViewById(R.id.dot_like);
		 dot_focus.setOnClickListener(this);
		 dot_me = findViewById(R.id.dot_me);
		 dot_me.setOnClickListener(this);
		 dot_more = findViewById(R.id.dot_more);
		 dot_more.setOnClickListener(this);
	}
	
		
	
	public void addView(){
			  
			  Myhomeview view = new Myhomeview(this);
			  viewList.add(view.getView());
			  MyRenqiview renqiview = new MyRenqiview(this);
			  viewList.add(renqiview.getView());
			  MyAttionview attionview = new MyAttionview(this);
			  viewList.add(attionview.getView());
			  MyPageview pageview = new MyPageview(this);
			  viewList.add(pageview.getView());
			  MyPageview more = new MyPageview(this);
			  viewList.add(more.getView());
			  
			 viewpager.setOnPageChangeListener(listener);
			  
			 
	}
	private ViewPager.OnPageChangeListener listener = new OnPageChangeListener() {
		
		@Override
		public void onPageSelected(int arg0) {
			// TODO Auto-generated method stub
			if(arg0!=1||arg0!=2||arg0!=3||arg0!=4){
				dots.get(0).setBackgroundResource(R.drawable.home_selected);
			}else
			{
				dots.get(0).setBackgroundResource(R.drawable.home);
			}
			switch(arg0){
			case 0:
				initdotView();
				dots.get(arg0)
				.setBackgroundResource(R.drawable.home_selected);
			break;
			case 1:
				initdotView();
				dots.get(arg0)
				.setBackgroundResource(R.drawable.hot_selected);
				break;
			case 2:
				initdotView();
				dots.get(arg0)
				.setBackgroundResource(R.drawable.like_selected);
				break;
			case 3:
				initdotView();
				dots.get(arg0)
				.setBackgroundResource(R.drawable.me_selected);
				break;
			case 4:
				initdotView();
				dots.get(arg0)
				.setBackgroundResource(R.drawable.more_selected);
				break;
			}
		}
		
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
		}
		
		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
		}
	};
	
	public void initdotView(){
		dots.get(0)
		.setBackgroundResource(R.drawable.home);
		dots.get(1)
		.setBackgroundResource(R.drawable.hot);
		dots.get(2)
		.setBackgroundResource(R.drawable.like);
		dots.get(3)
		.setBackgroundResource(R.drawable.me);
		dots.get(4)
		.setBackgroundResource(R.drawable.more);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
			case R.id.dot_mainview:
				viewpager.setCurrentItem(0);
				break;
			case R.id.dot_renqi:
				viewpager.setCurrentItem(1);
				break;
			case R.id.dot_like:
				viewpager.setCurrentItem(2);
				break;
			case R.id.dot_me:
				viewpager.setCurrentItem(3);
				break;
			case R.id.dot_more:
				viewpager.setCurrentItem(4);
				break;
				
			
		}
	}
}

package com.example.bencher.ui;



import com.example.bencher.json.Json;
import com.example.bencher.utils.IntentUtil;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button registerbtn,loginbutton,pagerbutton,jsonbtn;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		init();
		//AddPager();
	}
	public void init(){
		jsonbtn = (Button) findViewById(R.id.json);
		jsonbtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			Json j = new Json(MainActivity.this);
			try {
				j.fromJsons();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		});

		pagerbutton = (Button) findViewById(R.id.viewpagerlist);
		pagerbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				IntentUtil.start_activity(MainActivity.this, EveryActivity.class);
			}
		});
		
		registerbtn = (Button) findViewById(R.id.registerbutton);
		loginbutton = (Button) findViewById(R.id.btnlogin);
		loginbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				IntentUtil.start_activity(MainActivity.this, UserLoginUidActivity.class);
			}
		});
		registerbtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				IntentUtil.start_activity(MainActivity.this, UserRegisterActivity.class);
			}
		});
	}
	

}

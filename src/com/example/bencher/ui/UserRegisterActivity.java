package com.example.bencher.ui;


import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.example.bencher.configs.Urls;
import com.example.bencher.https.HttpUtils;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserRegisterActivity extends Activity implements OnClickListener{

	private EditText phoneText,pwdText,makesurpwdText;
	Button registerBtn,register_register_btn_cancle,register_maksure_btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.register);
		initView();
	}

	public void initView(){
		phoneText = (EditText) findViewById(R.id.phoneText);
		pwdText = (EditText) findViewById(R.id.pwdText);
		makesurpwdText = (EditText) findViewById(R.id.makesurpwdText);
		
		registerBtn = (Button) findViewById(R.id.registerBtn);
		registerBtn.setOnClickListener(this);
		register_register_btn_cancle = (Button) findViewById(R.id.register_register_btn_cancle);
		register_register_btn_cancle.setOnClickListener(this);
		register_maksure_btn = (Button) findViewById(R.id.register_maksure_btn);
		register_maksure_btn.setOnClickListener(this);
		
			
	
	}
	
	 class RegisterTasd extends AsyncTask<String, Void, String>{

		@Override
		protected String doInBackground(String... arg0) {
			// TODO Auto-generated method stub
			NameValuePair p1 = new BasicNameValuePair("userid",arg0[1]);
			NameValuePair p2 = new BasicNameValuePair("userpwd",arg0[2]);
			String result = HttpUtils.postByHttpClient(getApplication(), arg0[0], p1,p2);
			System.out.println(">>>>>>>>>>>"+result+"success!");
			return result;
		}

		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
		}
		 
	 }

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		
		case R.id.register_register_btn_cancle:
			this.finish();
			break;
		case R.id.registerBtn:
			new RegisterTasd().execute(Urls.USER_INFO,phoneText.getText().toString(),pwdText.getText().toString());
			break;
		case R.id.register_maksure_btn:
			Toast.makeText(this, "ÑéÖ¤Âë", Toast.LENGTH_SHORT).show();
		break;
		
		}
		
	}

}

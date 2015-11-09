 package com.example.bencher.ui;

import java.util.ArrayList;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;


import com.example.bencher.entity.testEntity2;
import com.example.bencher.https.HttpUtils;
import com.example.bencher.https.NetWorkHelper;
import com.example.bencher.json.JacksonMapper;
import com.example.bencher.ui.base.BaseActivity;
import com.example.bencher.utils.IntentUtil;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class UserLoginUidActivity extends BaseActivity implements
		OnClickListener {
	
	private EditText editUserID;
	private EditText editPwd;
	private Button btnEnter,btn_register,login_login_btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);
		initControl();
	}

	private void initControl() {
		editUserID = (EditText) findViewById(R.id.editext_user_name);
		editPwd = (EditText) findViewById(R.id.editext_user_pwd);
		
		btnEnter = (Button) findViewById(R.id.btn_login);
		btnEnter.setOnClickListener(this);
		btn_register = (Button) findViewById(R.id.btn_register);
		btn_register.setOnClickListener(this);
		login_login_btn = (Button) findViewById(R.id.login_login_btn);
		login_login_btn.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_login:
			checkUsername(editUserID.getText().toString(), editPwd.getText()
					.toString());
			break;
		case R.id.btn_register:
			Intent intent = new Intent(this,UserRegisterActivity.class);
			startActivity(intent);
		case R.id.login_login_btn:
			this.finish();
			break;
		default:
			break;
		}
	}

	private void checkUsername(String name, String pwd) {
		if (TextUtils.isEmpty(name)) {
			showShortToast(getResources().getString(R.string.user_username));
			return;
		} else if (TextUtils.isEmpty(pwd)) {
			showShortToast(getResources().getString(R.string.user_pwd));
			return;
		}else if (!NetWorkHelper.checkNetState(this)){
			showLongToast(getResources().getString(R.string.httpisNull));
			return ;
		}
		
		new LoginAsyncTask().execute("http://112.74.128.120/app/FlowPackage/getFlowPackageApi?mobile=18850041234&range=0");
		
	}

	class LoginAsyncTask extends AsyncTask<String, Void, String> {
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			showAlertDialog("温馨提示", "正在登录请稍等一下~");
		}

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			
			Log.d("Url", params[0]);
			String result = "";
			try {
				result = HttpUtils.postByHttpClient(
						UserLoginUidActivity.this, params[0]);
				//System.out.println(result);
				 Log.d("455", ">>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<");
				 ObjectMapper objectMapper = JacksonMapper.getmapper();
					JsonNode jsonNode = objectMapper.readTree(result);
					JsonNode codeNode = jsonNode.get("code");
					JsonNode msgNode = jsonNode.get("msg");
					JsonNode EntityNode = jsonNode.get("body");
					String EntityString = EntityNode.toString();
					@SuppressWarnings("unchecked")
					ArrayList<testEntity2> entity = objectMapper.readValue(EntityString, new ArrayList<testEntity2>().getClass());
					Log.d("455", "code=" + codeNode.asInt());
					Log.d("456", "msg=" + msgNode.asText());
					Log.d("9988", "entity=" + entity.toString());
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return null;
			}
			try {
				if (result!=null) {
					return result;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			mAlertDialog.dismiss();
			if (result!=null) {
				showLongToast("登录成功");
				IntentUtil.start_activity(UserLoginUidActivity.this, MainActivity.class);
				finish();
			} else {
				showLongToast(getResources().getString(
						R.string.user_login_error));
				editUserID.setText("");
				editPwd.setText("");
			}
		}

	}

}


package com.example.bencher.view;

import java.util.ArrayList;
import java.util.List;
import com.example.bencher.adapter.MyBaseAdapter;
import com.example.bencher.city.FocusCity;
import com.example.bencher.dataservice.DataService;
import com.example.bencher.entity.HomePage;
import com.example.bencher.ui.CityListActivity;
import com.example.bencher.ui.R;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Myhomeview {

	private final int needADDDATA = 0x1234;
	private Context context;
	private View myview;
	private ListView listview;
	Button location_btn;
	List<HomePage> businfo = new ArrayList<HomePage>();
	MyBaseAdapter adapter_item;
	private boolean loadfinish = true;//�����Ƿ���ɱ�־λ
	private int number = 5;//ÿҳ��ʾ5������
	private int maxPage = 5;//�ܹ���ʾ5ҳ����

	public Myhomeview(Context context){
		this.context  = context;
		init();
		addValues();
		SetAdapter();
	}
	
	private void init() {
		// TODO Auto-generated method stub
		myview = View.inflate(context, R.layout.firstactivity_view1_list, null);
		listview = (ListView) myview.findViewById(R.id.newslist);
		location_btn = (Button) myview.findViewById(R.id.home_location_button);
		location_btn.setText(FocusCity.CurrentCity);
		
		location_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, CityListActivity.class);
				context.startActivity(intent);
			}
		});
	}
	

	public void addValues(){//������������
		for(int k=0;k<5;k++){
			HomePage h = new HomePage("����", "��ӭʵϰ", "123");
			businfo.add(h);
		}
	}
		
		public void SetAdapter(){
			adapter_item = new MyBaseAdapter(businfo, context, R.layout.firstactivity_view1_listview_item, null);
			listview.setAdapter(adapter_item);
			listview.setOnScrollListener(new MyOnScrollListener());
			
			listview.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> arg0, View view,
						int position, long arg3) {//view �ǵ�ǰ��item��view
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
					Toast.makeText(context, "�Ѿ���ע�������ȥ�ҵĹ�ע�в鿴", Toast.LENGTH_LONG).show();
					return true;
				}
			});
	}
		
		public View getView(){
			return this.myview;
		}

		 Handler handler = new Handler(){
		    	public void handleMessage(Message msg){
		    		switch(msg.what){
		    		case needADDDATA:
		    			DataService mDataService = new DataService(context);
		    			List<HomePage> result = mDataService.getHomeData(0, 5);
		    			//�������
		    			businfo.addAll(result);
		    			adapter_item.notifyDataSetChanged();
		    			loadfinish = true;
		    			break;
		    		}
		    	}
		    };
		private final class MyOnScrollListener implements OnScrollListener{
			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				//���� ��ǰ�����ܿ����ĵ�һ�����±꣬��ǰҳ����ʾ�������ܹ�װ���˼���
				int lastItemid = listview.getLastVisiblePosition();
				if((lastItemid+1) == totalItemCount){
					if(totalItemCount > 0){
						int currentPage = (totalItemCount%number==0) ? (totalItemCount/number) : (totalItemCount/number + 1);
						int nextPage = currentPage + 1;
						if(nextPage<=maxPage && loadfinish){
							loadfinish = false;
				
				new Thread(new Runnable() {
					public void run() {
						try{
							Thread.sleep(3000);
						}catch(Exception e){
							e.printStackTrace();
						}
						//������Ϣ
						Message msg = new Message();
						msg.what = needADDDATA;
						handler.sendMessage(msg);
					}
				}).start();
						}
					}
				}
			}

			@Override
			public void onScrollStateChanged(AbsListView arg0, int arg1) {
				// TODO Auto-generated method stub
				
			}
			
		}
		
		class VideoPlayAsyncTask extends AsyncTask<String, Void, Void>{

			@Override
			protected Void doInBackground(String... arg0) {
				// TODO Auto-generated method stub
				Uri uri = Uri.parse(arg0[0]);
                // ����ϵͳ�Դ��Ĳ�������������ý����Ƶ
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Log.v("URI:::::::::", uri.toString());
                intent.setDataAndType(uri, "video/mp4");
                context.startActivity(intent);
				return null;
			}
			
		}
}


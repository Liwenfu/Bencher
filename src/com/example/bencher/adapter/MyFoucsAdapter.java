package com.example.bencher.adapter;

import java.util.List;
import com.example.bencher.entity.HomePage;
import com.example.bencher.ui.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MyFoucsAdapter extends BaseAdapter{

	private List<HomePage> bus;
	private int resource;
	private LayoutInflater inflater;
	private Context context;
	


	public MyFoucsAdapter(List<HomePage> bus, Context context, int resource,
	String user_qq) {
	this.bus = bus;
	this.resource = resource;
	this.context = context;
	inflater = (LayoutInflater) context
	.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
	return bus.size();
	}

	@Override
	public Object getItem(int position) {
	return bus.get(position);
	}

	@Override
	public long getItemId(int position) {
	return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
	if (convertView == null) {
	convertView = inflater.inflate(resource, null);
	}
	HomePage onebus = bus.get(position);
	ImageView logo= (ImageView) convertView.findViewById(R.id.myattion_logo);
	
	TextView largetxt =(TextView) convertView.findViewById(R.id.lage_text);
	TextView littletext = (TextView) convertView.findViewById(R.id.little_text);
	
	final ImageButton myattion_callme = (ImageButton) convertView.findViewById(R.id.myattion_callme);
	final ImageButton myattion_in = (ImageButton) convertView.findViewById(R.id.myattion_in);
	final ImageButton myattion_out = (ImageButton) convertView.findViewById(R.id.myattion_out);//获取控件
	
	//logo.setImageBitmap(GetImageViewBitmap.returnBitMap(onebus.getBus_image()));
	largetxt.setText(onebus.getBus_name());
	littletext.setText(onebus.getBus_introdiction());
	myattion_callme.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Toast.makeText(context, "提醒你", Toast.LENGTH_SHORT).show();
			myattion_out.setVisibility(View.VISIBLE);
			myattion_callme.setVisibility(View.GONE);
		}
	});

	return convertView;
	}

}

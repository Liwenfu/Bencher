package com.example.bencher.adapter;

import java.util.List;

import com.example.bencher.entity.HomePage;
import com.example.bencher.ui.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MyBaseAdapter extends BaseAdapter{

	
	private List<HomePage> bus;
	private int resource;
	private LayoutInflater inflater;
	private Context context;


	public MyBaseAdapter(List<HomePage> bus, Context context, int resource,
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
	               //获取控件
	TextView myhome_bigtitle = (TextView) convertView.findViewById(R.id.myhome_bigtitle);//得到控件
	myhome_bigtitle.setText(onebus.getBus_name());//填充数据
	               //设置监听事件
	return convertView;
	}

	
}

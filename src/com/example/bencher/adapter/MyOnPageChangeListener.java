package com.example.bencher.adapter;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;


public class MyOnPageChangeListener implements OnPageChangeListener {
	
	private List<View> mList = new ArrayList<View>();
	public MyOnPageChangeListener(List<View> list) {
		// TODO Auto-generated constructor stub
		this.mList = list;
	}
	public void onPageScrollStateChanged(int arg0) {
	}
	// ��һ��View����ǰ����
	public void onPageScrolled(int arg0, float arg1, int arg2) {
	}

	// ��View�����غ����
	public void onPageSelected(int arg0) {
		// �жϵ�ǰView�Ƿ�Ϊ������һ��View
	
		
		if (mList.size() == arg0+1 &&arg0+1>1) {
			
			
				
			}
}
}
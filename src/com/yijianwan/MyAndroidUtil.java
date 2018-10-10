package com.yijianwan;

import android.app.Service;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Vibrator;
import android.widget.Toast;

public class MyAndroidUtil {
	// �ж�wifi�Ƿ���
	 public boolean isWifi(Context context) {
		WifiManager wifiManager = (WifiManager) context
				.getSystemService(Context.WIFI_SERVICE);
		return wifiManager.isWifiEnabled();
	}

	// ����wifi
	 public void startWifi(Context context) {
		// ��ȡwifi����
		WifiManager wifiManager = (WifiManager) context
				.getSystemService(Context.WIFI_SERVICE);
		// �ж�wifi�Ƿ���
		if (!wifiManager.isWifiEnabled()) {
			wifiManager.setWifiEnabled(true);
			Toast.makeText(context, "wifi�����ɹ�!", Toast.LENGTH_SHORT).show();
		}
	}

	// �ر�wifi
	 public void closeWifi(Context context) {
		// ��ȡwifi����
		WifiManager wifiManager = (WifiManager) context
				.getSystemService(Context.WIFI_SERVICE);
		// �ж�wifi�Ƿ���
		if (wifiManager.isWifiEnabled()) {
			wifiManager.setWifiEnabled(false);
			Toast.makeText(context, "wifi�رճɹ�!", Toast.LENGTH_SHORT).show();
		}
	}

	// ��ʼ��
	public  void Vibrate(Context context, long milliseconds) {
		Vibrator vib = (Vibrator) context
				.getSystemService(Service.VIBRATOR_SERVICE);
		vib.vibrate(milliseconds);
		Toast.makeText(context, "������!", Toast.LENGTH_SHORT).show();
	}
}

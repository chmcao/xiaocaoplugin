package com.yijianwan;

import android.app.Service;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Vibrator;
import android.widget.Toast;

public class MyAndroidUtil {
	// 判断wifi是否开启
	 public boolean isWifi(Context context) {
		WifiManager wifiManager = (WifiManager) context
				.getSystemService(Context.WIFI_SERVICE);
		return wifiManager.isWifiEnabled();
	}

	// 开启wifi
	 public void startWifi(Context context) {
		// 获取wifi服务
		WifiManager wifiManager = (WifiManager) context
				.getSystemService(Context.WIFI_SERVICE);
		// 判断wifi是否开启
		if (!wifiManager.isWifiEnabled()) {
			wifiManager.setWifiEnabled(true);
			Toast.makeText(context, "wifi开启成功!", Toast.LENGTH_SHORT).show();
		}
	}

	// 关闭wifi
	 public void closeWifi(Context context) {
		// 获取wifi服务
		WifiManager wifiManager = (WifiManager) context
				.getSystemService(Context.WIFI_SERVICE);
		// 判断wifi是否开启
		if (wifiManager.isWifiEnabled()) {
			wifiManager.setWifiEnabled(false);
			Toast.makeText(context, "wifi关闭成功!", Toast.LENGTH_SHORT).show();
		}
	}

	// 开始震动
	public  void Vibrate(Context context, long milliseconds) {
		Vibrator vib = (Vibrator) context
				.getSystemService(Service.VIBRATOR_SERVICE);
		vib.vibrate(milliseconds);
		Toast.makeText(context, "开启震动!", Toast.LENGTH_SHORT).show();
	}
}

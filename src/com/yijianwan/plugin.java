package com.yijianwan;

import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import android.app.Service;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Vibrator;
import android.widget.Toast;

public class plugin {
	// "add,12,34"
	// "closewifi"
	// "openwifi"
	// "zhendong,2000"

	static public String Main(Context context, String params) {
		String [] contentParam = params.split(",");
		//getType
		String type = contentParam[0];
		
		if(type == "mail"){
			MyMailUtil mailUtil = new MyMailUtil();
			try {
				if(contentParam.length<7){
					return "参数不足";
				}
				//sendEmail(String sender,String possword String name,String title,String content,String acceptor)
				String result = mailUtil.sendEmail(contentParam[1],contentParam[2],contentParam[3],contentParam[4],contentParam[5],contentParam[6]);
				return result;
			} catch (Exception e) {
				e.printStackTrace();
				return "发送失败";
			}
		}
		return "没有调用插件";
	}

}

package com.cao.xiaocao;

import com.cao.xiaocaomh.R;
import com.yijianwan.MyMailUtil;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable(){
            @Override
            public void run() {
            	MyMailUtil mailUtil = new MyMailUtil();
                try {
                	
        			String result = mailUtil.sendEmail("as849167276@163.com","Declared.","我是小草","小草測試","這是發送內容","849167276@qq.com");
        		} catch (Exception e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
            }
        }).start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

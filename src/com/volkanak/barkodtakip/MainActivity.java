package com.volkanak.barkodtakip;

import org.apache.http.Header;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends Activity {

	EditText isim,fiyat,resim,barkod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isim=(EditText)findViewById(R.id.txturunAdi);
        fiyat=(EditText)findViewById(R.id.txtfiyat);
        resim=(EditText)findViewById(R.id.txtresim);
        barkod=(EditText)findViewById(R.id.txtbarkod);
        
    }
    
    
    public void gonder(View v)
    {
    	RequestParams parametre=new RequestParams();
    	parametre.put("urunisim",isim.getText().toString());
    	parametre.put("urunresim",resim.getText().toString());
    	parametre.put("urunfiyat",fiyat.getText().toString());
    	parametre.put("urunbarkod",barkod.getText().toString());
    	
    	AsyncHttpClient client=new AsyncHttpClient();
    	client.get("http://akakademi.biz/androids/ekle.php",parametre,new TextHttpResponseHandler()
    	{

			@Override
			public void onFailure(int statusCode, Header[] headers,
					String responseBody, Throwable error) {
				
			}

			@Override
			public void onSuccess(int statusCode, Header[] headers,
					String sonuc) {
				Log.d("sonuc",sonuc);
			}
    		
    		
    	});
    	
    	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

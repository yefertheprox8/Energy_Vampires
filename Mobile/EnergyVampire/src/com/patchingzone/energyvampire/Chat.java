package com.patchingzone.energyvampire;

import java.io.IOException;
import java.lang.reflect.Array;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.clwillingham.socket.io.IOMessage;
import com.clwillingham.socket.io.IOSocket;
import com.clwillingham.socket.io.IOWebSocket;
import com.clwillingham.socket.io.MessageCallback;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class Chat extends Activity {

	private Button btnSend;
	private Context c;
	private EditText etChat;
	private String address = "ws://192.168.8.74:2525";
	
	public String[] testString = {"1","5","6844165165414168"};

	public static IOSocket ioWebSocket;
	MessageCallback callback;
	IOMessage msg;
	IOWebSocket sok;

	int xR;
	int yR;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat);
		c = this;
		this.btnSend = (Button) findViewById(R.id.btnSend);
		this.etChat = (EditText) findViewById(R.id.etChat);

		this.btnSend.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
				TextView tv = new TextView(c);
				tv.setWidth(ll.getWidth());
				tv.setTextColor(Color.parseColor("#FFFFFF"));
				ll.addView(tv);
				tv.setText(etChat.getText().toString());
				etChat.setText("");
			}
		});

		msg = new IOMessage(IOMessage.EVENT, -1, "", "");

		callback = new MessageCallback() {

			public void onOpen() {
			}

			public void onMessage(String message) {
			}

			public void on(String event, String data) {
			}

			public void onEvent(String message) {
					JsonParser.Parse(message);
					JsonParser.SendMessage("Hello Thijs.");
					JsonParser.SendJsonMessage("Test",testString);

			}

		};
		new Thread() {
			@Override
			public void run() {
				try {
					ioWebSocket = new IOSocket(address, callback);
					ioWebSocket.connect();

				} catch (IOException e) {
					Log.e("exeption", "" + e);
				}
			}
		}.start();
	}

}

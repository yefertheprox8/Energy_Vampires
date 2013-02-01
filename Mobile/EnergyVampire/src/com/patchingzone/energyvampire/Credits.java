package com.patchingzone.energyvampire;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Credits extends BaseWebview {
	
	private boolean changedTheme;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    
	    changedTheme = false;
	    SetPage("file:///android_asset/credit/index.html");	
	    //SetPage("http://vincentict.mine.nu/credit/index.html");	
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.creditmenu, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.opt1:
	        	SetPage("javascript:SetStyle();");
	        	changedTheme = true;
        	return true;
	    }
		return false;
	}

}

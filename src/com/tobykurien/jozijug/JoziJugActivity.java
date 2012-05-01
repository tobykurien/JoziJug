package com.tobykurien.jozijug;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Toast;

public class JoziJugActivity extends Activity {
	private static final int PICK_CONTACT = 1;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == PICK_CONTACT && resultCode == RESULT_OK) {
			Cursor c = managedQuery(data.getData(), null, null, null, null);
			c.moveToNext();
			String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
			Toast.makeText(this, "You picked: " + name, Toast.LENGTH_LONG).show();
			return;
		}
		
		super.onActivityResult(requestCode, resultCode, data);
	}
	
	public void onLocation(View v) {
		Uri uri = Uri.parse("geo:0,0?q=-26.0424,28.0237 (JoziJUG)");
		Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri);
		startActivity(intent);
	}

	public void onWebsite(View v) {
		Uri uri = Uri.parse("http://www.jozijug.co.za");
		Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri);
		startActivity(intent);
	}

	public void onContact(View v) {
		Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
		startActivityForResult(intent, PICK_CONTACT);		
	}
	
	public void onMembers(View v) {
		Intent i = new Intent(this, Members.class);
		startActivity(i);
	}
}
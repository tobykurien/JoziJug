package com.tobykurien.jozijug;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts.People;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Members extends ListActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub	
		super.onCreate(savedInstanceState);
		
		Cursor c = managedQuery(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
		
		ListAdapter a = new SimpleCursorAdapter(this, 
				android.R.layout.simple_list_item_1, 
				c, 
				new String[]{ ContactsContract.Contacts.DISPLAY_NAME }, 
				new int[] { android.R.id.text1 });
		
		getListView().setAdapter(a);
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		Cursor c = (Cursor) l.getAdapter().getItem(position);
		String number = c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
		
		Intent i = new Intent(Intent.ACTION_CALL);
		i.setData(Uri.parse("tel:" + number));
		startActivity(i);
	}
}

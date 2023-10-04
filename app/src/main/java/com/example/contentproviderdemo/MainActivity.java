package com.example.contentproviderdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lst=findViewById(R.id.lst1);

        Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);

        // on below line calling method to manage the cursor.
        startManagingCursor(cursor);

        // on below line getting the data from contacts
        String[] data = {ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME};

        // on below line specifying id to which we have to set the data.
        int[] to = {R.id.txt1, R.id.txt2};

        // on below line creating and initializing simple cursor adapter and passing the layout file which we have to display.
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.itemlayout, cursor, data,to);



        String array[]={ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone._ID};

       // ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,array);
        lst.setAdapter(adapter);
        lst.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }
}
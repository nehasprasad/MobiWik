package com.example.android.mobiwik;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;


public class DetailActivity extends ActionBarActivity {

    public Mobile s;
    private CustomAdapter adapter;
    private  ListView lv;
    List<Mobile> studentsList;


    public static final String TAG = DetailActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        lv = (ListView)findViewById(R.id.listView);
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Mobile");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> parseObjects, ParseException e) {
                if(e==null) {
                    studentsList= new ArrayList<Mobile>();
                    for(ParseObject ob: parseObjects) {

                        s= new Mobile();
                        ParseFile image = (ParseFile) ob.get("Image");

                        s.setName(ob.getString("Name").toString());
                        s.setPrice(ob.getString("Price").toString());
                        s.setBrand(ob.getString("Brand").toString());
                        s.setCamera(ob.getString("Camera").toString());
                        s.setImage(image);
                        /*s.setMemory(ob.getString("Memory").toString());
                        s.setRAM(ob.getString("Ram").toString());
                         */
                       /* s.setWeight(ob.getString("Weight").toString());*/

                        studentsList.add(s);
                    }
                    adapter = new CustomAdapter(DetailActivity.this, studentsList);
                    lv.setAdapter(adapter);

                } else {
                    Toast.makeText(DetailActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                }

            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}



/*public class DetailActivity extends ListActivity {

    List<Mobile> mobile = new ArrayList<Mobile>();

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parse_list);

        ParseQuery<Mobile> query = new ParseQuery<Mobile>("Mobile");
       query.findInBackground(new FindCallback<Mobile>() {
            @Override
            public void done(List<Mobile> list, ParseException e) {
                if (e != null){
                    Toast.makeText(DetailActivity.this, "Error " + e, Toast.LENGTH_SHORT ).show();
                }
                for (Mobile mobile1 : list){
                    Mobile newMobile = new Mobile();
                   ParseFile applicantResume = (ParseFile) list.get("Image");
                    applicantResume.getDataInBackground(new GetDataCallback() {
                        @Override
                        public void done(byte[] bytes, ParseException e) {
                           if(e==null)
                           {
                               Bitmap bmp= BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                                 }
                        }
                    });
                    newMobile.setName(mobile1.getName());
                    newMobile.setBrand(mobile1.getBrand());
                    newMobile.setPrice(mobile1.getPrice());
                    newMobile.setCamera(mobile1.getCamera());
                    newMobile.setMemory(mobile1.getMemory());
                    newMobile.setRAM(mobile1.getRAM());
                    newMobile.setWeight(mobile1.getWeight());
                    mobile.add(newMobile);
                }

                ArrayAdapter<Mobile> adapter = new ArrayAdapter<Mobile>(DetailActivity.this, android.R.layout.simple_list_item_1, mobile);
                setListAdapter(adapter);
            }
        });
    }
}*/

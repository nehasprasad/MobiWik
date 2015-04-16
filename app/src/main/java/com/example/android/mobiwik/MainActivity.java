package com.example.android.mobiwik;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private RadioGroup radioGroup;
    private RadioButton price1, price2, price3, price4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button) findViewById(R.id.button1);

        price1 = (RadioButton) findViewById(R.id.price1);
        price2 = (RadioButton) findViewById(R.id.price2);
        price3 = (RadioButton) findViewById(R.id.price3);
        price4 = (RadioButton) findViewById(R.id.price4);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                final Intent intent = new Intent(getApplicationContext(),RAM.class);
                startActivity(intent);
                radioGroup = (RadioGroup) findViewById(R.id.radiogroup_layout);
                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        // find which radio button is selected
                        if (checkedId == R.id.price1) {
                            Toast.makeText(getApplicationContext(), "choice: Silent",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent1 = new Intent(MainActivity.this,RAM.class);
                            intent1.putExtra("Price","10000");
                            startActivity(intent);
                        } else if (checkedId == R.id.price2) {
                            Toast.makeText(getApplicationContext(), "choice: Sound",
                                    Toast.LENGTH_SHORT).show();
                        } else if (checkedId == R.id.price3) {
                            Toast.makeText(getApplicationContext(), "choice: Sound",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "choice: Vibration",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }

                });




            }

        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

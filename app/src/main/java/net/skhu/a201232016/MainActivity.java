package net.skhu.a201232016;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);
        Button button2 = (Button)findViewById(R.id.button2);

        View.OnClickListener listener1 = new View.OnClickListener() {
            @Override
            public  void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Exam1Activity.class);
                startActivity(intent);
            }
        };

        View.OnClickListener listener2 = new View.OnClickListener() {
            @Override
            public  void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Exam2Activity.class);
                startActivity(intent);
            }
        };

        button.setOnClickListener(listener1);
        button2.setOnClickListener(listener2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.activity_exam1) {
            Intent intent = new Intent(this, Exam1Activity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.activity_exam2) {
            Intent intent = new Intent(this, Exam2Activity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

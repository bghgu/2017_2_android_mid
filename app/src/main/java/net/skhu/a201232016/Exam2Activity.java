package net.skhu.a201232016;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Exam2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam2);

        CompoundButton.OnCheckedChangeListener listener1 = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String s;
                if(isChecked) {
                    s = String.format( "%s 선택되었습니다.", buttonView.getText());
                }else {
                    s = String.format( "%s 선택이 취소되었습니다.", buttonView.getText());
                }
                Toast.makeText(Exam2Activity. this, s, Toast. LENGTH_SHORT).show();
            }
        };

        final CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkbox_cat);
        final CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox_dog);

        checkBox1.setOnCheckedChangeListener(listener1);
        checkBox2.setOnCheckedChangeListener(listener1);

        RadioGroup.OnCheckedChangeListener listener2 = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                String s = String.format( "%s 선택되었습니다.", radioButton.getText());
                Toast.makeText(Exam2Activity. this, s, Toast. LENGTH_SHORT).show();
            }
        };
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id. radioGroup);
        radioGroup.setOnCheckedChangeListener(listener2);


        Button btn_save = (Button)findViewById(R.id.btn_save);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = (TextView)findViewById(R.id.textView);
                String s = textView.getText().toString();
                if(checkBox1.isChecked()) {
                    String mag = (" " + checkBox1.getText() + "선택되었습니다.");
                    s += mag;
                }
                if(checkBox2.isChecked()) {
                    String mag = (" " + checkBox2.getText() + "선택되었습니다.");
                    s += mag;
                }
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id. radioButton_matro: s += " 지하철 선택되었습니다. "; break;
                    case R.id. radioButton_bus: s += " 버스 선택되었습니다. "; break;
                }
                textView.setText(s);
            }
        };

        btn_save.setOnClickListener(listener);

    }
}

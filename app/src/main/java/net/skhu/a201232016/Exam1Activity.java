package net.skhu.a201232016;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Exam1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam1);

        Button btn_save = (Button)findViewById(R.id.btn_save);
        Button btn_delete = (Button)findViewById(R.id.btn_delete);

        View.OnClickListener listener1 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText)findViewById(R.id.editText);
                String text = editText.getText().toString();
                if (isEmptyOrWhiteSpace(text))
                    editText.setError("내용을 입력하세요.");
                TextView textView = (TextView)findViewById(R.id.textView);
                String text2 = textView.getText().toString();
                textView.setText(text2 + " " + text);
            }
        };

        View.OnClickListener listener2 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = (TextView)findViewById(R.id.textView);
                textView.setText("");
            }
        };

        btn_save.setOnClickListener(listener1);
        btn_delete.setOnClickListener(listener2);
    }

    static boolean isEmptyOrWhiteSpace(String s) {
        if (s == null) return true;
        return s.trim().length() == 0;
    }
}

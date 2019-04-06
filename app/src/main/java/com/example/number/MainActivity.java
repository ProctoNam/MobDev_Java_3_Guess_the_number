package com.example.number;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tvInfo;
    EditText etInput;
    Button bControl;
    Button bLevel;
    Button bQuit;
    int r = new Random().nextInt(100 / 1);
    int level = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInfo = findViewById(R.id.textView);
        etInput = findViewById(R.id.editText);
        bControl = findViewById(R.id.button);
        bLevel = findViewById(R.id.level);
        bQuit = findViewById(R.id.Quit);

    }

    public void onClick(View view) {
        try{
            int value = Integer.parseInt(etInput.getText().toString());
            if (value > 100*level || value < 0)
            {
                throw new InstantiationException();
            }
            if (value > r)
            {
                tvInfo.setText(getResources().getString(R.string.ahead)+" (Ответ)" +r);
            }
            else if (value < r)
            {
                tvInfo.setText(getResources().getString(R.string.behind)+" (Ответ)" +r);
            }
            else if (value == r)
            {
                tvInfo.setText(getResources().getString(R.string.hit)+" (Ответ)" +r);
            }
        }
        catch(InstantiationException e)
        {
            tvInfo.setText("Введенное число не должно быть выше "+ 100*level +" и не должно быть менее 0!");
        }
        catch(Exception e){
            tvInfo.setText(getResources().getString(R.string.error)+r);
        }
        //tvInfo.setText(getResources().getString(R.string.ahead)+r);
    }
    public void level(View view){
        level++;
        r = new Random().nextInt(100*level / 1);
        if (level > 3)
        {
            level = 1;
            r = new Random().nextInt(100*level / 1);
        }
        bLevel.setText("Уровень " + level);
    }

    public void quit(View view){
        System.exit(0);
    }
}


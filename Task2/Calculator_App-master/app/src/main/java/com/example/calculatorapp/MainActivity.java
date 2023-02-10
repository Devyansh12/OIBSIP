package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView resultTv;
    TextView solutionTv;
    MaterialButton buttonC;
    MaterialButton buttonBracketO;
    MaterialButton buttonBracketC;
    MaterialButton buttondiv;
    MaterialButton buttonmul;
    MaterialButton buttonplus;
    MaterialButton buttonminus;
    MaterialButton buttonequal;
    MaterialButton button0,button1,button2,button3,button4,button5,button6,button7,button8,button9;
    MaterialButton buttonAC,buttonDot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTv = findViewById(R.id.result_tv);
        solutionTv = findViewById(R.id.solution_tv);

        assignID(buttonC,R.id.button_C);
        assignID(buttonBracketO,R.id.button_open);
        assignID(buttonBracketC,R.id.button_close);
        assignID(button0,R.id.button_zero);
        assignID(button1,R.id.button_one);
        assignID(button2,R.id.button_two);
        assignID(button3,R.id.button_three);
        assignID(button4,R.id.button_four);
        assignID(button5,R.id.button_five);
        assignID(button6,R.id.button_six);
        assignID(button7,R.id.button_seven);
        assignID(button8,R.id.button_eight);
        assignID(button9,R.id.button_nine);
        assignID(buttondiv,R.id.button_divide);
        assignID(buttonmul,R.id.button_multiply);
        assignID(buttonplus,R.id.button_plus);
        assignID(buttonminus,R.id.button_minus);
        assignID(buttonDot,R.id.button_dot);
        assignID(buttonequal,R.id.button_equal);
        assignID(buttonAC,R.id.button_Clear);


    }

    void assignID(MaterialButton btn,int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();
        String datatocal = solutionTv.getText().toString();

        if (buttonText.equals("AC"))
        {
            solutionTv.setText("");
            resultTv.setText("0");
            return;
        }
        if (buttonText.equals("="))
        {
            solutionTv.setText(resultTv.getText());
            return;
        }

        if (buttonText.equals("C"))
        {
            datatocal = datatocal.substring(0,datatocal.length()-1);
        }
        else
        {
            datatocal = datatocal+buttonText;
        }
        solutionTv.setText(datatocal);

        String finalResult = getResult(datatocal);

        if (!finalResult.equals("Err"))
        {
            resultTv.setText(finalResult);
        }


    }

    String getResult(String data)
    {
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            String finalResult = context.evaluateString(scriptable,data,"Javascript",1,null).toString();
            if (finalResult.endsWith(".0"))
            {
                finalResult = finalResult.replace(".0","");
            }
            return finalResult;
        }catch(Exception e){
            return "Err";
        }
    }
}
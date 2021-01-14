package com.example.andorid_view;
/***
 * 计算器
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {
    TextView calcText,calc_result;
    String calcFun="";
    Button clear_calc,calc_b_divide,calc_b_multiply,calc_b_subtract,calc_b_eq,calc_b_add,
            calc_n_7,calc_n_8,calc_n_9,calc_n_4,calc_n_5,calc_n_6,calc_n_1,calc_n_2,calc_n_3,calc_n_0,calc_n_dot;

    boolean isFirst = true,isBtn=false,isLast = false;
    String firstV = "0",lastV = "0",btnV = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        init();
    }

    private void init() {
        calcText = findViewById(R.id.calc_view);
        calc_result = findViewById(R.id.calc_result);

        clear_calc = findViewById(R.id.clear_calc);
        calc_b_divide = findViewById(R.id.calc_b_divide);
        calc_b_multiply = findViewById(R.id.calc_b_multiply);
        calc_b_subtract = findViewById(R.id.calc_b_subtract);
        calc_b_eq = findViewById(R.id.calc_b_eq);
        calc_b_add = findViewById(R.id.calc_b_add);
        calc_n_7 = findViewById(R.id.calc_n_7);
        calc_n_8 = findViewById(R.id.calc_n_8);
        calc_n_9 = findViewById(R.id.calc_n_9);
        calc_n_4 = findViewById(R.id.calc_n_4);
        calc_n_5 = findViewById(R.id.calc_n_5);
        calc_n_6 = findViewById(R.id.calc_n_6);
        calc_n_1 = findViewById(R.id.calc_n_1);
        calc_n_2 = findViewById(R.id.calc_n_2);
        calc_n_3 = findViewById(R.id.calc_n_3);
        calc_n_0 = findViewById(R.id.calc_n_0);
        calc_n_dot = findViewById(R.id.calc_n_dot);

        clear_calc.setOnClickListener(new CalculatorClick());
        calc_b_divide.setOnClickListener(new CalculatorClick());
        calc_b_multiply.setOnClickListener(new CalculatorClick());
        calc_b_subtract.setOnClickListener(new CalculatorClick());
        calc_b_eq.setOnClickListener(new CalculatorClick());
        calc_b_add.setOnClickListener(new CalculatorClick());
        calc_n_7.setOnClickListener(new CalculatorClick());
        calc_n_8.setOnClickListener(new CalculatorClick());
        calc_n_9.setOnClickListener(new CalculatorClick());
        calc_n_4.setOnClickListener(new CalculatorClick());
        calc_n_5.setOnClickListener(new CalculatorClick());
        calc_n_6.setOnClickListener(new CalculatorClick());
        calc_n_1.setOnClickListener(new CalculatorClick());
        calc_n_2.setOnClickListener(new CalculatorClick());
        calc_n_3.setOnClickListener(new CalculatorClick());
        calc_n_0.setOnClickListener(new CalculatorClick());
        calc_n_dot.setOnClickListener(new CalculatorClick());
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context,CalculatorActivity.class));
    }

    public void goMain(View view) {
        MainActivity.start(this);
        finish();
    }

    class CalculatorClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Button b = (Button)v;
            switch (v.getId()) {
                case R.id.clear_calc:
                    setView("clear",0);
                    break;
                case R.id.calc_b_eq:
                    setView("=",0);
                    break;
                case R.id.calc_b_divide:
                case R.id.calc_b_multiply:
                case R.id.calc_b_subtract:
                case R.id.calc_b_add:
                    setView(b.getText().toString(),0);
                    break;
                case R.id.calc_n_7:
                case R.id.calc_n_8:
                case R.id.calc_n_9:
                case R.id.calc_n_4:
                case R.id.calc_n_5:
                case R.id.calc_n_6:
                case R.id.calc_n_1:
                case R.id.calc_n_2:
                case R.id.calc_n_3:
                case R.id.calc_n_0:
                case R.id.calc_n_dot:
                    setView(b.getText().toString(),1);
                    break;
            }
        }
    }

    private void setView(String type,int btnType) {
        if(type.equals("clear")) { // 清空
            calcFun = "";
            isFirst = false;
            isBtn   = false;
            calcText.setText("");
            calc_result.setText("");
            return;
        }

        if(type.equals("=")) { // 计算
            calcFun = "";
            isFirst = false;
            isBtn   = false;
            isLast = false;
            String result = calcute(firstV,lastV);
            firstV = "";
            lastV = "";

            calc_result.setText(result);
            return;
        }

        if(btnType == 0) {
            if(firstV.equals("")) {
                calcFun = "0";
            }
            if(isBtn) {
                calcFun = calcFun.substring(0,calcFun.length() - 1) + type;
            }else{
                calcFun += type;
            }
            btnV = type;
            isBtn = true;
            calcText.setText(calcFun);
            // 1+1+1+1

            if(isFirst) { // 如果是第一个
                isFirst = false;
                isLast = true;
            }else if(isLast) {
                isLast =false;
                isFirst = true;
                firstV = calcute(firstV,lastV);
                lastV = "";
            }
            return;
        }

        if(btnType == 1) {
            if(isFirst) {
                firstV += type;
            } else {
                lastV += type;
                isLast = true;
            }
            isBtn = false;
            calcFun += type;
            calcText.setText(calcFun);
        }

    }

    private String calcute(String firstV,String lastV) {
        float first = Float.parseFloat(firstV);
        float last = Float.parseFloat(lastV);
        float result = 0;
        switch (btnV) {
            case "+":
                result = first + last;
                break;
            case "-":
                result = first - last;
                break;
            case "*":
                result = first * last;
                break;
            case "/":
                result = first / last;
                break;

        }
        return ""+result;
    }

}
package com.example.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("WrongViewCast")
    private EditText display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);
        display.setOnClickListener(view -> {
            if(getString(R.string.input).equals(display.getText().toString())){
                display.setText("");
            }
        });
    }

    private void updateText(String strToAdd){
        String oldStr= display.getText().toString();
        int curpos= display.getSelectionStart();
        String leftStr= oldStr.substring(0, curpos);
        String rightStr= oldStr.substring(curpos);
        if(getString(R.string.input).equals(display.getText().toString())){
            display.setText(strToAdd);
            display.setSelection(curpos + 1);
        }else{
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(curpos + 1);
        }
    }
    public void zero(View view){
        updateText("0");
    }
    public void one(View view){
        updateText("1");
    }
    public void two(View view){
        updateText("2");
    }
    public void three(View view){
        updateText("3");
    }
    public void four(View view){
        updateText("4");
    }
    public void five(View view){
        updateText("5");
    }
    public void six(View view){
        updateText("6");
    }
    public void seven(View view){
        updateText("7");
    }
    public void eight(View view){
        updateText("8");
    }
    public void nine(View view){
        updateText("9");
    }
    public void par(View view){
        int curpos= display.getSelectionStart();
        int openpar=0;
        int closepar=0;
        int textLen=display.getText().length();
        for(int i=0; i<curpos; i++){
            if(display.getText().toString().substring(i, i+1).equals("(")){
                openpar+=1;
            }
            if(display.getText().toString().substring(i, i+1).equals(")")){
                closepar+=1;
            }
        }
        if (openpar==closepar || display.getText().toString().substring(textLen-1, textLen).equals("(")){
            updateText("(");
            display.setSelection(curpos+1);
        }else if(closepar<openpar && !display.getText().toString().substring(textLen-1, textLen).equals(")")){
            updateText(")");
            display.setSelection(curpos+1);
        }
    }
    public void equals(View view){
        String userExp= display.getText().toString();
        userExp=userExp.replaceAll("÷","/");
        userExp=userExp.replaceAll("×","*");
        userExp=userExp.replaceAll("%","#");
        Expression exp=new Expression(userExp);
        String result=String.valueOf(exp.calculate());
        display.setText(result);
        display.setSelection(result.length());

    }
    public void mod(View view){
        updateText("%");
    }
    public void mul(View view){
        updateText("×");
    }
    public void div(View view){
        updateText("/");
    }
    public void add(View view){
        updateText("+");
    }
    public void sub(View view){
        updateText("-");
    }
    public void clear(View view){
        display.setText("");
    }
    public void backspace(View view){
        int curpos=display.getSelectionStart();
        int textLen=display.getText().length();
        if(curpos!=0 && textLen!=0){
            SpannableStringBuilder selection=(SpannableStringBuilder) display.getText();
            selection.replace(curpos - 1, curpos, "");
            display.setText(selection);
            display.setSelection(curpos - 1);
        }
    }
    public void dec(View view){
        updateText(".");
    }
}
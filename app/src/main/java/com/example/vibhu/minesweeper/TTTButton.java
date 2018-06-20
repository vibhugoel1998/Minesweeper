package com.example.vibhu.minesweeper;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;

/**
 * Created by VIBHU on 2/3/2018.
 */

public class TTTButton extends AppCompatButton{
    private int value=0;
    int i;
    int j;
    public TTTButton(Context context){
        super(context);
    }
    public void setValue(int value){
        this.value=value;
    }
    public int getValue(){
        return value;
    }
    public void setI(int i){
        this.i=i;
    }
    public void setJ(int j){
        this.j=j;
    }
    public int getI()
    {
        return i;
    }
    public int getJ()
    {
        return j;
    }
}

package com.example.vibhu.minesweeper;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Random;

import static java.lang.Compiler.disable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    LinearLayout rootLayout;
    int size=10;
    public static final int mine=-1;
    public  TTTButton board[][];
   public boolean gameOver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rootLayout=findViewById(R.id.rootLayout);
        board=new TTTButton[size][size];
        setupBoard();
    }
    private void setupBoard() {
        rootLayout.removeAllViews();

        for(int i=0;i<size;i++)
        {
            LinearLayout rowLayout=new LinearLayout(this);
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,0,1);
            rowLayout.setLayoutParams(params);
            rowLayout.setOrientation(LinearLayout.HORIZONTAL);
            for(int j=0;j<size;j++)
            {
                TTTButton button=new TTTButton(this);
                LinearLayout.LayoutParams bParams=new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT,1);
                button.setLayoutParams(bParams);
                rowLayout.addView(button);
                board[i][j]=button;
                button.setI(i);
                button.setJ(j);
                button.setOnClickListener(this);
                button.setOnLongClickListener(this);
            }
            rootLayout.addView(rowLayout);

        }
        gameOver=false;
        setMines();
        setNumber();

    }

    private void setNumber() {
        for(int row=0;row<size;row++)
        {
            for(int col=0;col<size;col++)
            {
                TTTButton check=board[row][col];
                if(check.getValue()==-1)
                {
                    if(row==0)
                    {
                        if(col==0)
                        {
                            int temp=board[0][1].getValue();
                            if(temp!=-1)
                            board[0][1].setValue(temp+1);
                            temp=board[1][0].getValue();
                            if(temp!=-1)
                            board[1][0].setValue(temp+1);
                            if(temp!=-1)
                            temp=board[1][1].getValue();
                            board[1][1].setValue(temp+1);
                        }
                        else if(col==size-1)
                        {
                           int temp=board[0][size-1].getValue();
                           if(temp!=-1)
                           board[0][size-1].setValue(temp+1);
                           temp=board[1][size-1].getValue();
                            if(temp!=-1)
                           board[1][size-1].setValue(temp+1);
                            temp=board[0][size-2].getValue();
                            if(temp!=-1)
                                board[0][size-2].setValue(temp+1);
                        }
                        else
                        {
                            int temp=board[row][col-1].getValue();
                            if (temp!=-1)
                            {
                                board[row][col-1].setValue(temp+1);
                            }
                            temp=board[row][col+1].getValue();
                            if(temp!=-1)
                                board[row][col+1].setValue(temp+1);
                            temp=board[row+1][col-1].getValue();
                            if(temp!=-1)
                                board[row+1][col-1].setValue(temp+1);
                            temp=board[row+1][col+1].getValue();
                            if(temp!=-1)
                                board[row+1][col+1].setValue(temp+1);
                            temp=board[row+1][col].getValue();
                            if(temp!=-1)
                                board[row+1][col].setValue(temp+1);
                        }


                    }
                    else if(row==size-1)
                    {
                        if(col==0)
                        {
                            int temp=board[size-1][1].getValue();
                            if(temp!=-1)
                                board[size-1][1].setValue(temp+1);
                            temp=board[size-2][0].getValue();
                            if(temp!=-1)
                                board[size-2][0].setValue(temp+1);
                            if(temp!=-1)
                                temp=board[size-2][1].getValue();
                            board[size-2][1].setValue(temp+1);
                        }
                        else if(col==size-1)
                        {
                            int temp=board[size-1][size-2].getValue();
                            if(temp!=-1)
                                board[size-1][size-2].setValue(temp+1);
                            temp=board[size-2][size-1].getValue();
                            if(temp!=-1)
                                board[size-2][size-1].setValue(temp+1);
                            temp=board[size-2][size-2].getValue();
                            if(temp!=-1)
                                board[size-2][size-2].setValue(temp+1);
                        }
                        else
                        {
                            int temp=board[row][col].getValue();
                            if (temp!=-1)
                                board[row][col].setValue(temp+1);
                            temp=board[row][col+1].getValue();
                            if (temp!=-1)
                                board[row][col+1].setValue(temp+1);
                            temp=board[row][col-1].getValue();
                            if (temp!=-1)
                                board[row][col-1].setValue(temp+1);
                            temp=board[row+1][col].getValue();
                            if (temp!=-1)
                                board[row+1][col].setValue(temp+1);
                            temp=board[row+1][col-1].getValue();
                            if (temp!=-1)
                                board[row+1][col-1].setValue(temp+1);
                            temp=board[row+1][col+1].getValue();
                            if (temp!=-1)
                                board[row+1][col+1].setValue(temp+1);

                        }
                    }
                    else if(col==0)
                    {
                        if(row!=0 && row!=size-1)
                        {
                            int temp=board[row-1][col].getValue();
                            if(temp!=-1)
                                board[row-1][col].setValue(temp+1);
                            temp=board[row+1][col].getValue();
                            if(temp!=-1)
                                board[row+1][col].setValue(temp+1);
                            temp=board[row][col+1].getValue();
                            if(temp!=-1)
                                board[row][col+1].setValue(temp+1);
                            temp=board[row-1][col+1].getValue();
                            if(temp!=-1)
                                board[row-1][col+1].setValue(temp+1);
                            temp=board[row+1][col+1].getValue();
                            if(temp!=-1)
                                board[row+1][col+1].setValue(temp+1);

                        }
                    }
                    else if(col==size-1)
                    {
                        if(row!=0 && row!=size-1)
                        {
                            int temp=board[row-1][col].getValue();
                            if(temp!=-1)
                                board[row-1][col].setValue(temp+1);
                            temp=board[row+1][col].getValue();
                            if(temp!=-1)
                                board[row+1][col].setValue(temp+1);
                            temp=board[row][col-1].getValue();
                            if(temp!=-1)
                                board[row][col-1].setValue(temp+1);
                            temp=board[row-1][col-1].getValue();
                            if(temp!=-1)
                                board[row-1][col-1].setValue(temp+1);
                            temp=board[row+1][col-1].getValue();
                            if(temp!=-1)
                                board[row+1][col-1].setValue(temp+1);
                        }
                    }
                    else
                    {
                        int temp=board[row][col-1].getValue();
                        if(temp!=-1)
                            board[row][col-1].setValue(temp+1);
                         temp=board[row][col+1].getValue();
                        if(temp!=-1)
                            board[row][col+1].setValue(temp+1);
                        temp=board[row+1][col].getValue();
                        if(temp!=-1)
                            board[row+1][col].setValue(temp+1);
                        temp=board[row+1][col+1].getValue();
                        if(temp!=-1)
                            board[row+1][col+1].setValue(temp+1);
                        temp=board[row+1][col-1].getValue();
                        if(temp!=-1)
                            board[row][col-1].setValue(temp+1);
                        temp=board[row-1][col+1].getValue();
                        if(temp!=-1)
                            board[row-1][col+1].setValue(temp+1);
                        temp=board[row-1][col].getValue();
                        if(temp!=-1)
                            board[row-1][col].setValue(temp+1);
                        temp=board[row-1][col-1].getValue();
                        if(temp!=-1)
                            board[row-1][col-1].setValue(temp+1);
                    }

                }
            }
        }
    }

    private void setMines() {
        Random random=new Random();
        for(int p=0;p<25;p++) {
            int i = random.nextInt(9);
            int j = random.nextInt(9);
            board[i][j].setValue(-1);
        }
    }


    @Override
    public void onClick(View view) {
        TTTButton button =(TTTButton)view;
        int temp=button.getValue();
        if(temp==-1)
        {
            for(int l=0;l<size;l++)
            {
                for(int o=0;o<size;o++)
                {
                    if(board[l][o].getValue()==-1)
                    {
                        board[l][o].setText("*");
                    }
                }
            }
            Toast.makeText(this,"game over",Toast.LENGTH_SHORT).show();
            disableBoard();
        }
        else if(temp==0)
        {
            int p=button.getI();
            int q=button.getJ();
            recFn(p,q);
        }
        else
        {
            button.setText(button.getValue()+"");
        }
    }

    private void disableBoard() {
        for(int p=0;p<size;p++)
        {
            for(int o=0;o<size;o++)
            {
              TTTButton b=board[p][o];
              b.setEnabled(false);
            }
        }
    }

    private void recFn(int p,int q) {
        TTTButton button=board[p][q];
        if(button.isEnabled()==false)
        {
            return;
        }
        if(button.getValue()==-1)
        {
            return;
        }
        if(button.getValue()!=-1 && button.getValue()!=0)
        {
            button.setText(button.getValue()+"");
            button.setEnabled(false);
            return;
        }
        if(button.getValue()==0)
        {
            button.setEnabled(false);
            button.setBackgroundResource(R.drawable.won);
            if(q-1>0)
            {
                recFn(p,q-1);
            }
            if(q+1<size)
            {
                recFn(p,q+1);
            }
            if(p+1<size)
            {
                recFn(p+1,q);
                if(q+1<size)
                {
                    recFn(p+1,q+1);
                }
                if(q-1>0)
                {
                    recFn(p+1,q-1);
                }
            }
            if(p-1>0)
            {
                recFn(p-1,q);
                if(q+1<size)
                {
                    recFn(p-1,q+1);
                }
                if(q-1>0)
                {
                    recFn(p-1,q-1);
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.reset)
        {
          setupBoard();
        }
        return true;
    }

    @Override
    public boolean onLongClick(View view) {
        TTTButton button=(TTTButton)view;
        if(button.getText().toString().equals("!"))
        {
            button.setText("");
        }
        else {
            button.setText("!");
        }
        return true;
    }
}

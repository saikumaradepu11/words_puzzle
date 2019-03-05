package com.example.saikumar.words_puzzle;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class secondlevel extends AppCompatActivity {

    TextView word;
    EditText editword1,editword2,editword3,editword4;
    Button check;

    Random r;
    String currentword;

    int counter=0;

    int one=1;
    int zero=0;

    String dictionary1[]={"zinc","jaws","lazy","gaze","quad","bump","jail","mock","pick","camp","hack","text","grid","trim","what","bulb","neck","lack","weak","bawl"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondlevel);

        word=findViewById(R.id.level2word);
        editword1=findViewById(R.id.level2edit1);
        editword2=findViewById(R.id.level2edit2);
        editword3=findViewById(R.id.level2edit3);
        editword4=findViewById(R.id.level2edit4);
        check=findViewById(R.id.level2btn);

        newgame();

        editword1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if(editword1.getText().length()==zero)
                {
                    editword2.requestFocus();
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editword2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if(editword2.getText().length()==zero)
                {
                    editword3.requestFocus();
                }

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        final View view=this.getCurrentFocus();

        editword3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if(editword3.getText().length()==zero)
                {
                    editword4.requestFocus();

                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editword4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                InputMethodManager imm=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(),0);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String checking=editword1.getText().toString()+editword2.getText().toString()+editword3.getText().toString()+editword4.getText().toString();

                if(checking.equalsIgnoreCase(currentword))
                {
                    String lastword="bawl";
                    if(checking.equalsIgnoreCase(lastword))
                    {
                        AlertDialog.Builder builder=new AlertDialog.Builder(secondlevel.this);
                        builder.setTitle("Level - 2");
                        builder.setMessage("Congratulations you cleared level - 2");
                        builder.setPositiveButton("Next", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent=new Intent(secondlevel.this,secondlevel.class);
                                startActivity(intent);
                                finish();
                            }
                        });
                        builder.setNegativeButton("Play Agian", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent=new Intent(secondlevel.this,MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        });
                        builder.show();

                    }

                    ++counter;
                    if(counter!=20)
                    {
                        newgame();
                    }

                }
                else
                {
                    Toast.makeText(secondlevel.this,"Wrong",Toast.LENGTH_LONG).show();
                }




            }
        });





    }

    private String shufflewords(String word)
    {
        List<String> letters=Arrays.asList(word.split(""));
        Collections.shuffle(letters);
        String shuffled= "";
        for(String letter : letters)
        {
            shuffled+=letter;
        }
        return shuffled;

    }

    private void newgame() {
        currentword=dictionary1[counter];
        word.setText(shufflewords(currentword));

        editword1.setText("");
        editword2.setText("");
        editword3.setText("");
        editword4.setText("");

        editword1.requestFocus();


    }
}

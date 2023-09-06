package com.example.textboxesarrays;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button btn_j_addResturant;

    Button btn_j_pickresturnat;

    EditText et_j_newresturant;

    TextView txt_j_resturant;

    TextView txt_j_errorNoResturant;

    int count = 0;

    int randomPosition;


    private String[] resturant = new String[6];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_j_addResturant = findViewById(R.id.btn_v_add);
        btn_j_pickresturnat = findViewById(R.id.btn_v_find);
        et_j_newresturant = findViewById(R.id.et_v_newRestaurant);
        txt_j_resturant = findViewById(R.id.txt_v_resturant);
        txt_j_resturant.setText("Hello");
        txt_j_errorNoResturant = findViewById(R.id.txt_v_Error);

        addResturantButtonEvent();
        pickResturantButtonEvent();



    }

    public void addResturantButtonEvent()
    {
        btn_j_addResturant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("Add","Add button pressed");
                //check to see if array full
                if(checkArrayFull()){
                    //something so use cant add resturnats
                    txt_j_errorNoResturant.setText("list is full. Click find resturant.");
                    txt_j_errorNoResturant.setVisibility(View.VISIBLE);
                }
                //if not full add place
                // value from edit text to and convert to string
                else {
                    //add to the array
                    if (!et_j_newresturant.getText().toString() .equals(""))
                    {
                        //add to array
                        resturant[count] = et_j_newresturant.getText().toString();
                        count++;
                        //clear text box
                        et_j_newresturant.setText("");
                        //make not visible
                        txt_j_errorNoResturant.setVisibility(View.INVISIBLE);

                    }
                    else {
                        //ERROR
                        txt_j_errorNoResturant.setVisibility(View.VISIBLE);
                    }
                }


            }

        });
    }

    public void pickResturantButtonEvent()
    {
        btn_j_pickresturnat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Pick","Pick button pressed");
                //displayResturants();
                randomPosition = (int) (Math.random() * count);
                //Log.d("random: ",randomPosition +"");
                txt_j_resturant.setText(resturant[randomPosition]);
            }
        });
    }
    public boolean checkArrayFull(){
        Log.d("length",resturant.length+"");

        if(count < 6){
            return false;
        }
        else {
            return true;
        }
    }
    public void displayResturants()
    {
        for(int i = 0; i < resturant.length; i++){
            if(resturant[i] != null)
            {
                Log.d("resturants",resturant[i]);
            }
        }
    }
}
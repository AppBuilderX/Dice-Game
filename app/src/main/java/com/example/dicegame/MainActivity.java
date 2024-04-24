package com.example.dicegame;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static Button button;
    public static TextView textWin;
    public static ImageView img1, img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final int dice[] = {R.drawable.dice1, R.drawable.dice2,
                            R.drawable.dice3, R.drawable.dice4,
                            R.drawable.dice5, R.drawable.dice6};

        button = findViewById(R.id.button);
        textWin = findViewById(R.id.text_win);
        img1 = findViewById(R.id.dice1);
        img2 = findViewById(R.id.dice2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random =new Random();
                int num1 = random.nextInt(6);
                Random random1 = new Random();
                int num2 = random1.nextInt(6);

                if (num1 > num2){
                    textWin.setText("Winner : Player 1");
                } else if (num1 < num2) {
                    textWin.setText("Winner : Player 2");
                }else {
                    textWin.setText("Result : Draw");
                }

                img1.setImageResource(dice[num1]);
                img2.setImageResource(dice[num2]);

            }
        });

    }
}
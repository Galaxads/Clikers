package com.example.cliker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button Wipe;
    TextView info;
    ImageView monetka;
    Button Deletmoney;
    Button Upmoney;
    Button buttonUpgrade;
    int money = 0;
    int clikc=1;
    int images[]={R.drawable.money,R.drawable._0rub,R.drawable.money1000,R.drawable.money5000,R.drawable.money50000};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        monetka=findViewById(R.id.monetka);
        info = findViewById(R.id.info); //отображение счета
        Upmoney = findViewById(R.id.Upmoney); //кнопка увеличения счета
        Deletmoney = findViewById(R.id.Deletmoney); //кнопка уменьшения счета
        buttonUpgrade = findViewById(R.id.buttonUpgrade); //кнопка улучшение
        Wipe = findViewById(R.id.Wipe); //кнопка сброса счета

        Upmoney.setOnClickListener(new View.OnClickListener() { //метод для увеличения счета
            @Override
            public void onClick(View v) {
                money+=clikc;

                info.setText(DeclinatedText(money), TextView.BufferType.EDITABLE);
                Imagecret(money);
            }
        });
        Deletmoney.setOnClickListener(new View.OnClickListener() { //метод для уменьшения счета
            @Override
            public void onClick(View v) {
                if (0<money) {
                    money--;
                    info.setText(DeclinatedText(money), TextView.BufferType.EDITABLE);
                    Imagecret(money);
                }
            }
        });
        Wipe.setOnClickListener(new View.OnClickListener() { //метод для обнуления
            @Override
            public void onClick(View v) {
                if (0<money) {
                    money=0;
                    info.setText(DeclinatedText(money), TextView.BufferType.EDITABLE);
                    Imagecret(money);
                }
            }
        });
        buttonUpgrade.setOnClickListener(new View.OnClickListener() { //метод для улучшения
            @Override
            public void onClick(View v) {

                    clikc++;
                    info.setText(DeclinatedText(money), TextView.BufferType.EDITABLE);
                    Imagecret(money);

            }
        });
    }

    private String DeclinatedText(int money) { //метод для склонения "раз" при отображения счета
        {
            String textRet = "Кнопка нажата " + String.valueOf(money) + " раз";
            money = money < 0 ? money * -1 : money; //получение модуля количества кликов
            char decimals = money < 10 ? '0' : String.valueOf(money).charAt(String.valueOf(money).length() - 2); //количество десятков. Необходимо для корректного склонения "раз" при значениях он 10-19
            char lastChar = String.valueOf(money).charAt(String.valueOf(money).length() - 1); //Последний символ. Определяет склонение "раз"
            if (decimals != '1') { //если количество десятков 10-19, то остается "раз"б иначе:
                switch (lastChar) {//при следующих значениях становится "раза"
                    case '2':
                    case '3':
                    case '4':
                        textRet += "а";
                        break;
                }
            }
            return textRet; //Возвращает готовую строку с правильным склонением
        }
    }
    private void Imagecret(int money) { //метод для смены фото
        {
            if (money<50)
            {
              monetka.setImageResource(R.drawable.money);
            }
            else if (50<=money && money<1000)
            {
                monetka.setImageResource(R.drawable._0rub);
            }
            else if (1000<=money && money<5000)
            {
                monetka.setImageResource(R.drawable.money1000);
            }
            else if (5000<=money && money<50000)
            {
                monetka.setImageResource(R.drawable.money5000);
            }
            else if (50000<=money)
            {
                monetka.setImageResource(R.drawable.money50000);
            }
        }
    }
}
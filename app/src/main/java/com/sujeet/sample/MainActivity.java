package com.sujeet.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sujeet.priceedittext.PercentageEditText;
import com.sujeet.priceedittext.PriceEditText;

public class MainActivity extends AppCompatActivity {

    private PriceEditText priceEditText;
    private PercentageEditText percentageEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        priceEditText=(PriceEditText)findViewById(R.id.price_edit_view);
        percentageEditText =(PercentageEditText)findViewById(R.id.percentage_edit_view);

        priceEditText.setCurrency("INR");
    }
}

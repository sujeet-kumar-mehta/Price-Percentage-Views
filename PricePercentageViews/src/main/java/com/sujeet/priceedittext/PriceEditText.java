package com.sujeet.priceedittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;

import java.util.regex.Pattern;


/**
 * Created by sujeetkumarmehta on 2/25/15.
 */
public class PriceEditText extends AppCompatEditText {

    private Context context;

    //Default currency is $
    private String mCurrency = "$";

    public PriceEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        applyAttributes(context, attrs);
        addTextChangedListener(textWatcher);
        this.context = context;
    }

    public PriceEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyAttributes(context, attrs);
        addTextChangedListener(textWatcher);
        this.context = context;


    }

    public PriceEditText(Context context) {
        super(context);
        this.context = context;
    }


    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        String current = "";

        @Override
        public void afterTextChanged(Editable s) {
            if (!s.toString().equals(current) && s.length() > 0) {
                removeTextChangedListener(this);
                String cleanString = s.toString().replaceAll(Pattern.quote(mCurrency), "");
                String finalText = mCurrency + cleanString;

                setText(finalText);
                setSelection(cleanString.length() + mCurrency.length());
                addTextChangedListener(this);
            }

        }
    };


    private void applyAttributes(Context context, AttributeSet attrs) {
        TypedArray styledAttributes = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView);
        mCurrency = styledAttributes.getString(R.styleable.CustomTextView_currency);

    }

    /**
     * Set currency from code
     * Default currency is $
     *
     * @param mCurrency
     */
    public void setCurrency(String mCurrency) {
        this.mCurrency = mCurrency;
    }

    /**
     * get currency
     *
     * @return mCurrency
     */
    public String getCurrency() {
        return mCurrency;
    }

    @Override
    public void setInputType(int type) {
        super.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
    }
}

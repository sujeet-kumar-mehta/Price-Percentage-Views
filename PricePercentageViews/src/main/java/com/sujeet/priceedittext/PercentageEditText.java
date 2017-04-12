package com.sujeet.priceedittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;



/**
 * Created by sujeetkumarmehta on 2/25/15.
 */
public class PercentageEditText extends AppCompatEditText {

    private Context context;

    public PercentageEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        applyAttributes(context, attrs);
        addTextChangedListener(textWatcher);
    }

    public PercentageEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyAttributes(context, attrs);
        addTextChangedListener(textWatcher);

    }

    public PercentageEditText(Context context) {
        super(context);
        this.context = context;
    }

    private void applyAttributes(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView);

    }

    TextWatcher textWatcher = new TextWatcher() {
        String current = "";

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (!s.toString().equals(current) && s.length() > 0) {
                removeTextChangedListener(this);

                String cleanString = s.toString().replaceAll("%", "");

                if (!cleanString.equals("")&&!cleanString.equals(".")&&cleanString.length()>0) {
                    Float parsed = Float.parseFloat(cleanString);
                    if (parsed > 100) {
                        cleanString = 100 + "";
                    }
                }


                current = cleanString;
                setText(cleanString + "%");
                setSelection(cleanString.length());

                addTextChangedListener(this);
            }


        }
    };

    @Override
    public void setInputType(int type) {
        super.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
    }
}

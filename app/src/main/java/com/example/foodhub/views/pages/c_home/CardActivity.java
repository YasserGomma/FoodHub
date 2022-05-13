package com.example.foodhub.views.pages.c_home;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodhub.R;
import com.example.foodhub.views.components.InputField;
import com.maxpilotto.creditcardview.CreditCardView;

public class CardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        CreditCardView card=findViewById(R.id.card);
        card.setFlipOnEdit(true);
        card.setFlipOnClick(true);

        InputField add_card_name=findViewById(R.id.add_card_name);
        EditText name=add_card_name.findViewById(R.id.input_field_edit_text);
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                card.setHolder(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        InputField add_card_number=findViewById(R.id.add_card_number);
        EditText number=add_card_number.findViewById(R.id.input_field_edit_text);
        number.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                card.setNumber(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        InputField add_card_cvv=findViewById(R.id.add_card_cvv);
        EditText cvv=add_card_cvv.findViewById(R.id.input_field_edit_text);
        cvv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                card.setCvv(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        InputField add_card_exp=findViewById(R.id.add_card_exp);
        EditText exp=add_card_exp.findViewById(R.id.input_field_edit_text);
        exp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                card.setExpiry(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}
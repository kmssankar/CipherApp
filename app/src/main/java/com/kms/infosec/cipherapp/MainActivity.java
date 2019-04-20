package com.kms.infosec.cipherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText keyInput, TextInput,textOutput;
    TextView messageOut,outlabel;
    Button buttonCipher, buttonDecipher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        keyInput = (EditText) findViewById(R.id.keyInput);
        TextInput = (EditText) findViewById(R.id.text_view);
        textOutput =(EditText) findViewById(R.id.textOut);
        messageOut =(TextView) findViewById(R.id.msg_out);
        buttonCipher = (Button) findViewById(R.id.encode_button);
        buttonDecipher = (Button)findViewById(R.id.decode_button);
        outlabel = (TextView) findViewById(R.id.outlabel);

        buttonCipher.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String key = keyInput.getText().toString();
                String inputText = TextInput.getText().toString();
                if(key.length() <1){
                    messageOut.setText("Invalid Key Provided ! Retry with Key".toUpperCase());
                    textOutput.setText("Cannot Cipher as Input is invalid".toUpperCase() );
                    outlabel.setText("CIPHERED TEXT:");
                }
                else if(inputText.length() <1){
                    messageOut.setText("Invalid Text Provided ! Retry with Text".toUpperCase());
                    textOutput.setText("Cannot Cipher as Input is invalid".toUpperCase() );
                    outlabel.setText("CIPHERED TEXT:");
                }
                else{
                    CipherHelper cipherHelper= new CipherHelper(key);
                    messageOut.setText("Ciphered with Key : ".toUpperCase() + key.toUpperCase());
                    textOutput.setText(cipherHelper.doCipher(inputText));
                    outlabel.setText("CIPHERED TEXT:");
                }


            }
        });

        buttonDecipher.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String key = keyInput.getText().toString();
                String inputText = TextInput.getText().toString();
                if(key.length() <1){
                    messageOut.setText("INVALID KEY PROVIDED ! RETRY WITH KEY");
                    textOutput.setText("Cannot Decipher as Input is invalid".toUpperCase()  );
                    outlabel.setText("DECIPHERED TEXT:");
                }
                else if(inputText.length() <1){
                    messageOut.setText("INVALID TEXT PROVIDED ! RETRY WITH TEXT");
                    textOutput.setText("Cannot DeCipher as Input is invalid".toUpperCase() );
                    outlabel.setText("DECIPHERED TEXT:");
                }
                else{
                    CipherHelper cipherHelper= new CipherHelper(key);
                    messageOut.setText("DeCiphered with Key : ".toUpperCase() + key.toUpperCase());
                    textOutput.setText(cipherHelper.doDecipher(inputText));
                    outlabel.setText("DECIPHERED TEXT:");
                }
            }
        });

    }
}

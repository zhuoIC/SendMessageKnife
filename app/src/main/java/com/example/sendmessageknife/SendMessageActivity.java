package com.example.sendmessageknife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sendmessageknife.pojo.Message;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Esta clase envía un mensaje de un usuario a otro
 * @author Nicolás Hernández Jiménez
 * <p>Conceptos aprendidos:</p>
 * <url>
 *     <li>Concepto Context</li>
 *     <li>Paso de parámetros mediante  el objeto @see android.os.Bundle</li>
 *     <li>Paso de mensajes entre dos actividades mediante la clase @see android.content.Intent</li>
 * </url>
 */

public class SendMessageActivity extends AppCompatActivity {

    @BindView(R.id.edtMessage)
    EditText edtMessage;
    @BindView(R.id.edtUser)
    EditText edtUser;
    @BindView(R.id.btnOK)
    Button btnButton;

    private static final String TAG = "com.example.sendmessage";
    private com.example.sendmessageknife.pojo.Message mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        //Vincular el ide de las vistas en el XMl con las clases View
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "SendMessage: onStart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "SendMessage: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "SendMessage: onStop()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "SendMessage: OnResume()");
    }


    /*
        class MyListener implements View.OnClickListener{
            public void onClick(){

            }
        }*/

    @OnClick(R.id.btnOK)
    public void getOnClick(View view) {
        switch (view.getId()) {
            case R.id.btnOK:
                //1. Recoger el mensaje
                //2. Crear un objeto Bundle y añadir el mensaje
                Bundle bundle = new Bundle();
                bundle.putSerializable("message", new Message(edtMessage.getText().toString(), edtUser.getText().toString()));
                //3. Crear un objeto Intent
                Intent intent = new Intent(SendMessageActivity.this, ViewMessageActivity.class);
                //4. Añadir el Bundle al Intent
                intent.putExtras(bundle);
                //5. Iniciar la Activity ViewMessage
                startActivity(intent);
                break;
        }
    }
}

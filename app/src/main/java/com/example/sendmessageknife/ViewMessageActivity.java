package com.example.sendmessageknife;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.sendmessageknife.pojo.Message;

/**
 * Esta clase recibe un mensaje de un usuario y se muestra en pantalla
 * @author Nicolás Hernández Jiménez
 *
 */


public class ViewMessageActivity extends AppCompatActivity {
    private Message mensaje;
    private TextView txvViewMessage;
    private TextView txvViewUser;
    private static final String TAG = "com.example.sendmessage";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_message);
        txvViewMessage = (TextView) findViewById(R.id.txvViewMessage);
        txvViewUser = (TextView) findViewById(R.id.txvViewUser);
        // 1. Recoger el Intent que se ha enviado
        //Intent intent = getIntent();
        // 2. Recoger el mensaje del Bundle
        //Bundle bundle = intent.getExtras();
        // 3. Muestra el usuario origen
        mensaje = (com.example.sendmessageknife.pojo.Message) getIntent().getExtras().getSerializable("message");
        String viewUser = String.format(getResources().getString(R.string.txvViewUser), mensaje.getUser().toString());
        txvViewUser.setText(viewUser);
        // 4. Mostrar el mensaje
        txvViewMessage.setText(mensaje.getMessage().toString());

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "ViewMessage: onStart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "ViewMessage: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "ViewMessage: onStop()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "ViewMessage: OnResume()");
    }

}

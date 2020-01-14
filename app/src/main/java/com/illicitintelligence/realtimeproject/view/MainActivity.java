package com.illicitintelligence.realtimeproject.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.database.Observable;
import android.os.Bundle;
import android.util.Log;

import com.illicitintelligence.realtimeproject.R;
import com.illicitintelligence.realtimeproject.model.Message;
import com.illicitintelligence.realtimeproject.viewmodel.RealViewModel;

public class MainActivity extends AppCompatActivity {

    private RealViewModel rViewModel;

    private Observer<Message> realMessageObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rViewModel = ViewModelProviders.of(this).get(RealViewModel.class);

        realMessageObserver = new Observer<Message>() {
            @Override
            public void onChanged(Message o) {
                Log.d("TAG_X", "OnChanged has been called");
                logMessage(o);
            }
        };

        rViewModel.getMessageMutableLiveData().observe(this, realMessageObserver);

        Message x = new Message();
        x.setMessageTitle("Title");
        x.setMessageDate("14/1/2020");
        x.setUsername("ispooner");
        x.setMessageContent("This is a message for testing purposes only");
        rViewModel.sendRealMessage(x);
    }

    private void logMessage(Message message) {
        Log.d("TAG_L", "Messsage: " + message.getMessageContent());
    }
}

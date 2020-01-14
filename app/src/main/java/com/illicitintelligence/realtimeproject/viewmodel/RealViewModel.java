package com.illicitintelligence.realtimeproject.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.illicitintelligence.realtimeproject.model.Message;
import com.illicitintelligence.realtimeproject.util.Constants;

public class RealViewModel extends AndroidViewModel {

    private DatabaseReference messageReference;

    private MutableLiveData<Message> messageMutableLiveData = new MutableLiveData<>();

    public RealViewModel(@NonNull Application application) {
        super(application);

        messageReference = FirebaseDatabase.getInstance().getReference(Constants.DATABASE_PATH);

        messageReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d("TAG_DATA", "The data has changed");
                for(DataSnapshot current : dataSnapshot.getChildren()) {

                    //String thing = current.toString();

                    Message mess = current.getValue(Message.class);

                    messageMutableLiveData.postValue(mess);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Show me that error
            }
        });
    }

    public MutableLiveData<Message> getMessageMutableLiveData() {
        return messageMutableLiveData;
    }

    public void sendRealMessage(Message message) {
        String childKey = messageReference.push().getKey();
        if(childKey != null) {
            messageReference.child(childKey).setValue(message);
        }
    }
}

package com.illicitintelligence.realtimeproject.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.*
import com.illicitintelligence.realtimeproject.model.Error
import com.illicitintelligence.realtimeproject.model.Message
import com.illicitintelligence.realtimeproject.util.DATABASE_PATH

class RealViewModelK(application: Application) : AndroidViewModel(application) {

    private var messageReference : DatabaseReference = FirebaseDatabase.getInstance().getReference(DATABASE_PATH)

    private var messageMutable = MutableLiveData<List<Message>>()
    private var errorMutable = MutableLiveData<Error>()

    init {
        messageReference.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                errorMutable.postValue(Error("Firebase", "The call was cancelled"))
            }

            override fun onDataChange(p0: DataSnapshot) {
                if(!p0.hasChildren()) {
                    errorMutable.postValue(Error("Firebase", "The object is empty"))
                }
                else {
                    val messages: List<Message> = p0.children.map { it?.getValue(Message::class.java) ?: Message()}
                    messageMutable.postValue(messages)
                }
            }

        })

    }

    fun sendRealMessage(message: Message) {
        val childKey = messageReference.push().key
        if(childKey != null) {
            messageReference.child(childKey).setValue(message)
        }
    }

    fun getMessageMutable() : MutableLiveData<List<Message>> {
        return messageMutable
    }

    fun getErrorMutable() : MutableLiveData<Error> {
        return errorMutable
    }

}
package com.illicitintelligence.realtimeproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.illicitintelligence.realtimeproject.R
import com.illicitintelligence.realtimeproject.adapter.MessageRVAdapter
import com.illicitintelligence.realtimeproject.model.Error
import com.illicitintelligence.realtimeproject.model.Message
import com.illicitintelligence.realtimeproject.viewmodel.RealViewModel
import com.illicitintelligence.realtimeproject.viewmodel.RealViewModelK
import kotlinx.android.synthetic.main.activity_main_k.*

class MainKActivity : AppCompatActivity() {

    lateinit var realViewModel : RealViewModelK

    lateinit var messages: Observer<List<Message>>
    lateinit var error : Observer<Error>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_k)

        realViewModel = ViewModelProviders.of(this).get(RealViewModelK::class.java)

        messages = Observer {
            setupRV(it)
        }

        error = Observer {
            toastError(it)
        }

        realViewModel.getMessageMutable().observe(this, messages)
        realViewModel.getErrorMutable().observe(this, error)

        main_send_button.setOnClickListener { v ->
            val x : Message = Message()
            x.messageTitle = "yep"
            x.username = "username"
            x.messageDate = "This is a date"
            x.messageContent = main_message_editText.text!!.trim().toString()
            realViewModel.sendRealMessage(x)
            main_message_editText.text?.clear()
        }

    }

    fun setupRV(mess : List<Message>) {
        //Setup the RecyclerView
        Log.d("Tag_F", "In setupRV")
        main_message_viewer.adapter = MessageRVAdapter(mess)
        main_message_viewer.layoutManager = LinearLayoutManager(this)
    }

    fun toastError(error: Error) {
        Toast.makeText(this, error.type + ": " + error.message, Toast.LENGTH_SHORT).show()
    }
}


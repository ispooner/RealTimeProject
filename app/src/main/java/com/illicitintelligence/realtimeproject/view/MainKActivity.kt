package com.illicitintelligence.realtimeproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.illicitintelligence.realtimeproject.R
import com.illicitintelligence.realtimeproject.model.Error
import com.illicitintelligence.realtimeproject.model.Message
import com.illicitintelligence.realtimeproject.viewmodel.RealViewModel
import com.illicitintelligence.realtimeproject.viewmodel.RealViewModelK

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

    }

    fun setupRV(mess : List<Message>) {
        //Setup the RecyclerView
    }

    fun toastError(error: Error) {
        Toast.makeText(this, error.type + ": " + error.message, Toast.LENGTH_SHORT).show()
    }
}


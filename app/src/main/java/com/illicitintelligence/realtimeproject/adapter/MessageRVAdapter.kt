package com.illicitintelligence.realtimeproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.illicitintelligence.realtimeproject.R
import com.illicitintelligence.realtimeproject.model.Message
import kotlinx.android.synthetic.main.message_layout.view.*

class MessageRVAdapter(var messages : List<Message>) : RecyclerView.Adapter<MessageRVAdapter.MessageViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.message_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return messages.size
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.itemview.message_title_textView.text = messages[position].messageTitle
        holder.itemview.message_date_textView.text = messages[position].messageDate
        holder.itemview.message_username_textView.text = messages[position].username
        holder.itemview.message_content_textView.text = messages[position].messageContent
    }


    class MessageViewHolder(var itemview : View) : RecyclerView.ViewHolder(itemview) {

    }

}
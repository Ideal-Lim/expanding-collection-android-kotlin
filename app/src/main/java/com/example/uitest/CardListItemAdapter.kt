package com.example.uitest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.uitest.databinding.ListItemBinding
import com.ramotion.expandingcollection.ECCardContentListItemAdapter

class CardListItemAdapter(context: Context, objects: List<String> ): ECCardContentListItemAdapter<String>(context, R.layout.list_item, objects){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var rowView = convertView
        var viewHolder = ViewHolder()

        if (rowView == null){
            val inflater = LayoutInflater.from(context)
            rowView = inflater.inflate(R.layout.list_item, null)

            viewHolder.itemText = rowView.findViewById(R.id.list_item_text)
            rowView.tag = viewHolder
        } else {
            viewHolder = rowView.tag as ViewHolder
        }

        val item = getItem(position)
        if (item != null){
            viewHolder.itemText.text = item
        }

        viewHolder.itemText!!.setOnClickListener{
            val tapToRemoveText: String = "Tap again to remove!"
            val view: TextView = it as TextView
            if (view.text.equals(tapToRemoveText)){
                it.setBackgroundColor(ContextCompat.getColor(it.context, R.color.design_default_color_primary))
                remove(item)
                notifyDataSetChanged()
            } else {
                view.text = tapToRemoveText
                it.setBackgroundColor(ContextCompat.getColor(it.context, R.color.colorAccent))
            }
        }
        return rowView!!
    }
}

class ViewHolder {
    lateinit var itemText: TextView
}
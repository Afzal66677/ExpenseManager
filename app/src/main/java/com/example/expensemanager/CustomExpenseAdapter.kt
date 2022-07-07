package com.example.expensemanager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CustomExpenseAdapter (private val context: Context, private val expenses:  MutableList<Expense>):BaseAdapter(){

    private val inflater: LayoutInflater = this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val dataItem = expenses[p0]

        var view: View
        if(p1 == null) {
            view = inflater.inflate(R.layout.list_item, p2, false)
            view.tag = ViewHolder(view)
        } else {
            view = p1
        }

        val viewHolder = view.tag as ViewHolder
        viewHolder.itemName.text = dataItem.item
        viewHolder.price.text = dataItem.getFormattedPrice()

        return view
    }
    override fun getCount(): Int = expenses.size
    override fun getItem(p0: Int): Any = expenses[p0]
    override fun getItemId(p0: Int): Long  = p0.toLong()



    class ViewHolder(view: View){
        val itemName: TextView = view.findViewById(R.id.item_name)
        val price: TextView = view.findViewById(R.id.price)
    }
}
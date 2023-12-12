package com.myhh207644.primenumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import java.lang.Integer.max
import java.lang.Integer.min

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editNumber1 = findViewById<EditText>(R.id.edit_number_1)
        val editNumber2 = findViewById<EditText>(R.id.edit_number_2)
        val listView = findViewById<ListView>(R.id.list_view)
        val textNoResult = findViewById<TextView>(R.id.text_no_result)

        findViewById<Button>(R.id.button_show).setOnClickListener {
            val number1 = editNumber1.text.toString().toInt();
            val number2 = editNumber2.text.toString().toInt();
            val max = max(number1, number2)
            val min = min(number1, number2)
            val items = arrayListOf<Int>()
            for (i in min..max)
                if (checkPrime(i)) items.add(i)
            if (items.size > 0) {
                listView.visibility = View.VISIBLE
                textNoResult.visibility = View.GONE
                listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,items)
            } else {
                listView.visibility = View.GONE
                textNoResult.visibility = View.VISIBLE
            }

        }
    }

    fun checkPrime(n: Int): Boolean {
        if (n < 2) return false
        for (i in 2..n/2)
            if (n % i == 0) return false
        return true
    }
}
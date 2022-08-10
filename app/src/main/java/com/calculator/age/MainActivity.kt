package com.calculator.age

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private var tvSelectedDate: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val datePickerBtn: Button = findViewById(R.id.date_picker_btn)
        tvSelectedDate = findViewById(R.id.selected_date)

        datePickerBtn.setOnClickListener {
            clickDatePicker()
        }
    }

    private fun clickDatePicker() {

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDayOfMonth ->
            Toast.makeText(this, "Year $selectedYear, Month ${selectedMonth + 1}, Day $selectedDayOfMonth", Toast.LENGTH_LONG).show()

            val dateText = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"
            tvSelectedDate?.text = dateText

            val format = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val date = format.parse(dateText)
            // TODO calculate date in minutes
            // TODO set text view of minutes
        }, year, month, day).show()
    }
}
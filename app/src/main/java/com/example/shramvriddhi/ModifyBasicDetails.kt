package com.example.shramvriddhi

import android.app.DatePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.shramvriddhi.databinding.ActivityModifyBasicDetailsBinding
import java.text.SimpleDateFormat
import java.util.*

class ModifyBasicDetails : AppCompatActivity() {
    private lateinit var binding : ActivityModifyBasicDetailsBinding
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityModifyBasicDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val myCalendar2 = Calendar.getInstance()

        val datePicker2 = DatePickerDialog.OnDateSetListener { view, year1, month1, dayOfMonth1 ->
            myCalendar2.set(Calendar.YEAR,year1)
            myCalendar2.set(Calendar.MONTH, month1)
            myCalendar2.set(Calendar.DAY_OF_MONTH,dayOfMonth1)
            updateLable2(myCalendar2)
        }


        binding.textView154.setOnClickListener{
            DatePickerDialog(this,datePicker2, myCalendar2.get(Calendar.YEAR),
                myCalendar2.get(Calendar.MONTH),myCalendar2.get(Calendar.DAY_OF_MONTH)).show()
        }










        binding.ivBackModifyDetails3.setOnClickListener {
            finish()
        }

        binding.btnSubmitbasicDetails.setOnClickListener{
            val i = Intent(this,ModifyBasicDetailsDone::class.java).also {
                startActivity(it)
            }
         }



     }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun updateLable2(myCalendar: Calendar?) {
        val myFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        if (myCalendar != null) {
            binding.textView154.text = sdf.format(myCalendar.time)
        }
    }
}

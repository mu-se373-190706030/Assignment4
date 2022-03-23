package xyz.scoca.assignment4


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import xyz.scoca.assignment4.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding  //ViewBinding for interact with views.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnChooseAge.setOnClickListener {
            binding.tvAge.text = getDateAndTime()  //choose date after button clicked.
        }
    }

    private fun getDateAndTime() :String{  //Get date(day,month,year) data from date picker widget.
        val day = binding.datePicker.dayOfMonth
        val month = binding.datePicker.month
        val year = binding.datePicker.year

        val calendar = Calendar.getInstance()   // create calendar instance and set with date data.
        calendar.set(year,month,day)
        return setDateAndTime(calendar.timeInMillis)
    }

    private fun setDateAndTime(time : Long) : String{   //format the given data.
        val date = Date(time)
        val dateFormat = android.text.format.DateFormat.getLongDateFormat(this)

        return dateFormat.format(date)
    }
}
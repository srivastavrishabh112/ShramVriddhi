package com.example.shramvriddhi.ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.shramvriddhi.R
import com.example.shramvriddhi.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val firstFragment = HomeFragment()
        val secondFragment = PassbookFragment()
        val thirdFragment = WithdrawalFragment()
        val fourthFragment = MailFragment()
        val fifthFragment = ProfileFragment()

        setCurrentFragment(firstFragment)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId)  {
                R.id.miHome -> setCurrentFragment(firstFragment)
                R.id.miPassbook -> setCurrentFragment(secondFragment)
                R.id.miWithdraw -> setCurrentFragment(thirdFragment)
                R.id.miMails -> setCurrentFragment(fourthFragment)
                R.id.miProfile -> setCurrentFragment(fifthFragment)
            }
            true
        }
         binding.bottomNavigationView.getOrCreateBadge(R.id.miMails).apply {
             number = 2
             isVisible=true
         }
    }

 private fun setCurrentFragment(fragment: Fragment) =
     supportFragmentManager.beginTransaction().apply {
         replace(R.id.flfragment,fragment)
         commit()
     }


}
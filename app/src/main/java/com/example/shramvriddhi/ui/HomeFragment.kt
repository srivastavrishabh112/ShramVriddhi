package com.example.shramvriddhi.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.shramvriddhi.R
import com.example.shramvriddhi.ViewPagerAdapter
import com.example.shramvriddhi.adapter.dykAdapter
import com.example.shramvriddhi.data.DykDataSource
import com.example.shramvriddhi.databinding.FragmentHomeBinding


class HomeFragment : Fragment(R.layout.fragment_home){

    private var _binding: FragmentHomeBinding? = null


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)


        val myDataset = DykDataSource().loadDyk()
        val recyclerView = binding.recyclerViewHome

        recyclerView.adapter = dykAdapter(this@HomeFragment.requireContext(),myDataset)
        recyclerView.setHasFixedSize(true)

        return binding.root


    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


            binding.btn23.setOnClickListener{
                Intent(this@HomeFragment.requireContext(), BotActivity::class.java).also{
                    startActivity(it)
                }
            }





//             binding.ivHome7.setOnClickListener{
//                  val i = Intent(this@HomeFragment.requireContext(), DykActivity1::class.java).also {
//                      startActivity(it)
//                  }
//              }

//             binding.ivHome8.setOnClickListener{
//                 val u = Intent(this@HomeFragment.requireContext(), DykActicvity2::class.java).also {
//                       startActivity(it)
//                 }
//             }




        val images = listOf(
            R.drawable.bannerfirst,
            R.drawable.bannersecond,
            R.drawable.bannerthird,
            R.drawable.bannerfourth,
            R.drawable.bannerfifth,
            R.drawable.bannersixth,
            R.drawable.bannerseventh,
            R.drawable.bannereigth,
            R.drawable.bannerninth,
            R.drawable.bannertenth,
            R.drawable.bannereleventhj
        )


        val adapter =  ViewPagerAdapter(images)
        binding.bannerPager.adapter= adapter




       binding.bannerPager.beginFakeDrag()
        binding.bannerPager.fakeDragBy(-6f)
        binding.bannerPager.endFakeDrag()

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }




    }

package com.example.shramvriddhi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.shramvriddhi.R
import com.example.shramvriddhi.databinding.FragmentMailBinding


class MailFragment : Fragment(R.layout.fragment_mail){
    private var _binding: FragmentMailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMailBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       binding.textView123.setOnClickListener{
           binding.clInclude.visibility = View.VISIBLE
           binding.textView93.setTextColor(resources.getColor(R.color.blue))
       }

        binding.textView93.setOnClickListener{
            binding.clInclude.visibility = View.INVISIBLE
         }
    }


}
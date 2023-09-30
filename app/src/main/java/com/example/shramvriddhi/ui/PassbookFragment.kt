package com.example.shramvriddhi.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.shramvriddhi.R
import com.example.shramvriddhi.databinding.FragmentPassbookBinding


class PassbookFragment : Fragment(R.layout.fragment_passbook) {
    private var _binding: FragmentPassbookBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPassbookBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.textView13.setOnClickListener{
            val i = Intent(this@PassbookFragment.requireContext(), PassbookActivity2::class.java).also {
                startActivity(it)
            }
        }

        binding.textView12.setOnClickListener{
            val j = Intent(this@PassbookFragment.requireContext(), ClaimStatus::class.java).also {
                startActivity(it)
            }
        }
    }
}
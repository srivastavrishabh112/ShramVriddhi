package com.example.shramvriddhi.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.shramvriddhi.R
import com.example.shramvriddhi.databinding.FragmentWithdrawalBinding

class WithdrawalFragment : Fragment(R.layout.fragment_withdrawal) {

    private var _binding: FragmentWithdrawalBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentWithdrawalBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonClaimVerify.setOnClickListener{
            val i = Intent(this@WithdrawalFragment.requireContext(), RaiseClaim::class.java).also{
                startActivity(it)
            }
        }
    }
}
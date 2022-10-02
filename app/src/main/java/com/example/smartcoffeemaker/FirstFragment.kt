package com.example.smartcoffeemaker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.smartcoffeemaker.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
@AndroidEntryPoint
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val viewModel: FirstFragmentViewModel by viewModels()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        initViewModel()


        return binding.root
    }

    private fun initViewModel() {
        viewModel.users.observe(viewLifecycleOwner) {
            binding.userTextView.text = "Hello ${it.username}!"
        }
        viewModel.isLedTurnedOn.observe(viewLifecycleOwner) {
            binding.ledStateTextView.text = "Led is turned ${if (it) "on" else "off"}"
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            viewModel.getUserData()
            viewModel.getLedState()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.example.viewmodel_ny

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController

class FragmentA : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemCount = view.findViewById<TextView>(R.id.itemCount)
        val updateButton = view.findViewById<Button>(R.id.updateButton)
        val navigateButton = view.findViewById<Button>(R.id.navigateButton)

        sharedViewModel.itemCount.observe(viewLifecycleOwner) { count ->
            itemCount.text = "Selected Count: $count"
        }

        updateButton.setOnClickListener {
            sharedViewModel.updateItemCount()
        }

        navigateButton.setOnClickListener {
            findNavController().navigate(R.id.fragmentB)
        }
    }

}
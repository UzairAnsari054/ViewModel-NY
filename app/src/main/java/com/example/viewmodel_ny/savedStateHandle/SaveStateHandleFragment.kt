package com.example.viewmodel_ny.savedStateHandle

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.navGraphViewModels
import com.example.viewmodel_ny.R
import com.example.viewmodel_ny.SharedViewModel

class SaveStateHandleFragment : Fragment() {

    private val saveStateHandleViewModel: SaveStateHandleViewModel by navGraphViewModels(R.id.mobile_navigation)
//    private val saveStateHandleViewModel: SharedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("SaveStateHandleFragment", "onCreateView Called")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_save_state_handle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("SaveStateHandleFragment", "onViewCreated Called")

        val nameEd = view.findViewById<EditText>(R.id.name_ed)
        val ageEd = view.findViewById<EditText>(R.id.age_ed)
        val saveBtn = view.findViewById<Button>(R.id.saveBtn)

        Log.d("SaveStateHandleFragment", "Retrieved Name: ${saveStateHandleViewModel.name}")
        Log.d("SaveStateHandleFragment", "Retrieved Age: ${saveStateHandleViewModel.age}")

        saveStateHandleViewModel.name?.let {
            nameEd.setText(it)
        }
        saveStateHandleViewModel.age?.let {
            ageEd.setText(it.toString())
        }

        saveBtn.setOnClickListener{
            val name = nameEd.text.toString()
            val age = ageEd.text.toString().toIntOrNull()
            saveStateHandleViewModel.name = name
            saveStateHandleViewModel.age = age

            Log.d("SaveStateHandleFragment", "Saved Name: $name")
            Log.d("SaveStateHandleFragment", "Saved Age: $age")


            Toast.makeText(activity, "Data Saved", Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("SaveStateHandleFragment", "onDestroyView Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SaveStateHandleFragment", "onDestroy Called")
    }
}
package com.example.mymoveapplication.ui.main


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.Observer
import com.example.mymoveapplication.R
import kotlinx.android.synthetic.main.fragment_dialog.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class CustomDialogFragment : DialogFragment(R.layout.fragment_dialog) {

    private val viewModel: CustomDialogViewModel by viewModel<CustomDialogViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_dialog, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnCancel.setOnClickListener {
            dismiss()
            Toast.makeText(requireContext(), "Dialog Cancel", 1).show()
        }
        btnAdd.setOnClickListener {
            val result = tvNoteEditText.text.toString()
            // Use the Kotlin extension in the fragment-ktx artifact

            setFragmentResult(KEY_REQUEST, bundleOf(KEY_BUNDLE to result))
            dismiss()
            Toast.makeText(requireContext(), "Send Data", 1).show()


        }

    }


    companion object {
        const val KEY_BUNDLE = "KEY_BUNDLE"
        const val KEY_REQUEST = "KEY_REQUEST"
        const val SAVE_SHARED = "SAVE_SHARED"
        const val KEY_SHARED = "KEY_SHARED"
    }
}

package com.example.movies.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.movies.R
import com.example.movies.ui.viewmodels.EXViewModel

class EXFragment : Fragment() {

    companion object {
        fun newInstance() = EXFragment()
    }

    private lateinit var viewModel: EXViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.e_x_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EXViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
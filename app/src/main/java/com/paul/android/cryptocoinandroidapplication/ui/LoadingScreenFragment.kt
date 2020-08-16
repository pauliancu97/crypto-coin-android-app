package com.paul.android.cryptocoinandroidapplication.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.paul.android.cryptocoinandroidapplication.MainActivity
import com.paul.android.cryptocoinandroidapplication.R
import com.paul.android.cryptocoinandroidapplication.databinding.FragmentLoadingScreenBinding
import javax.inject.Inject

class LoadingScreenFragment : Fragment() {

    @Inject
    lateinit var loadingScreenViewModelFactory: LoadingScreenViewModelFactory

    private val viewModel: LoadingScreenViewModel by viewModels {
        loadingScreenViewModelFactory.create()
    }

    private lateinit var views: FragmentLoadingScreenBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity() as MainActivity).applicationComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        views = FragmentLoadingScreenBinding.inflate(inflater, container, false)
        return views.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.isLoaded().observe(
            viewLifecycleOwner,
            Observer { isLoaded ->
                if(isLoaded){
                    findNavController().navigate(R.id.action_loadingScreenFragment_to_currenciesFragment)
                }
            }
        )
    }
}
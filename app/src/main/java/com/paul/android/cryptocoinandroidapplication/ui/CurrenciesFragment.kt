package com.paul.android.cryptocoinandroidapplication.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.paul.android.cryptocoinandroidapplication.MainActivity
import com.paul.android.cryptocoinandroidapplication.R
import com.paul.android.cryptocoinandroidapplication.databinding.FragmentCurrenciesBinding
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class CurrenciesFragment : Fragment() {

    @Inject
    lateinit var currenciesFragmentViewModelFactory: CurrencyFragmentViewModelFactory

    private val viewModel: CurrenciesFragmentViewModel by viewModels {
        currenciesFragmentViewModelFactory.create()
    }

    private lateinit var views: FragmentCurrenciesBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity() as MainActivity).applicationComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        views = FragmentCurrenciesBinding.inflate(inflater, container, false)
        return views.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCurrencies().observe(
            viewLifecycleOwner,
            Observer { currencies ->
                views.mainText.text = currencies.joinToString(separator = "\n")
            }
        )
    }
}
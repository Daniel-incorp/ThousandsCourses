package com.example.feature_main.ui.account

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.feature_main.R
import com.example.feature_main.viewmodel.AccountViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class AccountFragment : Fragment(R.layout.fragment_account) {

    private val viewModel: AccountViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val tvMessage = view.findViewById<TextView>(R.id.tvAccountMessage)

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.message.collect { message ->
                tvMessage.text = message
            }
        }
    }
}

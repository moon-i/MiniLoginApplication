package com.study.miniloginapplication.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.study.miniloginapplication.R
import com.study.miniloginapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = MainAdapter()

    private val mainViewModel: MainViewModel by viewModels {
        ViewModelFactory.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
        binding.viewModel = mainViewModel
        binding.lifecycleOwner = this
        binding.recyclerView.adapter = adapter

        CoroutineScope(Dispatchers.Main).launch {
            setObserver()
            binding.progressBar.visibility = View.VISIBLE
            mainViewModel.getUserList(LIST_COUNT)
        }
    }

    private fun setObserver() {
        mainViewModel.userList.observe(this) { userList ->
            with(adapter) {
                list.clear()
                list.addAll(userList)
                notifyDataSetChanged()

                if (list.size > 0) {
                    binding.progressBar.visibility = View.GONE
                } else {
                    binding.progressBar.visibility = View.VISIBLE
                }
            }
        }
    }

    companion object {
        const val LIST_COUNT = 10
    }
}

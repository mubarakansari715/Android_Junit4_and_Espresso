package com.mubarak.android_junit_and_espresso

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.mubarak.android_junit_and_espresso.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding
    private val binding get() = _binding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.viewmodel = mainViewModel
        setUpSnackbar()
        setUpHideKeyBoard()


        mainViewModel.loginClick?.observe(this) {
            showSnackbar("Login Successfully")
        }


    }

    private fun setUpSnackbar() {
        mainViewModel.getSnakeBarMessage()?.observe(this, Observer { o: Any ->
            if (this != null) {
                if (o is Int) {
                    this?.resources?.getString(o)?.let { showSnackbar(it) }!!
                } else if (o is String) {
                    showSnackbar(o)
                }
            }

        } as Observer<Any>)
    }

    fun showSnackbar(message: String) {
        val snackbar = Snackbar.make(
            this?.findViewById(android.R.id.content)!!,
            message,
            Snackbar.LENGTH_SHORT
        )
        val view = snackbar.view
        val snackTV = view.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
        snackTV.maxLines = 5
//        snackTV.setTextColor(ContextCompat.getColor(this, android.R.color.white))
        snackbar.show()
    }

    private fun setUpHideKeyBoard() =
        mainViewModel.getHideKeyBoardEvent().observe(this, { hideKeyboard() })

    fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}
package com.mubarak.android_junit_and_espresso

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mubarak.android_junit_and_espresso.utils.Validation

class MainViewModel : ViewModel() {

    var email = MutableLiveData<String>()
    var password = MutableLiveData<String>()
    var loginClick: SingleLiveEvent<Boolean>? = SingleLiveEvent()
    private var snackBarMessage = MutableLiveData<Any>()
    private var hideKeyBoardEvent = MutableLiveData<Any>()

    fun onLoginClick() {
        hideKeyboard()

        when {
            !Validation.isNotNull(
                email.value.toString().trim()
            ) && !Validation.isNotNull(password.value.toString().trim()) -> {
                showSnackbarMessage("Please Enter Email/Password")
            }
            !Validation.isNotNull(email.value.toString().trim()) -> {
                showSnackbarMessage("Please Enter Email")
            }
            !Validation.isNotNull(password.value.toString().trim()) -> {
                showSnackbarMessage("Please Enter Password")
            }
            else -> {
                loginClick?.call()

            }
        }
    }

    fun getSnakeBarMessage(): MutableLiveData<Any> {
        return snackBarMessage
    }

    fun showSnackbarMessage(message: Any) {
        snackBarMessage.value = message
    }

    fun getHideKeyBoardEvent(): MutableLiveData<Any> {
        return hideKeyBoardEvent
    }

    fun hideKeyboard() {
        getHideKeyBoardEvent().value = true
    }
}
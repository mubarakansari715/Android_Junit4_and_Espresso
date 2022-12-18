package com.mubarak.android_junit_and_espresso.utils

import android.text.TextUtils
import android.util.Patterns
import java.util.regex.Pattern

object Validation {

    /**
     * method is used for checking if string is empty or not.
     *
     * @param mString as String
     * @return boolean true if [mString] is notnull.
     */
    fun isNotNull(mString: String?): Boolean {
        return when {
            mString == null -> {
                false
            }
            mString.equals("", ignoreCase = true) -> {
                false
            }
            mString.equals("N/A", ignoreCase = true) -> {
                false
            }
            mString.equals("[]", ignoreCase = true) -> {
                false
            }
            mString.equals("null", ignoreCase = true) -> {
                false
            }
            else -> !mString.equals("{}", ignoreCase = true)
        }
    }

    /**
     * method is used for checking valid email id format.
     *
     * @param email email address as String
     * @return boolean true for valid false for invalid
     */
    fun isEmailValid(email: String): Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isValidPassword(password: String): Boolean {
        val patn =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\$&+,:;=?@#|_<>.^*()%!-])[A-Za-z\\d\$&+,:;=?@#|_<>.^*()%!-]{8,20}"
        val pattern = Pattern.compile(patn)
        val matcher = pattern.matcher(password)
        return matcher.matches()
    }

    /**
     * Validation of Phone Number
     */
    fun isValidPhoneNumber(target: CharSequence?): Boolean {
        return if (target == null || target.length < 8 || target.length > 12) {
            false
        } else {
            Patterns.PHONE.matcher(target).matches()
        }
    }

    /**
     * Validation of Phone Number and Email id
     * !(isEmailAndPhone.length < 8 || isEmailAndPhone.length > 12)
     */
    fun isEmailAndPhone(isEmailAndPhone: String): Boolean {
        return if (isEmailAndPhone.contains("@")) {
            !TextUtils.isEmpty(isEmailAndPhone) && Patterns.EMAIL_ADDRESS.matcher(isEmailAndPhone)
                .matches()
        } else {
            if (isEmailAndPhone.length == 8) {
                Patterns.PHONE.matcher(isEmailAndPhone).matches()
            } else {
                false
            }
        }
    }
}
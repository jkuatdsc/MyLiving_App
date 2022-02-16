package com.dsc.myliving.presentation.components

sealed interface Validators {
    class Required(var message: String) : Validators
    class Email(var message: String) : Validators
    class Min(var limit: Int, var message: String) : Validators
    class Max(var limit: Int, var message: String) : Validators
}


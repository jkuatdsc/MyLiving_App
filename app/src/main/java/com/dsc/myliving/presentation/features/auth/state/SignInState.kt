package com.dsc.myliving.presentation.features.auth.state

import com.dsc.myliving.presentation.components.EntryTextInput

class SignInState() {
    private var fields: List<EntryTextInput> = listOf()
    fun setFields(inputs: List<EntryTextInput>) = inputs.also { fields = it }

    fun validate(): Boolean {
        var valid = true
        for (field in fields) if (!field.validate()) {
            valid = false
            break
        }
        return valid
    }

    // fun getData(): Map<String, String> = fields.map { it.name to it.text }.toMap()
}

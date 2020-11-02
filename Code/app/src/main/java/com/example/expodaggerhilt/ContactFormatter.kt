package com.example.expodaggerhilt

import javax.inject.Inject

class ContactFormatter @Inject constructor() {

    fun giveFormat(contact: String): String {
        val data = contact.split(" ");
        return data[0] + "\n" + data[1]
    }

}
package com.minthanhtike.bookstores.data.exceptions

class ApiException(message: String, val code: Int): Exception(message)
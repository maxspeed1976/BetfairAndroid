package com.example.betfairandroid.betfair.client.exception

class ServerException : Exception {
    constructor(message: String) : super(message)
    constructor(message: String, throwable: Throwable) : super(message, throwable)
}
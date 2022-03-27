package com.example.cryptoapp.domain.exceptions

import java.io.IOException

class ConnectivityException: IOException("No Internet Connection")

class ClientError(msg: String): IOException(msg)

class ServerError(msg: String): IOException(msg)

class UnknownRequestError(msg: String): IOException(msg)

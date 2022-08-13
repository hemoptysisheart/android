package com.github.hemoptysisheart.util

import java.util.logging.Level.*
import java.util.logging.Logger

fun Logger.v(message: String) {
    if (isLoggable(FINER) || isLoggable(FINEST)) {
        log(FINER, message)
    }
}

fun Logger.v(message: () -> String) {
    if (isLoggable(FINER) || isLoggable(FINEST)) {
        log(FINER, message())
    }
}

fun Logger.d(message: String) {
    if (isLoggable(CONFIG) || isLoggable(FINE)) {
        log(CONFIG, message)
    }
}

fun Logger.d(message: () -> String) {
    if (isLoggable(CONFIG) || isLoggable(FINE)) {
        log(CONFIG, message())
    }
}

fun Logger.i(message: String) {
    if (isLoggable(INFO)) {
        log(INFO, message)
    }
}

fun Logger.i(message: () -> String) {
    if (isLoggable(INFO)) {
        log(INFO, message())
    }
}

fun Logger.w(message: String) {
    log(WARNING, message)
}

fun Logger.w(message: () -> String) {
    log(WARNING, message())
}

fun Logger.e(message: String) {
    log(SEVERE, message)
}

fun Logger.e(message: () -> String) {
    log(SEVERE, message())
}
package com.wxx.corontine.common;

import java.text.SimpleDateFormat
import java.util.*

/**
 * @author TangRen
 * @create 2019-12-22 20:25
 * @TODO:  日志
 */

val format=SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
val now={
    format.format(Date())
}

fun log(msg:String)= println("${now}  [${Thread.currentThread().name}] $msg")
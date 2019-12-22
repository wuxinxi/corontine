package com.wxx.corontine.async;

import com.wxx.corontine.common.log
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * @author TangRen
 * @create 2019-12-22 21:48
 * @TODO:线程池
 */

private val pool by lazy {
    log("初始化线程池")
    Executors.newCachedThreadPool()
}

class AsyncTask(val block:()->Unit){
    fun  execute()= pool.execute(block)
}
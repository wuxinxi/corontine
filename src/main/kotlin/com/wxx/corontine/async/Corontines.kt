package com.wxx.corontine.async;

import com.wxx.corontine.common.HttpException
import com.wxx.corontine.common.HttpService
import com.wxx.corontine.common.log
import kotlin.coroutines.resume
import kotlin.coroutines.startCoroutine
import kotlin.coroutines.suspendCoroutine

/**
 * @author TangRen
 * @create 2019-12-22 21:38
 * @TODO:协程
 */

//开始协程
fun startCorontines(block: suspend ()->Unit){
    block.startCoroutine(BaseContinuation())
}

suspend fun loadImage(url:String)= suspendCoroutine<ByteArray> {
 continuation ->
    log("马上使用线程池执行任务")
    val uiContinuation=UIContinuationWrapper(continuation)
    try {
        //协程本身并不具备异步，所以这里使用线程池
        AsyncTask{
            log("执行耗时任务")
        val responseBody=HttpService.service.getLogo(url).execute()
        if (responseBody.isSuccessful){
            responseBody.body()?.byteStream()?.readBytes()?.let {
                uiContinuation.resume(it)
            }
        }else{
            uiContinuation.resumeWith(Result.failure(HttpException(responseBody.code())))
        }
        }.execute()
    } catch (e: Exception) {
        uiContinuation.resumeWith(Result.failure(HttpException(-1)))
    }

}
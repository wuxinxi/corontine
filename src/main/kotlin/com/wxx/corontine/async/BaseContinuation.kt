package com.wxx.corontine.async;

import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

/**
 * @author TangRen
 * @create 2019-12-22 21:34
 * @TODO:
 */

class BaseContinuation:Continuation<Unit>{
    override val context: CoroutineContext=EmptyCoroutineContext

    override fun resumeWith(result: Result<Unit>) {

    }


}
package com.wxx.corontine.async

import javax.swing.SwingUtilities
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

class UIContinuationWrapper<T> (val continuation: Continuation<T>) :Continuation<T>{
    override val context: CoroutineContext=EmptyCoroutineContext


    override fun resumeWith(result: Result<T>) {
        SwingUtilities.invokeLater { continuation.resumeWith(result) }
    }
}
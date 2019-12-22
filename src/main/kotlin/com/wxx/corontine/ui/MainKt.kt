package com.wxx.corontine.ui;

import com.wxx.corontine.async.loadImage
import com.wxx.corontine.async.startCorontines
import com.wxx.corontine.common.HttpException
import com.wxx.corontine.common.HttpService
import com.wxx.corontine.common.log
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.swing.JFrame
import javax.swing.SwingUtilities

/**
 * @author TangRen
 * @create 2019-12-22 20:29
 * @TODO:  主界面
 */

val url= "/static/img/index/logo.png?t=1.1"

fun main(args: Array<String>) {
    val frame=MainWindow()
    frame.title="logo窗体"
    frame.setSize(200,150)
    frame.isResizable=true
    frame.defaultCloseOperation=JFrame.EXIT_ON_CLOSE
    frame.init()
    frame.isVisible=true

    frame.onButtonClick {
        log("执行协程任务之前")
        startCorontines{
            log("协程开始")
            val imageData= loadImage(url)
            log("获取到图片")
            frame.setLogo(imageData)
        }
        log("执行协程任务后")
    }


    //普通用法，无协程
    /*frame.onButtonClick {
        HttpService.service.getLogo(url)
                .enqueue(object : Callback<ResponseBody> {
                    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                        throw HttpException(-1)
                    }

                    override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                        if (response.isSuccessful){
                            val imagesData=response.body()?.byteStream()?.readBytes()
                            if (imagesData==null){
                                throw HttpException(-400)
                            }else{
                                SwingUtilities.invokeLater{
                                    frame.setLogo(imagesData)
                                }
                            }
                        }else{
                            throw HttpException(response.code())
                        }
                    }


                })

    }*/
}
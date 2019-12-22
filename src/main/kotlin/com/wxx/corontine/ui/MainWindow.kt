package com.wxx.corontine.ui;

import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.ImageIcon
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.border.Border

/**
 * @author TangRen
 * @create 2019-12-22 20:31
 * @TODO:  window
 */
public class MainWindow: JFrame() {

    private lateinit var button:JButton
    private lateinit var image:JLabel

   fun init() {
        button= JButton("点我获取Logo")
        image= JLabel()
        image.size= Dimension(200,80)
        contentPane.add(button,BorderLayout.NORTH)
        contentPane.add(image,BorderLayout.CENTER)
    }

    fun onButtonClick(listener:(ActionEvent)->Unit){
        button.addActionListener(listener)
    }

    fun setLogo(logoData:ByteArray){
        image.icon=ImageIcon(logoData)
    }
}

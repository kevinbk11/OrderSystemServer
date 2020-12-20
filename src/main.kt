<<<<<<< HEAD

import Frame.ListForm
import java.awt.Color
import java.awt.FlowLayout
=======
import java.awt.*
>>>>>>> c1b63486532bc83cf8fbd874d723c15053e2103c
import javax.swing.*


fun main(args: Array<String>) {
<<<<<<< HEAD

    /*//框架
    val jFrame = JFrame("點餐紀錄")
    jFrame.setSize(500, 500) //設定視窗大小
=======
    //框架
    val jFrame = JFrame("待送清單")
    jFrame.setSize(500, 700)//設定視窗大小
>>>>>>> c1b63486532bc83cf8fbd874d723c15053e2103c
    //setLocation //設定顯示位置
    //setBounds //設定顯示位置和視窗大小
    jFrame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    jFrame.contentPane.layout = BorderLayout()
    jFrame.setResizable(false)//設定視窗是否可以拉大或縮小視窗

    val FoodList = JTextArea("待送清單                           \n第一桌拉拉拉麵")
    jFrame.add(FoodList, BorderLayout.WEST)
    val FlowLayout = FlowLayout()

    //元件
    val btnout=JButton("送餐")
    jFrame.add(btnout, BorderLayout.SOUTH)
    val text = JLabel(" ") //JLabel 標籤文字元件
    val Outfd_1 = JCheckBox("1")
    val Outfd_2 = JCheckBox("2")
    val Outfd_3 = JCheckBox("3")
    val Outfd_4 = JCheckBox("4")
    val Outfd_5 = JCheckBox("5")
    jFrame.layout = (FlowLayout)
    jFrame.add(text, BorderLayout.CENTER)
    jFrame.add(Outfd_1, BorderLayout.CENTER)
    jFrame.add(Outfd_2, BorderLayout.CENTER)
    jFrame.add(Outfd_3, BorderLayout.CENTER)
    jFrame.add(Outfd_4, BorderLayout.CENTER)
    jFrame.add(Outfd_5, BorderLayout.CENTER)
    //按键的点击事件
    btnout.addActionListener{
        println("已送出")
    }

<<<<<<< HEAD
    text.text = "Hello Swing" //設定標籤顯示的文字
    pane.add(text) //將元件，加入中間容器中
    pane.add(bten1)


    pane.add(radiobutton)


    jFrame.isVisible = true //顯示視窗*/
    val ListFrame=JFrame("待出餐清單")
    val ListForm=ListForm()
    ListFrame.contentPane=ListForm.panel1
    ListFrame.isVisible=true
    ListFrame.isResizable=false
    ListFrame.setSize(200,500)
=======
    jFrame.isVisible = true
>>>>>>> c1b63486532bc83cf8fbd874d723c15053e2103c
}

import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.Font
import java.awt.GridLayout
import javax.swing.*


fun main(args: Array<String>) {
    //框架
    val jFrame1 = JFrame("待送清單")
    jFrame1.setSize(500, 1000) //設定視窗大小
    //setLocation //設定顯示位置
    //setBounds //設定顯示位置和視窗大小
    jFrame1.setResizable(false)//設定視窗是否可以拉大或縮小視窗

    val jFrame = JFrame("待送清單")
    jFrame.setSize(500, 750)
    jFrame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    jFrame.contentPane.layout = BorderLayout()
    jFrame.setResizable(false)

    val west = JTextArea("West"




    jFrame.add(west, BorderLayout.WEST)


    jFrame.isVisible = true

    //元件


    val btnout=JButton("送餐")
    val Outfd_1 = JRadioButton("JRadiobutton")
    val Outfd_2 = JRadioButton("JRadiobutton")
    val Outfd_3 = JRadioButton("JRadiobutton")
    val text = JLabel() //JLabel 標籤文字元件


    //按键的点击事件
    btnout.addActionListener{
        println("已送出")
    }


}

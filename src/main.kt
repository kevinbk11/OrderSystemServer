import java.awt.*
import javax.swing.*


fun main(args: Array<String>) {
    //框架
    val jFrame = JFrame("待送清單")
    jFrame.setSize(500, 700)//設定視窗大小
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

    jFrame.isVisible = true
}

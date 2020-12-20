
import Frame.ListForm
import java.awt.Color
import java.awt.FlowLayout
import javax.swing.*


fun main(args: Array<String>) {

    /*//框架
    val jFrame = JFrame("點餐紀錄")
    jFrame.setSize(500, 500) //設定視窗大小
    //setLocation //設定顯示位置
    //setBounds //設定顯示位置和視窗大小
    jFrame.setResizable(false)//設定視窗是否可以拉大或縮小視窗
    jFrame.contentPane.background= Color.WHITE
    jFrame.layout=FlowLayout(FlowLayout.CENTER,100,100)
    //为JFrame顶层容器设置FlowLayout布局管理器

    //中間容器
    val pane = jFrame.contentPane

    //元件
    val bten1=JButton("送餐")
    val radiobutton = JRadioButton("JRadiobutton")
    val text = JLabel() //JLabel 標籤文字元件


    //按键的点击事件
    bten1.addActionListener{
        println("已送出")
    }

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
}

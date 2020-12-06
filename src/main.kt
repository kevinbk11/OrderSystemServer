import java.awt.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket
import java.util.concurrent.Flow
import javax.swing.*
import kotlin.reflect.jvm.internal.impl.util.Check


class CheckFrame(title: String) : JFrame() {

    init {
        createUI(title)
    }

    private fun createUI(title: String) {

        setTitle(title)

        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(600, 800)
        setResizable(false)
        setLocationRelativeTo(null)
    }
}

class ListFrame(title: String) : JFrame() {

    init {
        createUI(title)
    }

    private fun createUI(title: String) {

        setTitle(title)

        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(600, 800)
        setResizable(false)
        setLocationRelativeTo(null)
    }
}

private fun createAndShowGUI() {

    val frame = CheckFrame("結帳和退桌")
    var btm1=JButton("第一桌")
    var btm2=JButton("第二桌")
    var btm3=JButton("第三桌")
    var btm4=JButton("第四桌")
    var btm5=JButton("第五桌")
    var btm6=JButton("第六桌")
    var btm7=JButton("第七桌")
    var btm8=JButton("第八桌")
    var buttomList=arrayOf(btm1,btm2,btm3,btm4,btm5,btm6,btm7,btm8)
    val gy = GridLayout(0 ,2,5,5)
    val f=Font("hi",Font.PLAIN,24)
    for (btm in buttomList)
    {
        btm.font=f
        btm.isVisible=false
        frame.add(btm)
    }
    frame.layout=gy
    frame.isVisible = true

    val frame2 = ListFrame("待送清單")
    var L1=JLabel()
    var L2=JLabel()
    var L3=JLabel()
    var L4=JLabel()
    var L5=JLabel()
    var L6=JLabel()
    var L7=JLabel()
    var L8=JLabel()
    var LabelList=arrayOf(L1,L2,L3,L4,L5,L6,L7,L8)
    val gy2 = GridLayout(0 ,2,5,5)
    for (lab in LabelList)
    {
        lab.setFont(f)
        frame2.add(lab)
    }

    frame2.layout=gy2
    frame2.isVisible = true
    val Server=ServerSocket(5004)
    print("Server Start!")
    Thread{
        var table=1
        while(true)
        {
            val Client=Server.accept()
            val btm=buttomList[table-1]
            btm.isVisible=true
            print("已連線")
            Thread{
                val thisTable=table
                val input = Client?.getInputStream()
                val reader = BufferedReader(InputStreamReader(input))
                val output=Client.getOutputStream()
                var writer= PrintWriter(output,true)
                writer.println(thisTable)
                btm.addActionListener {
                    print("來自第${thisTable}桌的客人")
                }
                table++
            }.start()

        }
    }.start()
}
private fun createAndShowGUI2() {


}
fun main(args: Array<String>) {
    EventQueue.invokeLater(::createAndShowGUI)
}
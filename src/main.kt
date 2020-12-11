import java.awt.*
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.io.PrintWriter
import java.lang.Exception
import java.lang.management.PlatformLoggingMXBean
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
        setSize(1200, 800)
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
    val f=Font("hi",Font.PLAIN,16)
    for (btm in buttomList)
    {
        btm.font=f
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
    var btm21=JButton("第一桌")
    var btm22=JButton("第二桌")
    var btm23=JButton("第三桌")
    var btm24=JButton("第四桌")
    var btm25=JButton("第五桌")
    var btm26=JButton("第六桌")
    var btm27=JButton("第七桌")
    var btm28=JButton("第八桌")
    var LabelList=arrayOf(L1,L2,L3,L4,L5,L6,L7,L8)
    var buttomList2=arrayOf(btm21,btm22,btm23,btm24,btm25,btm26,btm27,btm28)
    val gy2 = GridLayout(4 ,4,0,0)
    for (lab in LabelList)
    {
        lab.setFont(f)
        frame2.add(lab)
    }
    for (btm in buttomList2)
    {
        btm.font=f
        frame2.add(btm)
    }
    frame2.layout=gy2
    frame2.isVisible = true
    var Cost=arrayOf(0,0,0,0,0,0,0,0)
    var ButtonFun=arrayOf(false,false,false,false,false,false,false,false)
    val Server=ServerSocket(5004)
    val sendMessageServer= ServerSocket(5006)
    val TotalServer=ServerSocket(5008)
    val sendListServer=ServerSocket(5010)
    println("Server Start!")
    Thread{
        var table=1
        Thread{
            while(true)
            {
                val Client = sendListServer.accept()
                print("request")
                Thread {
                    val output = Client.getOutputStream()
                    val writer = PrintWriter(output, true)
                    val input = Client.getInputStream()
                    val reader = BufferedReader(InputStreamReader(input))
                    val table = reader.readLine()
                    val f = File("${table}.txt")
                    val all = f.readText()
                    val allSplit = all.split("</br>")
                    print(allSplit)
                    writer.println(allSplit.size - 1)
                    for (text in allSplit) {
                        writer.println(text + "<br>")
                    }
                    writer.println(Cost[table.toInt()-1])
                }.start()
            }
        }.start()


        Thread{
            while(true)
            {
                val Client=sendMessageServer.accept()
                Thread{
                    val output = Client.getOutputStream()
                    var writer = PrintWriter(output, true)
                    val input = Client?.getInputStream()
                    val reader = BufferedReader(InputStreamReader(input))
                    val tableNumber=reader.readLine().toInt()
                    print(tableNumber)
                    if(ButtonFun[tableNumber-1]==false)
                    {
                        buttomList2[tableNumber-1].addActionListener{
                            var f=File("${tableNumber}.txt")
                            var all = f.readText()
                            var allList=all.split("<br>")
                            f.writeText("")
                            for(place in 2..allList.size-1)
                            {
                                f.appendText("<br>"+allList[place])
                            }
                            LabelList[tableNumber-1].text="<html>第${tableNumber}桌目前消費${Cost[tableNumber-1]}元${f.readText()}</html>"
                            writer.println("test")
                        }
                        ButtonFun[tableNumber-1]=true
                    }

                }.start()
            }
        }.start()
        while(true)
        {
            val Client=Server.accept()
            val input = Client?.getInputStream()
            val reader = BufferedReader(InputStreamReader(input))
            val ReallyClient:Int=reader.readLine().toInt()
            print(ReallyClient)
            Thread{
                var tableNumber=table
                val output = Client.getOutputStream()
                var writer = PrintWriter(output, true)
                writer.println(tableNumber)
                if(ReallyClient==0)
                {
                    table++
                    buttomList[table-2].addActionListener {
                        println("正在為${tableNumber}桌的客人結帳,一共是${Cost[tableNumber-1]}元")
                        LabelList[tableNumber-1].text=""
                        Cost[tableNumber-1]=0
                        val F=File(tableNumber.toString()+".txt")
                        F.writeText("")
                        var C=TotalServer.accept()
                        val o = C.getOutputStream()
                        val w = PrintWriter(o,true)
                        w.println(true)
                    }
                }
                else if(ReallyClient==1)
                {
                    tableNumber=reader.readLine().toInt()
                    var f=File("${tableNumber}.txt")
                    var tar=""
                    var foodArr = arrayOf("", "", "", "")
                    var full=false
                    for (place in 0..3)
                    {
                        foodArr[place] = reader.readLine()
                        if(foodArr[place]!="None")
                        {
                            var food = foodArr[place].split(":")
                            var foodName=food[0]
                            var foodCount=food[1]
                            if(f.readText().split("<br>").size<9)
                            {
                                f.appendText("<br>第${tableNumber}桌"+foodName)
                                f.appendText(foodCount+"</br>")
                            }
                            else
                            {
                                full=true
                            }
                            //println("第${tableNumber}桌號的訂單:${food[0]}${food[1]}個")
                        }
                        if(!full)
                        {
                            Cost[tableNumber-1]+=reader.readLine().toInt()
                        }
                        else
                        {
                            reader.readLine()
                        }
                    }
                    tar="${f.readText()}</html>"
                    tar="<html><br>第${tableNumber}桌目前消費${Cost[tableNumber-1]}元</br>"+tar
                    LabelList[tableNumber-1].text=tar

                }
                else if(ReallyClient==2)
                {
                    println("要求結帳")
                    writer.println(Cost[tableNumber-2])
                }

            }.start()

        }
    }.start()
}
private fun createAndShowGUI2() {


}
fun main(args: Array<String>) {
    EventQueue.invokeLater(::createAndShowGUI)
}
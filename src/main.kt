
import java.awt.*
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket
import javax.swing.*
import Frame.ListForm
import java.lang.Exception

class CheckFrame(title: String) : JFrame() {

    init {
        createUI(title)
    }

    private fun createUI(title: String) {

        setTitle(title)

        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(400, 700)
        setResizable(false)
        setLocationRelativeTo(null)
    }
}

class HistoryFrame(title: String) : JFrame() {

    init {
        createUI(title)
    }

    private fun createUI(title: String) {

        setTitle(title)

        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(1920-400, 700)
        setResizable(false)
        setLocationRelativeTo(null)
    }
}

private fun createAndShowGUI() {
    var Cost=arrayOf(0,0,0,0,0,0,0,0)
    val ListFrame=JFrame("待出餐清單")
    val ListForm=ListForm()
    var waitList=ListForm.FoodList

    ListForm.OutfdBtn.addActionListener{
        var CheckBoxState=arrayOf(ListForm.CheckBox1.isSelected,ListForm.CheckBox2.isSelected,ListForm.CheckBox3.isSelected,ListForm.CheckBox4.isSelected,ListForm.CheckBox5.isSelected)
        var nowTable=1
        var deleteTimes=0
        for(isSelected in CheckBoxState)
        {
            var w=waitList
            var waitFood=w.text.split("\n")
            if(isSelected)
            {
                println()
                println(waitFood)
                //println(waitFood[nowTable-1])
                var tableNumber=waitFood[nowTable-1-deleteTimes].substring(1,2).toInt()
                var f=File("${tableNumber}.txt")
                var all = f.readText()
                //println(all)
                var allList=all.split("\n")
                //println(allList)
                f.writeText("")
                var h=File("history${tableNumber}.txt")
                var allHistory=h.readText().split("/")
                var newHistory= arrayListOf<String>()
                var deletedFood=""
                for(place in 0..allList.size-2)
                {
                    if(allList[place]!=waitFood[nowTable-1-deleteTimes])
                    {
                        f.appendText(allList[place]+"\n")
                    }
                    else
                    {
                        deletedFood=allList[place]
                    }
                }
                var delete:Boolean=false
                var FoodStringList=deletedFood.split("第[0-9]桌".toRegex())
                for(place in 0..allHistory.size-2)
                {

                    var allHistoryText=(allHistory[place].split(":"))
                    try{
                        if(FoodStringList[1]==allHistoryText[0]+":"+allHistoryText[1]&&(allHistoryText[2]=="N" && !delete))
                        {
                            var newString=allHistory[place]
                            newString=newString.replace("N","Y/")
                            //println(newString)
                            newHistory.add(newString)
                            delete=true
                        }
                        else
                        {
                            //println(allHistory[place])
                            newHistory.add(allHistory[place]+"/")
                        }
                    }
                    catch(e:Exception)
                    {

                    }
                    h.writeText("")
                    for(text in newHistory)
                    {
                        h.appendText(text)
                    }
                }
                var waitFile=File("wait.txt")
                var allWait=waitFile.readText().split("\n")
                var WordOriginList=h.readText()
                var reg = ":[N|Y]/".toRegex()
                var WordList=WordOriginList.split(reg)
                //println(WordList)
                waitList.text=""
                waitFile.writeText("")
                for (word in allWait)
                {
                    try{
                        println(FoodStringList)
                        println("HI"+word+":"+FoodStringList[1])
                        if(word.split("第[0-9]桌".toRegex())[1]!=FoodStringList[1])
                        {
                            waitList.text=waitList.text+"${word}\n"
                            waitFile.appendText(word+"\n")
                        }
                    }
                    catch (e:Exception)
                    {
                        print("X")
                    }
                }
                /*writer.println("test")
                writer.println(newHistory.size-1)
                for(x in newHistory)
                {
                    print("????")
                    println(x)
                    writer.println(x)
                }*/
                deleteTimes+=1
            }
            nowTable+=1
        }
    }
    var CheckBoxArray=arrayOf(ListForm.CheckBox1,ListForm.CheckBox2,ListForm.CheckBox3,ListForm.CheckBox4,ListForm.CheckBox5)
    ListFrame.contentPane=ListForm.panel1
    ListFrame.isVisible=true
    ListFrame.isResizable=false
    ListFrame.setSize(800,750)
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

    val frame2 = HistoryFrame("歷史紀錄")
    var L1=JTextArea()
    var L2=JTextArea()
    var L3=JTextArea()
    var L4=JTextArea()
    var L5=JTextArea()
    var L6=JTextArea()
    var L7=JTextArea()
    var L8=JTextArea()
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
    val gy2 = GridLayout(2,  8,0,-1)
    val f2=Font("hi2",Font.PLAIN,16)
    for (lab in LabelList)
    {
        lab.setFont(f2)
        lab.isEditable=false
        frame2.add(lab)
    }
    /*for (btm in buttomList2)
    {
        btm.font=f
        frame2.add(btm)
    }*/
    frame2.layout=gy2
    frame2.isVisible = true
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
                Thread {
                    val output = Client.getOutputStream()
                    val writer = PrintWriter(output, true)
                    val input = Client.getInputStream()
                    val reader = BufferedReader(InputStreamReader(input))
                    val table = reader.readLine()
                    val f = File("history${table}.txt")
                    val all = f.readText()
                    val allSplit = all.split("/")
                    writer.println(allSplit.size - 1)
                    for (text in allSplit) {
                        print(text)
                        writer.println(text)
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
                            var h=File("history${tableNumber}.txt")
                            var allHistory=h.readText().split("/")
                            var newHistory= arrayListOf<String>()
                            for(place in 2..allList.size-1)
                            {
                                f.appendText("<br>"+allList[place])
                            }
                            var delete:Boolean=false
                            for(place in 0..allHistory.size-2)
                            {
                                var allHistoryText=(allHistory[place].split(":"))
                                if(allHistoryText[2]=="N" && !delete)
                                {
                                    var newString=allHistory[place]
                                    newString=newString.replace("N","Y/")
                                    println(newString)
                                    newHistory.add(newString)
                                    delete=true
                                }
                                else
                                {
                                    println(allHistory[place])
                                    newHistory.add(allHistory[place]+"/")
                                }
                                h.writeText("")
                                for(text in newHistory)
                                {
                                    h.appendText(text)
                                }
                            }
                            LabelList[tableNumber-1].text="<html>第${tableNumber}桌目前消費${Cost[tableNumber-1]}元${f.readText()}</html>"
                            writer.println("test")
                            writer.println(newHistory.size-1)
                            for(x in newHistory)
                            {
                                print("????")
                                println(x)
                                writer.println(x)
                            }
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
                    var h=File("history${tableNumber}.txt")
                    var w=File("wait.txt")
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
                            if(f.readText().split("\n").size<9)
                            {
                                f.appendText("第${tableNumber}桌${foodName}:${foodCount}\n")
                                waitList.text=waitList.text+"第${tableNumber}桌${foodName}:${foodCount}\n"
                                h.appendText("${foodName}:${foodCount}:N/")
                                w.appendText("第${tableNumber}桌${foodName}:${foodCount}\n")
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
                    var WordOriginList=h.readText()
                    var reg = ":[N|Y]/".toRegex()
                    var WordList=WordOriginList.split(reg)
                    tar="第${tableNumber}桌目前消費${Cost[tableNumber-1]}元"
                    for(word in WordList)
                    {
                        if(!(word.length<2))
                        {
                            tar=tar+"\n第${tableNumber}桌${word}"
                        }
                    }
                    LabelList[tableNumber-1].text=tar
                }
                else if(ReallyClient==2)
                {
                    println("要求結帳")
                    writer.println(Cost[tableNumber-2])
                    var f=File("history${tableNumber-1}.txt")
                    f.writeText("")
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
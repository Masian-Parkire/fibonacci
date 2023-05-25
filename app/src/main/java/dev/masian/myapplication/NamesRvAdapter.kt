import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.masian.myapplication.R

class NamesRvAdapter (var namesList:List<String>): RecyclerView.Adapter<NamesViewHolder>(){

    private val fibonacciList = generateFibonacciNumbers(100)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NamesViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.name_list_item,parent,false)
        return NamesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NamesViewHolder, position: Int) {
        val currentName=namesList.get(position)
        holder.tvName.text=currentName
    }

    override fun getItemCount(): Int {
        return namesList.size
    }

    private fun generateFibonacciNumbers(count: Int): List<Int> {
        val fibonacciList = mutableListOf<Int>()
        var a = 0
        var b = 1
        fibonacciList.add(a)
        fibonacciList.add(b)
        for (i in 2 until count) {
            val c = a + b
            fibonacciList.add(c)
            a = b
            b = c
        }
        return fibonacciList
    }

    fun getFibonacciList(): List<Int> {
        return fibonacciList
    }
}

class NamesViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
    var tvName=itemView.findViewById<TextView>(R.id.tvName)
}
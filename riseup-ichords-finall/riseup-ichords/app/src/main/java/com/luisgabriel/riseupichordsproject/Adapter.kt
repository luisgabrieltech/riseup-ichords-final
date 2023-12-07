import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.luisgabriel.riseupichordsproject.MyData
import com.luisgabriel.riseupichordsproject.R

class Adapter(private val mylist: List<MyData>): RecyclerView.Adapter<Adapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_adapter, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = mylist.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = mylist[position]

        holder.textName.text = data.name
        holder.textQuantidade.text = data.quantidade
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textName: TextView = itemView.findViewById(R.id.text_item)
        val textQuantidade: TextView = itemView.findViewById(R.id.text_item_dois)
    }
}
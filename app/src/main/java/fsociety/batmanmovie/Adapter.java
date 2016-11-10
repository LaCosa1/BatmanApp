package fsociety.batmanmovie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by FSociety on 02/11/2016.
 */
public class Adapter extends BaseAdapter {

    private List<MovieBatman> listaBadman;
    private Context context;


    public Adapter( List<MovieBatman> listaBadman,Context context) {
        this.listaBadman = listaBadman;
        this.context = context;

    }

    @Override
    public int getCount() {
        return listaBadman.size();
    }

    @Override
    public Object getItem(int position){
        return  listaBadman.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listaBadman.get(position).getId();
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.batman_movie_item, null);
        }

        MovieBatman b =this.listaBadman.get(position);
        TextView textViewtitulo = (TextView) v.findViewById(R.id.textViewTitle);
        TextView textViewaño = (TextView) v.findViewById(R.id.textViewYear);
        TextView textViewtipo = (TextView) v.findViewById(R.id.textViewType);
        ImageView imageViewImagen= (ImageView) v.findViewById(R.id.imageView);


        textViewtitulo.setText(b.getTitle());
        textViewaño.setText(b.getYear());
        textViewtipo.setText(b.getType());
        Picasso.with(this.context).load(b.getPoster()).into(imageViewImagen);

        return v;
    }
}





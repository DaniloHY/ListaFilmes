package br.com.etecia.listafilmes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listaFilmes;

    //Criar a base de dados para os filmes

    String titulo[] = {"Star Wars", "Cop Land", "Carros", "Ford x Ferrari", "Vingadores Ultimato", "Homem formiga e a Vespa"};
    String subtitulo[] = {getString(R.string.sw),
            getString(R.string.cop),
            getString(R.string.carros),
            getString(R.string.fxf),
            getString(R.string.v_u),
            getString(R.string.hfeav)};
    String rating[] = {"5", "4", "5", "5", "5", "4"};
    int filmes[] = {R.drawable.Starwars, R.drawable.copland, R.drawable.carros, R.drawable.ford, R.drawable.vingadores, R.drawable.formiga};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaFilmes = findViewById(R.id.idListaFilmes);

        MyAdapter adapter = new MyAdapter();

        //preparar para intanciar o adpatador
        listaFilmes.setAdapter(adapter);

    }
    //Criando uma inner class MyAdapter

    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return filmes.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            //Variáveis do modelo
            ImageView imagemFilme;
            TextView tituloFilme, subtituloFilme, ratingFilme;

            //Adaptador ligando ao modelo
            View v = getLayoutInflater().inflate(R.layout.modelofilmes, null);

            //Apresentar as variáveis do Java para o modelo XML
            imagemFilme = v.findViewById(R.id.imgFilmes);
            tituloFilme = v.findViewById(R.id.idTitulo);
            subtituloFilme = v.findViewById(R.id.idSubtitulo);
            ratingFilme = v.findViewById(R.id.idRating);

            //Inserindo os valores nas variáveis do java

            tituloFilme.setText(titulo[i]);
            subtituloFilme.setText(subtitulo[i]);
            ratingFilme.setText(rating[i]);
            imagemFilme.setImageResource(filmes[i]);

            return v;
        }
    }
}
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
    String subtitulo[] = {"A queda de Darth Vader e do Império levou ao surgimento de uma nova força sombria: a Primeira Ordem. Eles procuram o jedi Luke Skywalker, desaparecido. A resistência tenta desesperadamente encontrá-lo antes para salvar a galáxia.",
            "Um jovem policial de Nova Jersey, em uma atitude impensada, mata dois inocentes. Para protegê-lo, seus colegas forjam seu suicídio, mas o corregedor da polícia não acredita na história.",
            "Ao viajar para a Califórnia, o famoso carro de corridas Relâmpago McQueen se perde e vai parar em Radiator Springs, uma cidadezinha na Rota 66. Ele conhece novos amigos e aprende lições que mudam sua forma de encarar a vida.",
            "O projetista Carroll Shelby e o piloto Ken Miles enfrentaram a interferência empresarial, as leis da física e os próprios demônios para construir um carro de corrida para a Ford Motor derrotar a hegemonia de Enzo Ferrari nas 24 horas de Le Mans.",
            "Após Thanos eliminar metade das criaturas vivas, os Vingadores têm de lidar com a perda de amigos e entes queridos. Com Tony Stark vagando perdido no espaço sem água e comida, Steve Rogers e Natasha Romanov lideram a resistência contra o titã louco.",
            "Scott Lang lida com as consequências de suas escolhas tanto como super-herói quanto como pai. Enquanto tenta reequilibrar sua vida com suas responsabilidades como o Homem-Formiga, ele é confrontado por Hope van Dyne e Dr. Hank Pym com uma nova missão urgente."};
    String rating[] = {"5", "4", "5", "5", "5", "4"};
    int filmes[] = {R.drawable.starwars, R.drawable.copland, R.drawable.carros, R.drawable.ford, R.drawable.vingadores, R.drawable.formiga};

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
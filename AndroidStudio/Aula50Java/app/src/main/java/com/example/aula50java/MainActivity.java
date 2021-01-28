package com.example.aula50java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    //para criar uma constante em java utiliza a palavra "final"
    final float PI = 3.14f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botao = findViewById(R.id.button);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Personagem personagem = new Personagem();
            }
        });



        List<String> pessoas = new ArrayList<>();

        for (String pessoa : pessoas) {

        }



        String pessoa1 = "Paulo";
        String pessoa2 = "José";

        if (pessoa1.equals(pessoa2)) {
            System.out.println("É igual");
        }


        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }





        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
    public void print(int valor) {
        System.out.println(valor);

        if (valor < 10) {
            print(++valor);
        }
    }



    //esse é o companion object
    public static int Calcula(int x, int y) {
        return x + y;
    }




    //para construir uma classe sendo uma data class
    public class Personagem implements Serializable {
        private int idade;
        private String nome;

        public Personagem() {
        }

        public Personagem(int idade, String nome) {
            this.idade = idade;
            this.nome = nome;
        }

        public int getIdade() {
            return idade;
        }

        public void setIdade(int idade) {
            this.idade = idade;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Personagem that = (Personagem) o;
            return idade == that.idade &&
                    Objects.equals(nome, that.nome);
        }

        @Override
        public int hashCode() {
            return Objects.hash(idade, nome);
        }

        @Override
        public String toString() {
            return "Personagem{" +
                    "idade=" + idade +
                    ", nome='" + nome + '\'' +
                    '}';
        }
    }
}
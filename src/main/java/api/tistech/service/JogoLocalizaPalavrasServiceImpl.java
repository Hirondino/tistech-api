package api.tistech.service;

import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class JogoLocalizaPalavrasServiceImpl implements IJogoLocalizaPalavrasService {

    private char[][] matriz = {
            {'A','B','L','N','H','E','H','L','L','T','B','Q','J','F','R','G','Q','H'},
            {'K','J','U','T','W','R','A','Z','I','L','A','C','O','L','V','M','N','J'},
            {'F','E','O','G','E','Q','H','T','L','O','I','D','F','M','B','A','O','Q'},
            {'R','W','B','N','U','S','G','E','V','I','X','O','I','O','X','G','U','Z'},
            {'B','R','D','A','R','G','T','E','N','T','A','T','I','V','A','Y','J','K'},
            {'E','A','R','H','S','O','W','E','S','L','F','V','C','D','P','Z','J','Q'},
            {'W','E','C','S','W','A','T','L','X','B','M','T','L','C','D','P','N','I'},
            {'E','W','S','C','A','W','L','T','B','X','T','M','C','L','P','D','I','N'},
            {'S','E','W','C','T','S','T','B','L','N','X','K','H','Q','I','V','N','I'},
            {'I','N','P','D','C','L','B','X','C','B','M','T','L','C','D','P','N','I'},
            {'X','B','T','S','W','A','T','L','W','B','E','S','L','X','A','Z','O','R'},
            {'X','B','M','T','L','C','D','P','N','I','W','E','C','S','W','A','T','L'},
            {'T','L','X','B','M','W','E','C','S','W','A','T','L','C','D','P','N','I'},
            {'T','L','X','B','M','T','W','E','C','S','W','A','L','C','D','P','N','I'},
            {'W','E','C','L','C','D','S','W','A','T','L','X','B','M','T','P','N','I'},
            {'W','E','C','S','W','A','T','L','X','B','M','T','L','C','D','P','N','I'},
            {'W','E','C','S','W','T','L','C','A','T','L','X','B','M','D','P','N','I'},
            {'W','E','C','B','M','T','L','C','S','W','A','T','L','X','D','P','N','I'},
    };

    private int[][] toArrayInt( List<int[]> list ){
        return (int[][]) list.toArray( new int[list.size()][list.get(0).length]);
    }

    private String palavraNaMatriz(int[] posicaoInicial, int numeroDeCaracteres, int moverEmFila, int moverEmColuna) {
        String palavra = "";
        int recorrido = 0, fila = posicaoInicial[0], coluna = posicaoInicial[1];

        while((recorrido < numeroDeCaracteres) &&
                (fila < matriz.length && coluna < matriz.length) &&
                (fila > -1 && coluna > -1)) {

            palavra += matriz[fila][coluna];
            fila = fila + moverEmFila;
            coluna = coluna + moverEmColuna;
            recorrido++;
        }

        return palavra;
    }

    private int[][] solucoesPossiveis(String palavra) {
        char primeiraLetra = palavra.charAt(0);
        List<int[]> indiceInvertido = new ArrayList<int[]>();

        for(int i=0; i < matriz.length; i++){
            for(int j=0; j < matriz[i].length; j++){
                if(matriz[i][j] == primeiraLetra){
                    indiceInvertido.add(new int[]{i, j});
                }
            }
        }
        return toArrayInt(indiceInvertido);
    }

    public boolean resolverJogo(String palavra){
        log.info("Iniciando metodo para localizar as palavras");
        for( int[] posicao : solucoesPossiveis(palavra) ){

            log.info("Pesquisa horizontalmente a direita");
            String palavraEncontrada = palavraNaMatriz(posicao, palavra.length(), 0, 1);
            if(palavraEncontrada.equals(palavra))
                return true;

            log.info("Pesquisa horizontalmente a esquerda");
            palavraEncontrada = palavraNaMatriz(posicao, palavra.length(), 0, -1);
            if(palavraEncontrada.equals(palavra))
                return true;

            log.info("Pesquisa verticalmente a baixo");
            palavraEncontrada = palavraNaMatriz(posicao, palavra.length(), 1, 0);
            if(palavraEncontrada.equals(palavra))
                return true;

            log.info("Pesquisa verticalmente a cima");
            palavraEncontrada = palavraNaMatriz(posicao, palavra.length(), -1, 0);
            if(palavraEncontrada.equals(palavra))
                return true;

            log.info("Pesquisa na diagonal superior direita");
            palavraEncontrada = palavraNaMatriz(posicao, palavra.length(), -1, 1);
            if(palavraEncontrada.equals(palavra))
                return true;

            log.info("Pesquisa na diagonal superior esquerda");
            palavraEncontrada = palavraNaMatriz(posicao, palavra.length(), -1, -1);
            if(palavraEncontrada.equals(palavra))
                return true;

            log.info("Pesquisa na diagonal inferior direita");
            palavraEncontrada = palavraNaMatriz(posicao, palavra.length(), 1, 1);
            if(palavraEncontrada.equals(palavra))
                return true;

            log.info("Pesquisa na diagonal inferior esquerda");
            palavraEncontrada = palavraNaMatriz(posicao, palavra.length(), 1, -1);
            if(palavraEncontrada.equals(palavra))
                return true;
        }
        return false;
    }

}

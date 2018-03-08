import java.util.*;
import java.lang.*;


class Tabuleiro{
	private int[][] jogo;
	private int value;

	Tabuleiro(int[][] tabuleiro, int value){
		jogo = tabuleiro;
		this.value = value;
	}

	public int[][] getJogo(){
		return jogo;
	}

}

public class TRAB2{

    /*static Tabuleiro miniMax_Decision(int[][] jogo){
	int v = MAX_VALUE(tabuleiro);
	return 
    }

    static int MAX_VALUE(int[][] jogo){
	if(TERMINAL_TEST(state)){
	    return UTILITY(state);
	}
	
	int v = MIN_INT;
	for(s : sucessores(state)){
	    v = MAX(v, MIN_VALUE(s));
	}

	return v;	    
    }

    static int MIN_VALUE(state){
	if(TERMINAL_TEST(state)){
	    return UTILITY(state);
	}
	v = MAX_INT;
	for(s : sucessores(state)){
	    v = MIN(v, MAX_VALUE(s));
	}
	return v;
}*/


	static Boolean makePlay(int[][] config, int coluna, int jogador){
		if(coluna < 0 || coluna > 6){
			System.out.println("Essa coluna nao existe! Jogada Impossivel...");
			return false;
		}

		for(int i = 5; i >= 0; i--){
			if(config[i][coluna] == '-'){
				// jogador == 1 ---> Human	
				if(jogador == 1){
					config[i][coluna] = 'X';
					return true;
				}

				// jogador == 2 ---> PC
				else if(jogador == 2){
					config[i][coluna] = 'O';
					return true;
				}
			}
		}

		System.out.println("Essa coluna esta cheia! Jogada Impossivel...");
		return false;
	}

	public static void main(String[] args){
		char[][] tabuleiro = {{'-','-','-','-','-','-','-'},
							  {'-','-','-','-','-','-','-'},
							  {'-','-','-','-','-','-','-'},
							  {'-','-','-','-','-','-','-'},
							  {'-','-','-','-','-','-','-'},
							  {'-','-','-','-','-','-','-'}};
		
	}
}

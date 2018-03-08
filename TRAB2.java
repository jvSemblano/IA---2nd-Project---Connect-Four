import java.util.*;
import java.lang.*;


/*class Tabuleiro{
	private int[][] jogo;
	private int value;

	Tabuleiro(int[][] tabuleiro, int value){
		jogo = tabuleiro;
		this.value = value;
	}

	public int[][] getJogo(){
		return jogo;
	}

}*/

public class TRAB2{


	static int ler_Horizontal(int[][] matrix){
		int countX = 0;
		int countO = 0;

		for(int i = 5; i >= 0; i--) {
			for(int j = 0; j < 7; j++) {
				if(matrix[i][j])=='X') {
					countX++;
					countO = 0;
					if(countX == 4) {
						//player wins
						return 1;
					}
				}

				else if(matrix[i][j]=='O') {
					countO++;
					countX = 0; 
					if(countO == 4) {
						//PC wins
						return 2;
					}
				}	

			}
			countX = 0;
			countO = 0;
		}
	}

	static int ler_Vertical(int[][] matrix) {
		int countX = 0;
		int countO = 0;
		for(int i = 0; i < 7; i++) {
			for(int j = 5; j >= 0; j++) {
				if(matrix[i][j])=='X') {
				 	countX++;
					countO = 0;
					if(countX == 4) {
						//player wins
						return 1;
					}
				}

				else if(matrix[i][j]=='O') {
					countO++;
					countX = 0; 
					if(countO == 4) {
						//PC wins
						return 2;
					}
				}	

			}
		countX = 0;
		countO = 0;

		}
	}
	

	static int ler_diagonal(int[][]matrix) {
		int a=3;
		int countX = 0;
		int countO = 0;
		for(int i=2; i>=0; i--) {
			int k=i;
			for(int j=0; j<=a; j++) {
				if(matrix[k+1][j])=='X') {
				 	countX++;
					countO = 0;
					if(countX == 4) {
						//player wins
						return 1;
					}
				}

				else if(matrix[k+1][j]=='O') {
					countO++;
					countX = 0; 
					if(countO == 4) {
						//PC wins
						return 2;
					}
				}	

			}
			countX = 0;
			countO = 0;
			a++;

		}

		a=5;
		countX = 0;
		countO = 0;

		for(int i=1; i<=3; i++) {
			for(int j=0; j<=a; j++) {
				int k=i;
				if(matrix[k+1][j])=='X') {
				 	countX++;
					countO = 0;
					if(countX == 4) {
						//player wins
						return 1;
					}
				}

				else if(matrix[k+1][j]=='O') {
					countO++;
					countX = 0; 
					if(countO == 4) {
						//PC wins
						return 2;
					}
				}	

			}
			countX = 0;
			countO = 0;
			a--;



			}

		}
	}
	



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


	static boolean makePlay(char[][] config, int coluna, int jogador){
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
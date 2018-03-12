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

	static int checkWin(char[][] tabuleiro){
		if(ler_Vertical(tabuleiro) == 3 && ler_Horizontal(tabuleiro) == 3 && ler_Diagonal(tabuleiro) == 3){
			if(checkEmpate(tabuleiro)){
				//empate
				System.out.println("Empatezaooooooo!");
				return 2;
			}
			else{
				//nao empate
				return 1;
			}
		}

		else if(ler_Vertical(tabuleiro) == 1 || ler_Horizontal(tabuleiro) == 1 || ler_Diagonal(tabuleiro) == 1){
			//player wins
			System.out.println("Ganhasteeeee!");
			return 2;
		}

		else if(ler_Vertical(tabuleiro) == 2 || ler_Horizontal(tabuleiro) == 2 || ler_Diagonal(tabuleiro) == 2){
			//pc wins
			System.out.println("Perdesteeeee!");
		  	return 2;
		}
		return 1;
	}

	static boolean checkEmpate(char[][] tabuleiro){
		for(int i = 0; i <= 6; i++){
			if(tabuleiro[0][i] == '-'){
				return false;
			}
		} 
		return true;
	}


	static int ler_Horizontal(char[][] matrix){
		int countX = 0;
		int countO = 0;

		for(int i = 5; i >= 0; i--) {
			for(int j = 0; j < 7; j++) {
				if(matrix[i][j]=='X') {
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
		return 3;
	}

	static int ler_Vertical(char[][] matrix) {
		int countX = 0;
		int countO = 0;
		for(int i = 0; i < 7; i++) {
			for(int j = 5; j >= 0; j--) {
				if(matrix[j][i]=='X') {
				 	countX++;
					countO = 0;
					if(countX == 4) {
						//player wins
						return 1;
					}
				}

				else if(matrix[j][i]=='O') {
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

		return 3;
	}
	

	static int ler_Diagonal(char[][] matrix) {
		int a=3;
		int countX = 0;
		int countO = 0;
		for(int i=2; i>=0; i--) {
			int k=i;
			for(int j=0; j<=a; j++) {
				if(matrix[k][j]=='X') {
				 	countX++;
					countO = 0;
					if(countX == 4) {
						//player wins
						return 1;
					}
				}

				else if(matrix[k][j]=='O') {
					countO++;
					countX = 0; 
					if(countO == 4) {
						//PC wins
						return 2;
					}
				}	
				k++;
			}
			countX = 0;
			countO = 0;
			a++;

		}

		a=5;
		countX = 0;
		countO = 0;

		for(int i=1; i<=3; i++) {
			int k=i;
			for(int j=0; j<=a; j++) {
				
				if(matrix[j][k]=='X') {
				 	countX++;
					countO = 0;
					if(countX == 4) {
						//player wins
						return 1;
					}
				}

				else if(matrix[j][k]=='O') {
					countO++;
					countX = 0; 
					if(countO == 4) {
						//PC wins
						return 2;
					}
				}	
				k++;
			}
			countX = 0;
			countO = 0;
			a--;

		}


		int temp = 5;

		for(int i = temp; i >= 3; i--){
			int k = i;
			for(int j = 0; j <= i; j++){
				if(matrix[j][k]=='X') {
				 	countX++;
					countO = 0;
					if(countX == 4) {
						//player wins
						return 1;
					}
				}

				else if(matrix[j][k]=='O') {
					countO++;
					countX = 0; 
					if(countO == 4) {
						//PC wins
						return 2;
					}
				}
				k--;
			}

			countX = 0;
			countO = 0;
		}

		int k = 6;
		for(int i = k; i >= 4 ; i--){
			
			for(int j = a; j <= 5 ; j++){
				if(matrix[j][k]=='X') {
				 	countX++;
					countO = 0;
					if(countX == 4) {
						//player wins
						return 1;
					}
				}

				else if(matrix[j][k]=='O') {
					countO++;
					countX = 0; 
					if(countO == 4) {
						//PC wins
						return 2;
					}
				}
				k--;
			}
			k = 6;
			a++;
			countX = 0;
			countO = 0;
		}

		return 3;
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
			System.out.println("Essa coluna nao existe! Jogada Impossivel... Escolha outra coluna.");
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

		System.out.println("Essa coluna esta cheia! Jogada Impossivel... Escolha outra coluna.");
		return false;
	}

	static void printBoard(char[][] tabuleiro){
		for(int i = 0; i <= 5; i++){
			for(int j = 0; j <= 6; j++){
				System.out.print(tabuleiro[i][j] + " ");
			}
			System.out.println();
		} 
		System.out.println("0 1 2 3 4 5 6");
	}


	public static void main(String[] args){
		char[][] tabuleiro = {{'-','-','-','-','-','-','-'},
				              {'-','-','-','-','-','-','-'},
			                  {'-','-','-','-','-','-','-'},
			                  {'-','-','-','-','-','-','-'},
				              {'-','-','-','-','-','-','-'},
				              {'-','-','-','-','-','-','-'}};
		
	    printBoard(tabuleiro);
		Scanner input = new Scanner(System.in);
		System.out.println("Quem deve ser o primeiro a jogar?");
		System.out.println("Tu ---> 1");
		System.out.println("PC ---> 2");
		int toPlay = input.nextInt();
		while(toPlay != 1 && toPlay != 2){
			System.out.println("Escolha uma das opcoes apresentadas!");
			toPlay = input.nextInt();
		}

		int algorithm = input.nextInt();
		while(algorithm != 1 && algorithm != 2){
			System.out.println("Escolha uma das opcoes apresentadas!")
			algorithm = input.nextInt();
		}
		int temp = 2;
		int temp2 = toPlay;
		if(toPlay == 2){
			temp = 1;
		}



		for(int i = 0; i < 42; i++){
			int move;
			if(toPlay == 1){
				System.out.println("Escolha a coluna onde pretendes jogar (0 - 6):");
				move = input.nextInt();
				while(!makePlay(tabuleiro, move, 1)){
					move = input.nextInt();
				}
				printBoard(tabuleiro);
			}
			else{
				if(algorithm == 1){
					move = miniMax();
					makePlay(tabuleiro, move, 2);
				}
				else{
					move = alphabet();
					makePlay(tabuleiro, move, 2);
				}
			}

			/*else{
				System.out.println("Escolha a coluna onde pretendes jogar (0 - 6):");
				move = input.nextInt();
				while(!makePlay(tabuleiro, move, 2)){
					move = input.nextInt();
				}
				printBoard(tabuleiro);
			}*/
			int v = checkWin(tabuleiro);
			if(v == 2 || v == 3 || v == 4){
				return;
			}
		//System.out.println(ler_diagonal(tabuleiro));
			//change turn
			i++;
			if(i%2 == 0){
				toPlay = temp2;
			}
			else{
				toPlay = temp;
			}
			i--;

		}
	}
}

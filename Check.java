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
			return 3;
		}

		else if(ler_Vertical(tabuleiro) == 2 || ler_Horizontal(tabuleiro) == 2 || ler_Diagonal(tabuleiro) == 2){
			//pc wins
			System.out.println("Perdesteeeee!");
		  	return 4;
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
				
				else{
					countX = 0;
					countO = 0;
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
				
				else{
					countX = 0;
					countO = 0;
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
				
				else{
					countX = 0;
					countO = 0;
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
				
				else{
					countX = 0;
					countO = 0;
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
				
				else{
					countX = 0;
					countO = 0;
				}
				k--;
			}

			countX = 0;
			countO = 0;
		}
		
		a = 2;
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
				
				else{
					countX = 0;
					countO = 0;
				}
				k--;
			}
			k = 6;
			a--;
			countX = 0;
			countO = 0;
		}

		return 3;
	}

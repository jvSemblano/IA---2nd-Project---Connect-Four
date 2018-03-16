//MINIMAX

static int mini_Max(char[][] jogo){
	int v = max_Value(jogo);
	return makeSuccessors(jogo, v);
}

/*char[][] temp = new char[6][7];
	for(int i = 0; i < 6; i++){
		for(int j = 0; j < 7; j++){
			temp[i][j] = jogo[i][j];
		}
	}*/

static int max_Value(char[][] jogo){
	if(terminal_Test(jogo)){
		return utility(jogo, checkWin(jogo))
	}

	int v = Integer.MIN_VALUE;

	for(Tabuleiro s : /*list*/makeSuccessors(jogo)){
		v = Math.max(v, min_Value(s.getJogo()));
	}

	return v;
}


static int min_Value(char[][] jogo){
	if(terminal_Test(jogo)){
	    return utility(jogo, checkWin(jogo));
	}
	

	int v = Integer.MAX_VALUE;

	for(Tabuleiro s : /*list*/makeSuccessors(jogo)){
		v = Math.min(v, max_Value(s.getJogo()));
	}

	return v;

}

static boolean terminal_Test(char[][] jogo){
	int v = checkWin(jogo);
	if( v == 2 || v == 3 || v == 4)
	    return true;
	else
	    return false;
}

static int utility(char[][] jogo, int a) {
    if(a == 2){
	return 0;
    }

    else if(a == 3){
	return 512;
    }

    else if(a == 4){
	return -512;
    }

    else{
	return utility_Value(jogo);
    }
}


static int utility_Value(char[][] jogo){
	int total=0;
	int temp=0;

	//horizontal
	for(int i = 0; i < 6; i++ ) {
		for(int j = 0; j < 4; j++) {
			int countX = 0, countO = 0;
			for(int k = j; k < j+4; k++){
				if(jogo[i][k]=='X') {
					countX++;
				}
				else if(jogo[i][k]=='O') {
					countO++;
				}
				
			}
			if(countX>0 && countO==0) {
				switch (countX) {
					case 1: temp=1;
					break;

					case 2: temp=10;
					break;

					case 3: temp=50;
					break;
				}
			}

			else if (countO>0 && countX==0) {
				switch(countO) {
					case 1: temp=-1;
					break;

					case 2: temp=-10;
					break;

					case 3: temp=-50;
					break;
				}
			}

			else
				temp=0;

		}

		total = total + temp;

	}

	//vertical

	for(int i = 0; i < 7; i++ ) {
		for(int j = 0; j < 3; j++) {
			int countX = 0, countO = 0;
			for(int k = j; k < j+4; k++){
				if(jogo[k][i]=='X') {
					countX++;
				}
				else if(jogo[i][k]=='O') {
					countO++;
				}
				
			}
			if(countX>0 && countO==0) {
				switch (countX) {
					case 1: temp=1;
					break;

					case 2: temp=10;
					break;

					case 3: temp=50;
					break;
				}
			}

			else if (countO>0 && countX==0) {
				switch(countO) {
					case 1: temp=-1;
					break;

					case 2: temp=-10;
					break;

					case 3: temp=-50;
					break;
				}
			}

			else
				temp=0;

			total = total + temp;
		}	
	}

	total = diagonal_Check(total, jogo);

	return total;

	    
}


static int diagonal_Check(int total, char[][] jogo){
	
	int returnable = total;
	int a=3;
	int countX = 0;
	int countO = 0;
	int opt = 0;
	for(int i=2; i>=0; i--) {
		int k=i;
		int tal = i;
		int checkervariable = 0;
		int contadorquatro = 0;

		while(checkervariable <= opt){
			for(int j=checkervariable; j<=a; j++) {
				if(matrix[k][j]=='X') {
					countX++;
				}

				else if(matrix[k][j]=='O') {
					countO++;
				}

				k++;
				contadorquatro++;
				if(contadorquatro == 4){
					break;
				}
			}

			tal++;
			k = tal;

			if(countX>0 && countO==0) {
				switch (countX) {
					case 1: temp=1;
					break;

					case 2: temp=10;
					break;

					case 3: temp=50;
					break;
				}
			}

			else if (countO>0 && countX==0) {
				switch(countO) {
					case 1: temp=-1;
					break;

					case 2: temp=-10;
					break;

					case 3: temp=-50;
					break;
				}
			}

			else
				temp=0;

			returnable += temp;
			contadorquatro = 0;
			checkervariable++;
		}

		opt++;
		countX = 0;
		countO = 0;
		a++;
	}


	a=5;
	countX = 0;
	countO = 0;
	opt = 3;

	for(int i=1; i<=3; i++) {
		int k=i;
		int tal = i;
		int checkervariable = 0;
		int contadorquatro = 0;
		while(checkervariable < opt){
			for(int j=checkervariable; j<=a; j++) {

				if(matrix[j][k]=='X') {
					countX++;

				}

				else if(matrix[j][k]=='O') {
					countO++;

				}	
				contadorquatro++;
				k++;

				contadorquatro++;
				if(contadorquatro == 4){
					break;
				}

			}

			tal++;
			k = tal;

			if(countX>0 && countO==0) {
				switch (countX) {
					case 1: temp=1;
					break;

					case 2: temp=10;
					break;

					case 3: temp=50;
					break;
				}
			}

			else if (countO>0 && countX==0) {
				switch(countO) {
					case 1: temp=-1;
					break;

					case 2: temp=-10;
					break;

					case 3: temp=-50;
					break;
				}
			}

			else
				temp=0;

			returnable += temp;
			checkervariable++;
			contadorquatro = 0;
		}
		opt--;
		countX = 0;
		countO = 0;
		a--;

	}

	int temp = 5;

	countX = 0;
	countO = 0;
	opt = 3;

	for(int i = temp; i >= 3; i--){
		int k = i;
		int checkervariable = 0;
		int contadorquatro = 0;
		while(checkervariable <= opt){
			for(int j = 0; j <= i; j++){
				if(matrix[j][k]=='X') {
					countX++;

				}

				else if(matrix[j][k]=='O') {
					countO++;

				}


				contadorquatro++;
				if(contadorquatro == 4){
					break;
				}
				k--;
			}

			if(countX>0 && countO==0) {
				switch (countX) {
					case 1: temp=1;
					break;

					case 2: temp=10;
					break;

					case 3: temp=50;
					break;
				}
			}

			else if (countO>0 && countX==0) {
				switch(countO) {
					case 1: temp=-1;
					break;

					case 2: temp=-10;
					break;

					case 3: temp=-50;
					break;
				}
			}

			else
				temp=0;

			checkervariable++;
			returnable += temp;
			contadorquatro = 0;
		}

		opt--;
		countX = 0;
		countO = 0;
	}


	countX = 0;
	countO = 0;
	opt = 3;
	a = 2;
	int k = 6;
	for(int i = k; i >= 4 ; i--){
		int checkervariable = 0;
		int contadorquatro = 0;
		while(checkervariable <= a){
			for(int j = a; j <= 5 ; j++){
				if(matrix[j][k]=='X') {
					countX++;
				}

				else if(matrix[j][k]=='O') {
					countO++;
				}

				k--;
				contadorquatro++;
				if(contadorquatro == 4){
					break;
				}
			}

			if(countX>0 && countO==0) {
				switch (countX) {
					case 1: temp=1;
					break;

					case 2: temp=10;
					break;

					case 3: temp=50;
					break;
				}
			}

			else if (countO>0 && countX==0) {
				switch(countO) {
					case 1: temp=-1;
					break;

					case 2: temp=-10;
					break;

					case 3: temp=-50;
					break;
				}
			}

			else
				temp=0;

			returnable += temp;
			contadorquatro = 0;
			checkervariable++;
		}
		k = 6;
		a--;
		countX = 0;
		countO = 0;
	}

	return returnable;

}

//ALPHABET

static int alpha_Beta(char[][] jogo){
	int v = max_Value(jogo, Integer.MIN_VALUE , Integer.MAX_VALUE);
	return makeSuccessors(jogo, v);
}

static int max_Value(char[][] jogo, int alfa, int beta){
	if(terminal_Test(jogo)){
	    return utility(jogo, checkWin(jogo));
	}

	int v = Integer.MIN_VALUE;

	for(Tabuleiro s : makeSuccessors(jogo)){
		v = Math.max(v, min_Value(s.getJogo(), alfa, beta));
		if(v >= beta){
			return v;
		}

		alfa = Math.max(alfa, v);
	}

	return v;
}

static int min_Value(char[][] jogo, alfa, beta){
	if(terminal_Test(jogo)){
		return utility(jogo, checkWin(jogo));
	}

	int v = Integer.MAX_VALUE;

	for(Tabuleiro s : makeSuccessors(jogo)){
		v = Math.min(v, max_Value(s.getJogo(), alfa, beta));
		if(v <= alfa){
			return v; //momento da poda
		}

		beta = Math.min(beta, v);
	}

	return v;
}

//MINIMAX

static int mini_Max(char[][] jogo){
	int v = max_Value(jogo);
	return makeSuccessors(jogo, v);
}

char[][] temp = new char[6][7];
	for(int i = 0; i < 6; i++){
		for(int j = 0; j < 7; j++){
			temp[i][j] = jogo[i][j];
		}
	}

static int max_Value(char[][] jogo){
	if(terminal_Test(jogo)){
		return 
	}

	int v = Integer.MIN_VALUE;

	for(Tabuleiro s : /*list*/makeSuccessors(jogo)){
		v = Math.max(v, min_Value(s.getJogo()));
	}

	return v;
}


static int min_Value(char[][] jogo){
	if(terminal_Test(jogo)){
		return 
	}
	

	int v = Integer.MAX_VALUE;

	for(Tabuleiro s : /*list*/makeSuccessors(jogo)){
		v = Math.min(v, max_Value(s.getJogo()));
	}

	return v;

}

static boolean terminal_Test(char[][] jogo){
	int v = checkWin(jogo);
	if(v == 2){
		
	}
}


//ALPHABET

static int alpha_Beta(char[][] jogo){
	int v = max_Value(jogo, Integer.MIN_VALUE , Integer.MAX_VALUE);
	return makeSuccessors(jogo, v);
}

static int max_Value(char[][] jogo, alfa, beta){
	if(terminal_Test(jogo)){
		return 
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
		return 
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

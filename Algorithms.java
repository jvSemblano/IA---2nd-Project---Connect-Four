static int miniMax(char[][] jogo){
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

}
static LinkedList<Node> makeSuccessors(char[][] jogo){
	LinkedList<Node> filhos = new LinkedList<Node>();

	for(int i = 0; i < 7; i++){
		if(jogo[0][i] ==  '-'){
			char[][] temp = new char[6][7];
			for(int j = 0; j < 6; j++){
				for(int z = 0; z < 7; z++){
					temp[j][z] = jogo[j][z];
				}
			}

			for(int j = 5; j <= 0; j--){
				if(temp[j][i] == '-'){
					temp[j][i] = 'O';
					break;
				}
			}

			filhos.add(new Node(temp, jogo, i, utility(temp, 1)))
		}
	}

	return filhos;
}

class Node{
	
	private char[][] game;
	private Node pai;
	private int column;
	private int value;
	
	Node(char[][] game, Node pai, int column, int value){
		this.game = game;
		this.pai = pai;
		this.column = column;
		this.value = value;
	}
}
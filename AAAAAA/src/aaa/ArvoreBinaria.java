package aaa;

public class ArvoreBinaria {
   private No raiz;
   
   public ArvoreBinaria() {
	   this.raiz = null;
   }
   
   public void insere(int valor) {
	   // aqui cria o novo no setando apenas o valor, caso seja o primeiro, raiz recebe novo
	   No novo = new No(valor, null, null);
	   if (this.raiz == null) {
		   this.raiz = novo;
	   } else {
		   // caso não esteja vazio cria um no para percorrer a arvore e o pai para que seja possivel criar uma conexão entre os "galhos" 
		   // da árvore
		   No atual = raiz;
		   No pai;
		   // while com um break manual (no caso return pq encerra até o método, não apenas o loop. Funciona apenas se a funcao for void)
		   // usado para percorrer a arvore
		   while (true) {
			   pai = atual;
			   // if para descobrir se o valor é menor ou maior para definir para onde vai o no
			   if (valor <= atual.getValor()) { // ir para a esquerda
				   atual = atual.getEsquerda();
				   if (atual == null) {
					   pai.setEsquerda(novo);
					   System.out.println("No com valor: " + novo.getValor() + " inserido à esquerda.");
					   return;
				   }
			   } else { // ir para a direita
				   atual = atual.getDireita();
				   if (atual == null) {
					   pai.setDireita(novo);
					   System.out.println("No com valor: " + novo.getValor() + " inserido à direita.");
					   return;
				   }
			   }
		   }
	   }
   }
   
   public No retornaRaiz() {
	   return  this.raiz;
   }
   
   // COMO ESSA POORA FUNCIONA??????????????????
   public void preOrdem(No atual) {
	   if (atual != null) { // aqui é realmente se não for null, mas como?? Ahhh talvez entendi.
		   // ele chama a função dentro da função, ou seja, ela não acaba se a condição não satisfazer
		   System.out.println(atual.getValor());
		   preOrdem(atual.getEsquerda());
		   preOrdem(atual.getDireita());
	   }
   }
   
   public void emOrdem(No atual) {
	   if (atual != null) {
		   emOrdem(atual.getEsquerda());
		   System.out.println(atual.getValor());
		   emOrdem(atual.getDireita());
	   }
   }
   
   public void posOrdem(No atual) {
	   if (atual != null) {
		   posOrdem(atual.getEsquerda());
		   posOrdem(atual.getDireita());
		   System.out.println(atual.getValor());
	   }
   }
	
   public int altura (No atual) {
	   if (atual == null || atual.getEsquerda() == null && atual.getDireita() == null) {
		   return 0;
	   } else {
		   // MAS QUE KRLH ESSA PORRA É MAGICA? DESCOBRE O TAMANHO SOZINHO??????
		   // ESSA CONDIÇÃO NAO FAZ O MENOR SENTIDO
		   if (altura(atual.getEsquerda()) > altura(atual.getDireita())) { // ENTENDI, FUNÇÃO RECURSIVA. 
			   //PRECISO ESTUDAR MAIS SOBRE RECURSIVIDADE 
			   // pq o 1 + ?
			   return (1 + altura(atual.getEsquerda()));
		   } else {
			   return (1 + altura(atual.getDireita()));
		   }
	   }
   }
   
   public int folhas (No atual) {
	   if (atual == null) {
		   return 0;
	   }
	   if (atual.getEsquerda() == null && atual.getDireita() == null) {
		   return 1;
	   }
	   return folhas(atual.getEsquerda()) + folhas(atual.getDireita()); 
   }
   
   public int contaNos (No atual) {
	   if (atual == null) {
		   return 0;
	   } else {
		   return (1 + contaNos(atual.getEsquerda()) + contaNos(atual.getDireita()));
	   }
   }
   
   public No valorMinimo() {
	   No atual = this.raiz;
	   No pai = null;
	   while (atual != null) {
		   pai = atual;
		   atual.getEsquerda();
	   }
	   return pai;
   }
   
   public No valorMaximo() {
	   No atual = raiz;
	   No pai = null;
	   while (atual != null) {
		   pai = atual;
		   atual.getDireita();
	   }
	   return pai;
   }
   
   public boolean remove (int valor) {
	   // encontrar elemento
	   if (this.raiz == null) {
		   System.out.println("Árvore vazia.");
		   return false;
	   }
	   
	   No atual = raiz;
	   No pai = raiz;
	   boolean filhoEsquerda = true;
	   
	   while(atual.getValor() != valor) {
		   pai = atual;
		   if (valor <= atual.getValor()) { // vou buscar árvore a direita
			   atual = atual.getEsquerda();
			   filhoEsquerda = true;
		   } else { // vou buscar a subarvore a direita
			   atual = atual.getDireita();
			   filhoEsquerda = false;
		   }
		   if (atual == null) {
			   return false;
		   }
	   }
	   
	   // encontramos o valor a ser removido
	   if (atual.getEsquerda() == null && atual.getDireita() == null) { // removendo quando é nó folha
		   if (atual == raiz) {
			   raiz = null;
		   } else if (filhoEsquerda){
			   pai.setEsquerda(null);
		   } else {
			   pai.setDireita(null);
		   }
	   } else if(atual.getDireita() == null) { // removendo quando não tem filho a direita
		   if(atual == raiz) {
			  raiz = raiz.getEsquerda();
		   } else if (filhoEsquerda) {
			   pai.setEsquerda(atual.getEsquerda());
		   } else {
			   pai.setDireita(atual.getEsquerda());
		   }
	   } else if (atual.getEsquerda() == null) { // removendo quando não tem filho a esquerda
		   if (atual == raiz) {
			   raiz = raiz.getDireita();
		   } else if(filhoEsquerda) {
			   pai.setEsquerda(atual.getDireita());
		   } else {
			   pai.setDireita(atual.getDireita());
		   }
	   }
	   // remover elemento
	   return true;
   }
	
}